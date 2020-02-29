/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Josemolamazo
 */
public class Ficheiro {

   PrintWriter escribir = null;
    FileWriter fich;
    Scanner sc;

    public Libro pedirDatos() {
        Libro lib = new Libro(JOptionPane.showInputDialog("Añadir titulo"),
                JOptionPane.showInputDialog("Añadir autor"),
                Float.parseFloat(JOptionPane.showInputDialog("Poner precio")),
                Integer.parseInt(JOptionPane.showInputDialog("Cantidad")));
        return lib;
    }

    public void mostar(ArrayList<Libro> listaLibros) {
        System.out.println("Mostrar :");
        Iterator it = listaLibros.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    public void añadirLibro(String nomeFich) {
        try {
            Libro libro = pedirDatos();

            fich = new FileWriter(nomeFich, true);
            escribir = new PrintWriter(fich);
            escribir.println(libro.toString());
        } catch (IOException ex) {
            System.out.println("error " + ex.toString());
        } finally {
            escribir.close();
        }

    }

    public String tituloAConsultar() {
        String titulo = JOptionPane.showInputDialog("Introduce o titulo");
        return titulo;
    }

    public void consulta(File fich) {
        try {
            String titulo = tituloAConsultar();
            sc = new Scanner(fich).useDelimiter(",\\s*");
            while (sc.hasNext()) {
                if (titulo.equals(sc.next())) {
                    String autor = sc.next();
                    float precio = Float.parseFloat(sc.next());
                    System.out.println("El precio es de: " + precio);
                } else if (sc.hasNext()) {
                    sc.nextLine();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro" + ex.toString());
        } finally {
            escribir.close();
        }
    }

    public void ver(File fich) {
        try {
            System.out.println("Contenido libreria ");
            sc = new Scanner(fich);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error" + ex.toString());
        } finally {
            escribir.close();
        }
    }

    public void darDeBaja(ArrayList<Libro> listaLibros, File fich) {
        Libro libro = new Libro();
        Iterator it = listaLibros.iterator();
        if (listaLibros.isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "No existen libros");
        } else {
            while (it.hasNext()) {
                libro = (Libro) it.next();
                if (libro.getUnidades() == 0) {
                    listaLibros.remove(libro);
                    break;
                }
            }
        }
    }

    public void actualizarLibreria(String nomeFich, ArrayList<Libro> listaLibros) {
        try {

            fich = new FileWriter(nomeFich);
            escribir = new PrintWriter(fich);
            for (int i = 0; i < listaLibros.size(); i++) {
                escribir.println(listaLibros.get(i));
            }
        } catch (IOException ex) {
            System.out.println("Error" + ex.toString());
        } finally {
            escribir.close();
        }
    }

    public void cambiarPrecio(ArrayList<Libro> listaLibros) {
        String titulo = tituloAConsultar();
        float nuevoPrecio = Float.parseFloat(JOptionPane.showInputDialog("El nuevo precio es de: "));
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro li = listaLibros.get(i);
            String titulo1 = li.getTitulo();
            if (titulo.equals(titulo1)) {
                li.setPrezo(nuevoPrecio);
            }
        }

    }

    public void salir() {
        System.exit(0);
    }
    }
