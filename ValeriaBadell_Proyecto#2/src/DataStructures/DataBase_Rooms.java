/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import Classes.Room;

public class DataBase_Rooms {

    Room[] rooms;

    public DataBase_Rooms() {
        this.rooms = new Room[300];
        for (int i = 0; i < 300; i++) {
            this.rooms[i] = null;
        }
    }

    public void newRoom(int hab_number, int floor, String room_type){
        rooms[hab_number-1] = new Room(hab_number, floor, room_type);
    }

    public Room searchRoom(int hab_number) {
        return this.rooms[hab_number-1];
    }

    public String searchRoomRecord(int hab_number) {
        return this.rooms[hab_number-1].getGuests_record().show_room_record();
    }

    public void newRoomRecord(int hab_number, String name, String lastName, String email, String gender, String arrivalDate, int id) {
        this.rooms[hab_number-1].getGuests_record().new_record(name, lastName, email, gender, arrivalDate, id);
    }
    
    public Room searchEmptyRoom(String room_type){
        for (int i = 0; i < 300; i++) {
            if(this.rooms[i].getRoom_type().equals(room_type) && this.rooms[i].isFree()){
                return this.rooms[i];
            }
        }
        return null;
    }
}
