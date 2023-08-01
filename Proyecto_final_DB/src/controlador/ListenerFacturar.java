/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.itextpdf.text.DocumentException;
import com.mysql.cj.result.LocalDateTimeValueFactory;
import java.sql.Statement;
import conexion.ConexionOracle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cabecera_Factura;
import modelo.DefaultListaDetalles;
import modelo.Detalle_Factura;
import vista.VistaGeneralSistema;
import vista.VistaLogin;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.ConexionOracle;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.DefaultTablaDetalles;
import vista.VistaGeneralSistema;

/**
 *
 * @author XaviO_o
 */
public class ListenerFacturar implements ActionListener {

    String sSQL = "";
    ConexionOracle conexion;
    VistaLogin vl;
    PreparedStatement ps = null;
    Connection con;
    VistaGeneralSistema vGeneral;
    ListenerAddServicio lladdService;
    Cabecera_Factura factura = null;
    ArrayList<Detalle_Factura> detallesList = new ArrayList<>();
    DefaultListaDetalles listaDetalles;
    DefaultTablaDetalles tablaDetalles;
    FileOutputStream archivo = null;
    String nombreArchivoEnviar = "";

    public ListenerFacturar(ConexionOracle conexion, VistaLogin vl, VistaGeneralSistema vGeneral, Connection con, ListenerAddServicio lladdService, DefaultListaDetalles listaDetalles, DefaultTablaDetalles tablaDetalles) {
        this.conexion = conexion;
        this.vl = vl;
        this.vGeneral = vGeneral;
        this.con = con;
        this.lladdService = lladdService;
        this.listaDetalles = listaDetalles;
        this.tablaDetalles = tablaDetalles;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            detallesList = lladdService.getListDetalles();
            factura = lladdService.getFactura();
            agregarFacturaBD();
            factura.setCodigo_cb(extraercodigo());
            agregarDetallesFacturaBD(factura.getCodigo_cb());
            enviarCorreo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vGeneral, "Seleccione los los servicios antes de facturar");
        }
    }

    private void agregarFacturaBD() {
        try {
            String fechaHoraDate = String.valueOf(factura.getFecha_emision());
            String[] fechaVector = fechaHoraDate.split("T");
            String fecha = fechaVector[0];
            String hora = fechaVector[1];
            float subTotal = factura.getSubtotal();
            float valorIva = factura.getValor_iva();
            float total = factura.getTotal();
            int asuCodigo = factura.getUsuario().getCodigo_u();
            int cliCodigo = factura.getCliente().getCodigo_p();
            ps = con.prepareStatement("INSERT INTO veterinaria.vt_cabeceras_facturas VALUES(veterinaria.proximo_valor_fac_seq, TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS.FF'), ?, ?, ?, ?, ?)");
            ps.setString(1, fecha + " " + hora);
            ps.setFloat(2, subTotal);
            ps.setFloat(3, valorIva);
            ps.setFloat(4, total);
            ps.setInt(5, asuCodigo);
            ps.setInt(6, cliCodigo);
            int filas = ps.executeUpdate();
            con.setAutoCommit(false);

            if (filas == 1) {
                con.commit();
                JOptionPane.showMessageDialog(vGeneral, "Factura generada con exito");
                LocalDateTime fechaLocal = LocalDateTime.now();
                vGeneral.getFechaVista().setText(String.valueOf(fechaLocal));
                int codigoFactura = extraercodigo();
                vGeneral.getIdFactura().setText("VTCF0" + codigoFactura);

            } else {
                JOptionPane.showMessageDialog(vl, "Algo fallo durante el proceso");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
    }

    private int extraercodigo() {
        int codigo = 0;
        try {
            sSQL = "SELECT fac_codigo FROM veterinaria.vt_cabeceras_facturas ORDER BY 1 DESC FETCH FIRST ROW ONLY";

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                codigo = res.getInt("fac_codigo");
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
        return codigo;
    }

    private void agregarDetallesFacturaBD(int facCodigo) {
        for (int i = 0; i < detallesList.size(); i++) {
            Detalle_Factura detalle = detallesList.get(i);
            try {
                int cantidad = detalle.getCantidad();
                float precioUnitario = detalle.getPrecio_unitario();
                float subTotal = detalle.getSubtotal();
                float valorIva = detalle.getValor_iva();
                float total = detalle.getTotal();
                int serCodigo = detalle.getServicio().getCodigo_s();

                ps = con.prepareStatement("INSERT INTO veterinaria.vt_detalles_facturas VALUES(veterinaria.proximo_valor_det_seq, ?, ?, ?, ?, ?, ?, ?)");
                ps.setInt(1, cantidad);           // Proporciona el valor para det_cantidad
                ps.setFloat(2, precioUnitario);   // Proporciona el valor para det_precio_unitario
                ps.setFloat(3, subTotal);         // Proporciona el valor para det_subtotal
                ps.setFloat(4, valorIva);         // Proporciona el valor para det_valor_iva
                ps.setFloat(5, total);            // Proporciona el valor para det_total
                ps.setInt(6, facCodigo);          // Proporciona el valor para fac_codigo
                ps.setInt(7, serCodigo);          // Proporciona el valor para ser_codigo
                int filas = ps.executeUpdate();
                con.setAutoCommit(false);

                if (filas == 1) {
                    con.commit();
                    JOptionPane.showMessageDialog(vGeneral, "Detalle generado con exito");

                } else {
                    JOptionPane.showMessageDialog(vGeneral, "Algo fallo durante el proceso");
                }
            } catch (SQLException x) {
                System.out.println(x);
                System.out.println("no");
            }
        }
    }

    private void enviarCorreo() {
        generarFacturaPDF();
        //envioCorreo(String emailTo, File mArchivosAdjuntos, String nombres_archivos) 
        System.out.println("buscandi archivo");
        String correoCliente = vGeneral.getCorreoGen().getText();
        String rutaRelativa2 = "Juan Pedro Alvarado JaramilloVTCF043.pdf";
        File f = new File(rutaRelativa2);
        envioCorreo envio = new envioCorreo(correoCliente, "Factura Veterinaria VET_HEALTS", f);
        String content = "Este es un correo de validacion para su factur, gracias por preferir nuestros servicios";
        
        envio.enviarCorreo(content);
        envio.sendEmail();
        setearCamposVgeneral();

    }

    public void setearCamposVgeneral() {
        vGeneral.getCedulaGen().setText("");
        vGeneral.getNombreGen().setText("");
        vGeneral.getDireccionGen().setText("");
        vGeneral.getCorreoGen().setText("");
        vGeneral.getTelefonoGen().setText("");
        vGeneral.getIdFactura().setText("");
        vGeneral.getFechaVista().setText("");
        vGeneral.getCedulacam().setText("");
        vGeneral.getSubtotalGen().setText("");
        vGeneral.getTotalIvaGen().setText("");
        vGeneral.getTotalGen().setText("");
        vGeneral.getServicioBox().setSelectedIndex(0);
        listaDetalles.clearAllElements();
    }

    public void generarFacturaPDF() {
        try {

            String nombresCliente = vGeneral.getNombreGen().getText();
            nombreArchivoEnviar = nombresCliente + vGeneral.getIdFactura().getText();
            archivo = new FileOutputStream(nombreArchivoEnviar + ".pdf");
            Document documento = new Document();
            documento.setMargins(1, 1, 20, 20);
            PdfWriter.getInstance(documento, archivo);
            documento.open();

            String nomEm = "VetHearts Veterinaria";
            String correoEm = "Upsproyectoveterinaria@gmail.com";
            String telEm = "+593 996142527";
            String dirEm = "Universidad Politécnica Salesiana" + "\n" + "Fundamento de base de datos - Computación";

            String cedulaCliente = vGeneral.getCedulaGen().getText();
            String direccionCliente = vGeneral.getDireccionGen().getText();
            String telefonoCliente = vGeneral.getTelefonoGen().getText();
            String correoCliente = vGeneral.getCorreoGen().getText();

            PdfPTable table1 = new PdfPTable(2);

            String imagePath = "src\\imagenes\\logotexto.png";
            Image image = Image.getInstance(imagePath);
            image.scaleToFit(10, 10);
            PdfPCell logoCell = new PdfPCell(image, true);
            logoCell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            logoCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            logoCell.setBorder(PdfPCell.NO_BORDER);

            // Celda 2: Texto "Factura"
            Font fontnumfac = new Font(Font.FontFamily.HELVETICA, 20); // Tamaño de fuente para "Factura N°"
            Font fontFecha = new Font(Font.FontFamily.HELVETICA, 12); // Tamaño de fuente para "Fecha de facturación"

            Paragraph paragraph = new Paragraph();
            Chunk chunkFactura = new Chunk("Factura N°: " + vGeneral.getIdFactura().getText(), fontnumfac);
            Chunk chunkFecha = new Chunk("\n\nFecha: " + vGeneral.getFechaVista().getText(), fontFecha);
            paragraph.add(chunkFactura);
            paragraph.add(chunkFecha);

            PdfPCell textCell = new PdfPCell(paragraph);
            textCell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            textCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            textCell.setBorder(PdfPCell.NO_BORDER);

            table1.addCell(textCell);
            table1.addCell(logoCell);

            PdfPTable table2 = new PdfPTable(2);
            Font fontInfo = new Font(Font.FontFamily.HELVETICA, 10);

            Paragraph empInfo = new Paragraph("Datos de la empresa" + "\n\n"
                    + nomEm + "\n"
                    + correoEm + "\n"
                    + telEm + "\n"
                    + dirEm + "\n",
                    fontInfo
            );
            PdfPCell infoempCell = new PdfPCell(empInfo);
            infoempCell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            infoempCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            infoempCell.setBorder(PdfPCell.NO_BORDER);

            Paragraph clienteInfo = new Paragraph("Datos del cliente" + "\n\n"
                    + cedulaCliente + "\n"
                    + nombresCliente + "\n"
                    + telefonoCliente + "\n"
                    + correoCliente + "\n"
                    + direccionCliente + "\n",
                    fontInfo
            );
            PdfPCell infocliCell = new PdfPCell(clienteInfo);
            infocliCell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            infocliCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            infocliCell.setBorder(PdfPCell.NO_BORDER);

            PdfPCell espacioCell = new PdfPCell();
            espacioCell.setColspan(2); // Establecer que ocupe las 2 columnas
            espacioCell.addElement(new Paragraph("\n\n")); // Añadir espacio en blanco
            espacioCell.setBorder(PdfPCell.NO_BORDER);

            table2.addCell(espacioCell);

            table2.addCell(infocliCell);
            table2.addCell(infoempCell);

            PdfPCell espacioCell2 = new PdfPCell();
            espacioCell2.setColspan(2);
            espacioCell2.addElement(new Paragraph("\n\n"));
            espacioCell2.setBorder(PdfPCell.NO_BORDER);

            table2.addCell(espacioCell2);

            // Añadir la tabla de servicios al documento
            Font customFont = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK);
            //PdfPTable pdfTable = new PdfPTable(tablaDet.getColumnCount()); 
            float[] columnWidths = {0.5f, 1f, 1f, 0.5f, 0.5f, 0.5f};
            PdfPTable pdfTable = new PdfPTable(columnWidths);
            // Agregar las cabeceras de las columnas
            for (int column = 0; column < tablaDetalles.getColumnCount(); column++) {
                PdfPCell cell = new PdfPCell(new Paragraph(tablaDetalles.getColumnName(column), customFont));
                cell.setHorizontalAlignment(cell.ALIGN_CENTER);
                pdfTable.addCell(cell);

            }

            // Agregar los datos de las filas
            for (int row = 0; row < tablaDetalles.getRowCount(); row++) {
                for (int column = 0; column < tablaDetalles.getColumnCount(); column++) {
                    Object value = tablaDetalles.getValueAt(row, column);
                    PdfPCell cell;
                    if (column == 1) { // Columnas 1 y 2 (índices 0 y 1 en base 0) tendrán alineación centrada
                        cell = new PdfPCell(new Paragraph(String.valueOf(value), customFont));
                        cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                    } else { // Las demás columnas tendrán alineación a la derecha
                        cell = new PdfPCell(new Paragraph(String.valueOf(value), customFont));
                        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                    }
                    pdfTable.addCell(cell);
                }

            }

            PdfPTable table3 = new PdfPTable(1);
            Font fontInf = new Font(Font.FontFamily.HELVETICA, 10);

            Paragraph total = new Paragraph(
                    "Subtotal: " + vGeneral.getSubtotalGen().getText() + "\n"
                    + "Total IVA 12%: " + vGeneral.getTotalIvaGen().getText() + "\n"
                    + "Total: " + vGeneral.getTotalGen().getText(),
                    fontInf
            );
            PdfPCell infoTotal = new PdfPCell(total);
            infoTotal.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            infoTotal.setVerticalAlignment(PdfPCell.ALIGN_LEFT);
            infoTotal.setBorder(infoTotal.NO_BORDER);

            table3.addCell(espacioCell);
            table3.addCell(infoTotal);

            documento.add(table1);
            documento.add(table2);
            documento.add(pdfTable);
            documento.add(table3);

            documento.close();
            JOptionPane.showMessageDialog(null, "Archivo pdf Genrado");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListenerFacturar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Archivo denegado");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Archivo denegado");
        }

    }

}
