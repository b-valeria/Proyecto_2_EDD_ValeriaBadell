/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;


public class Guest {
    private String name;
    private String lastName;
    private String email;
    private String gender;
    private String arrival_date;
    private String phone_number;
    private int hab_number;
    private Guest pNext;

    public Guest(String name, String lastName, String email, String gender, String phone_number, String arrival_date, int hab_number) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.arrival_date = arrival_date;
        this.phone_number = phone_number;
        this.hab_number = hab_number;
        pNext = null;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + this.name + "\nApellido: " + this.lastName + "\nCorreo: "+ this.email + "\nGenero: "+this.gender + "\nCelular: "+this.phone_number + "\nLlegada: " + this.arrival_date + "\nNro Habitacion: " + this.hab_number;
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
     * @return the hab_number
     */
    public int getHab_number() {
        return hab_number;
    }

    /**
     * @param hab_number the hab_number to set
     */
    public void setHab_number(int hab_number) {
        this.hab_number = hab_number;
    }

    /**
     * @return the pNext
     */
    public Guest getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Guest pNext) {
        this.pNext = pNext;
    }
}
