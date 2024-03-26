/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import HashTable.HT_Guests;
import Classes.Guest;
import DataStructures.DataBase_Rooms;
import DataStructures.BST_Reservations;
import Classes.Reservation;
import Classes.Room;


public class HotelAdministration {
    public static BST_Reservations reservationsBST;
    public static HT_Guests guestsHT;
    public static DataBase_Rooms roomsBST;

    public HotelAdministration(BST_Reservations reservationsBST, HT_Guests guestsHT, DataBase_Rooms roomsBST) {
        this.reservationsBST = reservationsBST;
        this.guestsHT = guestsHT;
        this.roomsBST = roomsBST;
    }
    
    public String Check_in(int id) {
        Reservation guestReservation = reservationsBST.searchReservation(id);
        if (guestReservation != null) {
            Room emptyRoom = roomsBST.searchEmptyRoom(guestReservation.getRoom_type());
            if (emptyRoom != null) {
                emptyRoom.setFree(false);
                this.guestsHT.newGuest( guestReservation.getName(), guestReservation.getLastName(), guestReservation.getEmail(), guestReservation.getGender(), guestReservation.getPhone_number(), guestReservation.getArrival_date(), emptyRoom.getHab_number());
                this.reservationsBST.deleteReservation(id);
                return "Gracias por hoospedarse con nosotros! Ha sido asignado a la habitación #" + emptyRoom.getHab_number();
            } else {
                return "Lo sentimos! No hay habitaciones disponibles";
            }
        } else {
            return "Debe tener una reservación para poder hacer CheckIn.";
        }
    }

    public String Check_out(String name, String lastName, int id) {
        Guest guest = guestsHT.searchGuest(name, lastName);
        if (guest != null) {
            Room guestRoom = this.roomsBST.rooms[guest.getHab_number()-1];
            if (guestRoom != null) {
                guestRoom.setFree(true);
                roomsBST.newRoomRecord(guestRoom.getHab_number(), name, lastName, guest.getEmail(), guest.getGender(), guest.getArrival_date(), id);
                guestsHT.deleteGuest(name, lastName);
                return "La habitación " + guestRoom.getHab_number() + " ha quedado libre y el cliente se ha registrado en el historial. Vuelva pronto!";
            }
        }
        return "Lo sentimos! Para hacer CheckOut debe ser un huésped del hotel.";
    }
    
    

}
