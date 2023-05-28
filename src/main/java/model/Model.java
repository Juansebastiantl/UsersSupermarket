/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Juansebastiantl
 */
public class Model {
    private String name;
    private int id;
    private String date;
    private String userType;
    private String points;

    public String getName(){
    return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getuserType() {
        return userType;
    }
    public void setuserType(String userType) {
        this.userType = userType;
    }
    
    public String getPoints() {
        return points;
    }
    public void setPoints(String points) {
        this.points = points;
    }
    
}
