/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Juansebastiantl
 */
public class AdministratorSQL {

    private Connection obj_connection;
    private String user = "root";
    private String passw = "1234";
    private String url = "jdbc:mysql://localhost:3306";
    private String database = "db_supermarket";
    String[] datos_obtenidos = new String[100];
    //List<String> listaResultados = Arrays.asList();
    ArrayList<String> listaResultados = new ArrayList<>();
    ArrayList<String> listaResultadosByUser = new ArrayList<>();
    //List<List<String>> ejemploLista = new ArrayList<List<String>>();

    public boolean connect() {
        try {
            obj_connection = DriverManager.getConnection(url + "/" + database, user, passw);
            JOptionPane.showMessageDialog(null, "Succesful connection");
            return true;
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err);
            return false;
        }

    }

    public void register(String usertype, String name, int id, String date, String points) {
        // public void register(String name, int id, String date){
        try {
            String instruction = "INSERT INTO users VALUES('" + usertype + "','" + name + "', " + id + ",'" + date + " ','" + points + " ')";
            obj_connection.prepareStatement(instruction).execute();
            JOptionPane.showMessageDialog(null, "User Registered");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err);
        }
    }

    public ArrayList<String> consult() {
        listaResultados.clear();
        try {
            String instruction = "SELECT * FROM users;";
            String fullname = "";
            String id = "";
            String birthday = "";
            String userType = "";
            String points = "";
            var registro = obj_connection.prepareStatement(instruction).executeQuery();
            datos_obtenidos[0] = "A";
            while (registro.next()) {
                userType = registro.getString(1);
                fullname = registro.getString(2);
                id = registro.getString(3);
                birthday = registro.getString(4);
                points = registro.getString(5);
                listaResultados.add(userType);
                listaResultados.add(fullname);
                listaResultados.add(id);
                listaResultados.add(birthday);
                listaResultados.add(points);
                // JOptionPane.showMessageDialog(null,(ejemploLista.get(1).get(1)));
            }
            return listaResultados;

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err);
            return listaResultados;
        }
    }
    
    public ArrayList<String> consultCargo(String usertype) {
        listaResultadosByUser.clear();
         try {
            String instruction = "SELECT * FROM db_supermarket.users WHERE usertype = '"+ usertype +"';";
            String fullname = "";
            String id = "";
            String birthday = "";
            String userType = "";
            String points = "";
            var registro = obj_connection.prepareStatement(instruction).executeQuery();
            datos_obtenidos[0] = "A";
            while (registro.next()) {
                userType = registro.getString(1);
                fullname = registro.getString(2);
                id = registro.getString(3);
                birthday = registro.getString(4);
                points = registro.getString(5);
                listaResultadosByUser.add(userType);
                listaResultadosByUser.add(fullname);
                listaResultadosByUser.add(id);
                listaResultadosByUser.add(birthday);
                listaResultadosByUser.add(points);
                // JOptionPane.showMessageDialog(null,(ejemploLista.get(1).get(1)));
            }
            return listaResultadosByUser;

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err);
            return listaResultadosByUser;
        }
    }
    
}
