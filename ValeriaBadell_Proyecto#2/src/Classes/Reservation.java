/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;


public class Reservation {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String gender;
    private String room_type;
    private String phone_number;
    private String arrival_date;
    private String departure_date;
    private Reservation left_son;
    private Reservation right_son;
    private int height;

    public Reservation(int id, String name, String lastName, String email, String gender, String room_type, String phone_number, String arrival_date, String departure_date) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.room_type = room_type;
        this.phone_number = phone_number;
        this.arrival_date = arrival_date;
        this.departure_date = departure_date;
        this.left_son = null;
        this.right_son = null;
        this.height = 0;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + this.name + " " + this.lastName + "\nCorreo: " + this.email + "\nGenero: " + this.gender + "\nCelular: " + this.phone_number + "\nLlegada: " +
                this.arrival_date + "\nSalida: " + this.departure_date;
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
     * @return the room_type
     */
    public String getRoom_type() {
        return room_type;
    }

    /**
     * @param room_type the room_type to set
     */
    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    /**
     * @return the phone_number
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * @param phone_number the phone_number to set
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * @return the arrival_date
     */
    public String getArrival_date() {
        return arrival_date;
    }

    /**
     * @param arrival_date the arrival_date to set
     */
    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    /**
     * @return the departure_date
     */
    public String getDeparture_date() {
        return departure_date;
    }

    /**
     * @param departure_date the departure_date to set
     */
    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    /**
     * @return the left_son
     */
    public Reservation getLeft_son() {
        return left_son;
    }

    /**
     * @param left_son the left_son to set
     */
    public void setLeft_son(Reservation left_son) {
        this.left_son = left_son;
    }

    /**
     * @return the right_son
     */
    public Reservation getRight_son() {
        return right_son;
    }

    /**
     * @param right_son the right_son to set
     */
    public void setRight_son(Reservation right_son) {
        this.right_son = right_son;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    
}
