/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleList;

import Classes.Guest;

public class SimpleList_Guests {

    private Guest pFirst;
    private Guest pLast;

    public SimpleList_Guests() {
        this.pFirst = this.pLast = null;
    }

    /**
     * @return the pFirst
     */
    public Guest getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Guest pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Guest getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Guest pLast) {
        this.pLast = pLast;
    }

    public void insertGuestList(String name, String lastName, String email, String gender, String phone_number, String arrival_date, int hab_number) {
        Guest newGuest = new Guest(name, lastName, email, gender, phone_number, arrival_date, hab_number);
        if (this.getpFirst() == null) {
            this.setpFirst(this.pLast = newGuest);
        } else {
            this.getpLast().setpNext(newGuest);
            this.setpLast(newGuest);
        }
    }

    public void deleteGuestList(String name, String lastName) {
        if (this.getpFirst() != null) {
            if (this.getpFirst().getName().toLowerCase().equals(name) || this.getpFirst().getLastName().toLowerCase().equals(lastName)) {
                Guest auxiliarGuest = this.getpFirst();
                while (auxiliarGuest.getpNext() != null && (!auxiliarGuest.getpNext().getName().toLowerCase().equals(name)) || !auxiliarGuest.getpNext().getLastName().toLowerCase().equals(lastName)) {
                    auxiliarGuest = auxiliarGuest.getpNext();
                }
                if (auxiliarGuest.getpNext() != null) {
                    auxiliarGuest.setpNext(auxiliarGuest.getpNext().getpNext());
                }
            } else {
                this.setpFirst(this.getpFirst().getpNext());
            }
        }
    }

    public Guest searchGuestList(String name, String lastName) {
        if (this.getpFirst() != null) {
            Guest auxiliarGuest = this.getpFirst();
            while (auxiliarGuest != null && (!auxiliarGuest.getName().toLowerCase().equals(name)) || !auxiliarGuest.getLastName().toLowerCase().equals(lastName)) {
                auxiliarGuest = auxiliarGuest.getpNext();
            }
            return auxiliarGuest;
        }
        return null;
    }

}
