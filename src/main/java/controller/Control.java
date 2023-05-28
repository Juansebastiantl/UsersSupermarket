/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.View;
import model.Model;
import model.AdministratorSQL;

/**
 *
 * @author Juansebastiantl
 */
public class Control {

    private View obj_view;
    private Model obj_model;
    private AdministratorSQL obj_AdministratorSQL;
    private boolean confirmation;

    public Control(View obj_view, Model obj_model, AdministratorSQL obj_AdministratorSQL) {

        this.obj_view = obj_view;
        this.obj_model = obj_model;
        this.obj_AdministratorSQL = obj_AdministratorSQL;
        start_view();
        confirmation = this.obj_AdministratorSQL.connect();
        this.obj_view.btnRegister.addActionListener(btn_register);
        this.obj_view.btnConsult.addActionListener(btn_consult);
        this.obj_view.btnConsultByUser.addActionListener(btn_consultbyuser);
    }

    private void start_view() {
        obj_view.setVisible(true);
        obj_view.setLocationRelativeTo(null);
        for (int i = 1; i <= 31; i++) {
            obj_view.optionDay.addItem(String.valueOf(i));
        }
        for (int i = 1900; i <= 2100; i++) {
            obj_view.optionYear.addItem(String.valueOf(i));
        }
    }

    private void establish_user() {
        obj_model.setuserType(obj_view.optionClient.getSelectedItem().toString());
        obj_model.setName(obj_view.txtName.getText());
        obj_model.setId(Integer.parseInt(obj_view.txtId.getText()));
        obj_model.setDate(obj_view.optionDay.getSelectedItem() + "-" + obj_view.optionMonth.getSelectedItem() + "-" + obj_view.optionYear.getSelectedItem());
        obj_model.setPoints(obj_view.txtPoints.getText());
    }
    
    private void establish_user_consult() {
         obj_model.setuserType(obj_view.optionClientConsult.getSelectedItem().toString());
    }
    
    public void cleanTxtArea() {
        obj_view.txtResult1.setText(null);
        obj_view.txtResult2.setText(null);
    }

    ActionListener btn_register = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (confirmation) {
                establish_user();
                obj_AdministratorSQL.register(obj_model.getuserType(), obj_model.getName(), obj_model.getId(), obj_model.getDate(), obj_model.getPoints());
            } else {
                JOptionPane.showMessageDialog(null, "Is not possible register the user because there is an error in the connecion database");
            }
        }
    };

    ActionListener btn_consult = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> listaResultados;
            StringBuilder builder = new StringBuilder();
            int espacio = 0;
            if (confirmation) {
                cleanTxtArea();
                listaResultados = obj_AdministratorSQL.consult();
                for (int i = 0; i < listaResultados.size(); i++) {
                    espacio = espacio + 1;
                    builder.append(listaResultados.get(i));
                    builder.append(" ");
                    if (espacio == 5) {
                        builder.append("\n");
                        espacio = 0;
                    }
                }
                obj_view.txtResult1.setText(builder.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Is not possible register the user because there is an error in the connecion database");
            }
        }
    };

    ActionListener btn_consultbyuser = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            establish_user_consult();
            ArrayList<String> listaResultadosByUsers;
            StringBuilder builder = new StringBuilder();
            int espacio = 0;
            if (confirmation) {
                cleanTxtArea();
                listaResultadosByUsers = obj_AdministratorSQL.consultCargo(obj_model.getuserType());
                for (int i = 0; i < listaResultadosByUsers.size(); i++) {
                    espacio = espacio + 1;
                    builder.append(listaResultadosByUsers.get(i));
                    builder.append(" ");
                    if (espacio == 5) {
                        builder.append("\n");
                        espacio = 0;
                    }
                }
                obj_view.txtResult2.setText(builder.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Is not possible register the user because there is an error in the connecion database");
            }
        }
    };

}
