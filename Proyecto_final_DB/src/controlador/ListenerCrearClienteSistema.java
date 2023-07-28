/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.CrearClientes;

/**
 *
 * @author Anthony Moya
 */
public class ListenerCrearClienteSistema implements ActionListener {

    CrearClientes cr;
    ConexionOracle co;

    public ListenerCrearClienteSistema(CrearClientes cr, ConexionOracle co) {
        this.cr = cr;
        this.co = co;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cr.getjComboBoxTipoDoc().getSelectedItem().equals("Cedula")) {
            boolean validacion_doc = idValidator(cr.getjTextFieldNDoc().getText());
            System.out.println(validacion_doc);
            boolean validacion_mail = correoValidator(cr.getjTextFieldCorreo().getText());
            System.out.println(validacion_mail);
            boolean validacion_mail_rep = correoValidator(cr.getjTextFieldCorreoRep().getText());
            System.out.println(validacion_mail_rep);
            boolean validacion_total = cr.getjTextFieldCorreo().getText().equals(cr.getjTextFieldCorreoRep().getText());
            System.out.println(validacion_total);
            if (validacion_doc == true && validacion_mail == true && validacion_mail_rep == true && validacion_total == true) {
                System.out.println("puedes ingresar datos");
            } else {
                JOptionPane.showMessageDialog(cr, "Datos Invalidos");
            }
        }else{JOptionPane.showMessageDialog(cr, "Sleccione Identificacion");}
    }

    public boolean idValidator(String id) {
//banderas de identificación
        boolean validId;

        if (id.length() == 10) { //Longitud de la cédula      
            int thirdDigit = Integer.parseInt(id.substring(2, 3));
            if (thirdDigit < 6) {
                // Coeficientes de validación cédula
                // El decimo digito se lo considera dígito verificador
                int[] idValCoef = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                int checker = Integer.parseInt(id.substring(9, 10));
                int addition = 0;
                int digit = 0;
                for (int i = 0; i < (id.length() - 1); i++) {
                    digit = Integer.parseInt(id.substring(i, i + 1)) * idValCoef[i];
                    addition += ((digit % 10) + (digit / 10));
                }

                if ((addition % 10 == 0) && (addition % 10 == checker)) {
                    validId = true;
                } else if ((10 - (addition % 10)) == checker) {
                    validId = true;
                } else {
                    validId = false;
                }
            } else {
                validId = false;
            }
        } else {
            validId = false;
        }

        return validId;
    }

    public boolean correoValidator(String correo) {
        boolean matches = correo.matches("\\b[a-z0-9]+@(outlook|yahoo|gmail|hotmail)\\.com\\b");
        return matches;
    }

}
