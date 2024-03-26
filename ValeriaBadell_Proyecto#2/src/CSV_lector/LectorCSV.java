/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSV_lector;

import Classes.Guest;
import DataStructures.BST_Reservations;
import DataStructures.BST_Room_Record;
import DataStructures.DataBase_Rooms;
import HashTable.HT_Guests;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valeria Badell
 */
public class LectorCSV {
    public  HT_Guests bdd_clients;
    public  BST_Reservations bdd_reservations;
    public  DataBase_Rooms bdd_rooms;

    /**
     * Creates new form MenuInicial
     */
    public LectorCSV() {
        bdd_reservations = this.readReservas("reservas.csv");
        bdd_rooms = readRooms("habitaciones.csv");
        bdd_rooms = readRecord("historico.csv");
        bdd_clients = this.reedClients("estado.csv");
    }
    
    public DataBase_Rooms readRecord(String filePath) {
        DataBase_Rooms nodes = bdd_rooms;
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 7) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 7) {
                        throw new IOException("Invalid CSV format");
                    }
                    String ci = values[0].replace(".", "");
                    nodes.searchRoom(Integer.parseInt(values[6])).getGuests_record().new_record(values[1], values[2], values[3], values[4], values[5], Integer.parseInt(ci));
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }    
    
    public DataBase_Rooms readRooms(String filePath) {
        DataBase_Rooms nodes = new DataBase_Rooms();
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 3) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 3) {
                        throw new IOException("Invalid CSV format");
                    }
                    nodes.newRoom(Integer.parseInt(values[0]), Integer.parseInt(values[2]), values[1]);
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }
        
        
    public BST_Reservations readReservas(String filePath) {
        BST_Reservations nodes = new BST_Reservations();
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 9) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 9) {
                        throw new IOException("Invalid CSV format");
                    }
                    String ci = values[0].replace(".", "");
                    nodes.newReservation(Integer.parseInt(ci), values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]);
                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }



    public HT_Guests reedClients(String filePath) {
        HT_Guests nodes = new HT_Guests();
        try ( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header line
            String[] header = null;
            try {
                header = reader.readNext();
            } catch (CsvValidationException ex) {
                Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (header == null || header.length != 7) {
                throw new IOException("Invalid CSV format");
            }

            String[] values;
            Guest[] clientes = new Guest[10];
            for (int i = 0; i < 10; i++) {
                clientes[i] = null;
            }
            try {
                while ((values = reader.readNext()) != null) {
                    if (values.length != 7) {
                        throw new IOException("Invalid CSV format");
                    }
                    if (values[0].equals("")) {
                        for (int i = 0; i < 10; i++) {
                            if (clientes[i] == null) {
                                clientes[i] = new Guest(values[1], values[2], values[3], values[4], values[6], values[5], 0);
                                break;
                            }

                        }
                    } else {
                        nodes.newGuest(values[1], values[2], values[3], values[4], values[5], values[6], Integer.parseInt(values[0]));
                        for (int i = 0; i < 10; i++) {
                            if (clientes[i] != null) {
                                nodes.newGuest(clientes[i].getName(), clientes[i].getLastName(), clientes[i].getEmail(), clientes[i].getGender(), clientes[i].getArrival_date(), clientes[i].getPhone_number(), Integer.parseInt(values[0]));
                                clientes[i] = null;
                            }
                        }
                        bdd_rooms.searchRoom(Integer.parseInt(values[0])).setFree(false);

                    }

                }
            } catch (CsvValidationException ex) {
                Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return nodes;
    }
}
