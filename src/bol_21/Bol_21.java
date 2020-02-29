/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bol_21;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import libros.*;
import validar.pedirDato;
/**
 *
 * @author Josemolamazo
 */
public class Bol_21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int Opcion;
       Ficheiro obj = new Ficheiro();
        ArrayList<Libro>listaLibros=new ArrayList<>();
        File listaFichero = new File("Libreria.txt");

        do {
            Opcion = Integer.parseInt(JOptionPane.showInputDialog("***MENU***"
                    + "\n 1 -- Añadir libros"
                    + "\n 2 -- Consultar libro"
                    + "\n 3 -- Ver libro"
                    + "\n 4 -- Dar de baja libros y actualizar la lista"
                    + "\n 5 -- Cambiar precio y actualizar lista"
                    + "\n 6 -- Salir"));
            switch (Opcion) {
                case 1:
                    obj.añadirLibro("Libreria.txt");
                    break;
                case 2:
                    obj.consulta(listaFichero);
                    break;
                case 3:
                    obj.ver(listaFichero);
                    break;
                case 4:
                    obj.darDeBaja(listaLibros, listaFichero);
                    break;
                case 5:
                    obj.cambiarPrecio(listaLibros);
                    break;
                case 6:
                    obj.salir();
                    break;
            }
        } while (Opcion < 6);
    }
    
    
    
}
