/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.usersSupermarket;
import view.View;
import model.Model;
import controller.Control;
import model.AdministratorSQL;
/**
 *
 * @author Juansebastiantl
 */
public class UsersSupermarket {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        View obj_view = new View();
        Model obj_model =  new Model();
        AdministratorSQL obj_Administrator = new AdministratorSQL();
        Control obj_control =  new Control(obj_view, obj_model, obj_Administrator);

        //obj_view.setVisible(true);
        //obj_view.setLocationRelativeTo(null);
    }
}
