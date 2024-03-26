/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashTable;

import Classes.Guest;
import SimpleList.SimpleList_Guests;


public class HT_Guests {
    private SimpleList_Guests[] guestsHash;
    private int size;
    
    public HT_Guests(){
        this.guestsHash = new SimpleList_Guests[300];
        this.size = 300;
        for (int i = 0; i < 300; i++) {
            this.guestsHash[i] = new SimpleList_Guests();
            
        }
    }
        /**
     * @return the guestsHash
     */
    public SimpleList_Guests[] getGuestsHash() {
        return guestsHash;
    }

    /**
     * @param guestsHash the guestsHash to set
     */
    public void setGuestsHash(SimpleList_Guests[] guestsHash) {
        this.guestsHash = guestsHash;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public int hashCode(String name, String lastName){
        int hash = 0;
        
        for (int i = 0; i < name.length(); i++) {
            hash += name.charAt(i)*i;
        }
        
        for (int i = 0; i < lastName.length(); i++) {
            hash += lastName.charAt(i)*i;
        }
        
        return hash % this.getSize();
    }
    
    public void newGuest(String name, String lastName, String email, String gender, String arrival_date, String phone_number, int hab_number){
        this.getGuestsHash()[this.hashCode(name.toLowerCase(),lastName.toLowerCase())].insertGuestList( name,  lastName,  email,  gender,  arrival_date,  phone_number,  hab_number);
    }
    
    public void deleteGuest(String name, String lastName){
        this.getGuestsHash()[this.hashCode(name.toLowerCase(),lastName.toLowerCase())].deleteGuestList( name.toLowerCase(),  lastName.toLowerCase());
    }
    
    public Guest searchGuest(String name, String lastName){
        return this.getGuestsHash()[this.hashCode(name.toLowerCase(),lastName.toLowerCase())].searchGuestList( name.toLowerCase(),  lastName.toLowerCase());
    }
    
    public String showGuestInfo(String name, String lastName){
        return this.getGuestsHash()[this.hashCode(name.toLowerCase(),lastName.toLowerCase())].searchGuestList( name.toLowerCase(),  lastName.toLowerCase()).toString();
    }


}
