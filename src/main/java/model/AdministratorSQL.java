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
    private String database = "db_miercoles";
    String[] datos_obtenidos = new String[100];
    //List<String> listaResultados = Arrays.asList();
    ArrayList<String> listaResultados = new ArrayList<>();
    //List<List<String>> ejemploLista = new ArrayList<List<String>>();
    
  
    public boolean connect(){
        try {
        obj_connection = DriverManager.getConnection(url+"/"+database, user, passw);
        JOptionPane.showMessageDialog(null, "Succesful connection");
        return true;
        } catch(SQLException err) {
                JOptionPane.showMessageDialog(null, err);
                return false;
        }
        
    }
    
    public void register(String name, int id, String date){
        try {
        String instruction = "INSERT INTO users VALUES('"+ name +"', "+ id + ",'"+ date +" ')";
        obj_connection.prepareStatement(instruction).execute();
        JOptionPane.showMessageDialog(null, "User Registered");
        } catch (SQLException err){
          JOptionPane.showMessageDialog(null, err);
        }
    }
    

    
        public ArrayList<String> consult(){
        try {
        String instruction = "SELECT * FROM users;";
        String fullname = "";
        String id = "";
        String birthday = "";
        var registro = obj_connection.prepareStatement(instruction).executeQuery();
        datos_obtenidos[0] = "A";
         while (registro.next()) {
             fullname = registro.getString(1);
             id = registro.getString(2);
             birthday = registro.getString(3);
             listaResultados.add(fullname);
             listaResultados.add(id);
             listaResultados.add(birthday);
           // JOptionPane.showMessageDialog(null,(ejemploLista.get(1).get(1)));
            }
        return listaResultados;
        
        } catch (SQLException err){
          JOptionPane.showMessageDialog(null, err);
         return listaResultados;
        }
    }
    
}
