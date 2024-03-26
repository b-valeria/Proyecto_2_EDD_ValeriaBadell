/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import Classes.RoomRecord;

public class BST_Room_Record {

    private RoomRecord pRoot;

    public BST_Room_Record() {
        pRoot = null;
    }

    public void new_record(String name, String lastName, String email, String gender, String date_arrival, int id) {
        RoomRecord newrecord = new RoomRecord(name, lastName, email, gender, date_arrival, id);
        if (this.getpRoot() == null) {
            this.setpRoot(newrecord);
        } else {
            this.binaryInsert(newrecord, this.getpRoot());
        }
    }

    private void binaryInsert(RoomRecord newrecord, RoomRecord actualRecord) {
        if (actualRecord != null) {
            if (actualRecord.getId() >= newrecord.getId()) {
                if (actualRecord.getLeft_son() != null) {
                    this.binaryInsert(newrecord, actualRecord.getLeft_son());
                } else {
                    actualRecord.setLeft_son(newrecord);
                }
            } else if (actualRecord.getId() < newrecord.getId()) {
                if (actualRecord.getRight_son() != null) {
                    this.binaryInsert(newrecord, actualRecord.getRight_son());
                } else {
                    actualRecord.setRight_son(newrecord);
                }
            }
        }
    }
    
    public String show_room_record(){
        return this.binaryPrint(getpRoot(), "");
    }
    
    
    
    private String binaryPrint(RoomRecord actualRecord, String printRecord) {
        if (actualRecord != null) {
            printRecord += "-------------------\nNombre completo del Huésped: " +actualRecord.getName() + " " + actualRecord.getLastName() + "\nDATOS PERSONALES: \n    +Correo: " + actualRecord.getEmail() + "\n   +Genero: " + actualRecord.getGender() + "\n    +Fecha Llegada: " + actualRecord.getDate_arrival() + "\n";
            printRecord = this.binaryPrint(actualRecord.getLeft_son(), printRecord);
            printRecord = this.binaryPrint(actualRecord.getRight_son(), printRecord);

        }
        return printRecord;
    }

    /**
     * @return the pRoot
     */
    public RoomRecord getpRoot() {
        return pRoot;
    }

    /**
     * @param pRoot the pRoot to set
     */
    public void setpRoot(RoomRecord pRoot) {
        this.pRoot = pRoot;
    }
}
