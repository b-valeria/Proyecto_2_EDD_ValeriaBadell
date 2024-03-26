/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;


public class RoomRecord {
    private String name;
    private String lastName;
    private String email;
    private String gender;
    private String date_arrival;
    private int id;
    private RoomRecord left_son;
    private RoomRecord right_son;

    public RoomRecord(String name, String lastName, String email, String gender, String arrival_date, int id) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.date_arrival = arrival_date;
        this.id = id;
        this.right_son = null;
        this.left_son = null;
    }

/**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the date_arrival
     */
    public String getDate_arrival() {
        return date_arrival;
    }

    /**
     * @param date_arrival the date_arrival to set
     */
    public void setDate_arrival(String date_arrival) {
        this.date_arrival = date_arrival;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the left_son
     */
    public RoomRecord getLeft_son() {
        return left_son;
    }

    /**
     * @param left_son the left_son to set
     */
    public void setLeft_son(RoomRecord left_son) {
        this.left_son = left_son;
    }

    /**
     * @return the right_son
     */
    public RoomRecord getRight_son() {
        return right_son;
    }

    /**
     * @param right_son the right_son to set
     */
    public void setRight_son(RoomRecord right_son) {
        this.right_son = right_son;
    }

    
    
    
    
    
    
}
