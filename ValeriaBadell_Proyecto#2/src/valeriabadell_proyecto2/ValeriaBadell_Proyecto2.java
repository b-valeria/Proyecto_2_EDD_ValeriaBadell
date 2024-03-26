/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package valeriabadell_proyecto2;

import CSV_lector.LectorCSV;
import Menu.Home_Page;


public class ValeriaBadell_Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LectorCSV lector = new LectorCSV();
        Home_Page mi = new Home_Page(lector.bdd_clients,lector.bdd_reservations, lector.bdd_rooms);
        mi.setVisible(true);
    }
    
}
