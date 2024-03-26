/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DataStructures.BST_Room_Record;


public class Room {
   private int hab_number;
   private int floor;
   private String room_type;
   private BST_Room_Record guests_record;
   private boolean free;

    public Room(int hab_number, int floor, String room_type) {
        this.hab_number = hab_number;
        this.floor = floor;
        this.room_type = room_type;
        guests_record = new BST_Room_Record();
        free = true;
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
     * @return the floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(int floor) {
        this.floor = floor;
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
     * @return the guests_record
     */
    public BST_Room_Record getGuests_record() {
        return guests_record;
    }

    /**
     * @param guests_record the guests_record to set
     */
    public void setGuests_record(BST_Room_Record guests_record) {
        this.guests_record = guests_record;
    }

    /**
     * @return the free
     */
    public boolean isFree() {
        return free;
    }

    /**
     * @param free the free to set
     */
    public void setFree(boolean free) {
        this.free = free;
    }
   
   
}
