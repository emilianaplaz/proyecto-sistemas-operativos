/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import GUI.Interfaz;

/**
 * @author Stefano Boschetti
 * @author Emiliana Plaz
 */
public class ManejadorInterfaz {
    private static Interfaz interfaz = new Interfaz();
    
    public static Interfaz getInterfaz() {
        return interfaz;
    }

   
    public static void setInterfaz(Interfaz aInterfaz) {
        interfaz = aInterfaz;
    }
}
