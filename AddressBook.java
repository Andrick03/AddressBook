package Actividad4;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Inicio {
    public static void main(String[] args) throws Exception {
        Operaciones ap = new Operaciones();
        Scanner scnr = new Scanner(System.in);
        boolean flag = true;
        while (flag = true) {
            System.out.println("0. Load / Save   1. List / Create / Delete");
            int seleccion = scnr.nextInt();
            switch (seleccion) {
                case 0: {
                    ap.archivar();
                    break;
                }
                case 1: {
                    ap.cambios();
                    break;

                }

                default:
                    System.exit(0);
            }
        }
    }
}
class Operaciones{
    HashMap<String, String> contactos = new HashMap<>();
    void archivar() {
        Scanner scnr = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("0. Save   1. Load  2. Exit");
            int seleccion = scnr.nextInt();
            switch (seleccion) {
                case 0:
                    try {
                        BufferedWriter saveBook = new BufferedWriter(new FileWriter("contactos.txt"));
                        for (int x = 0; x < contactos.size(); x++){
                            saveBook.write("\n" + contactos.values().toArray()[x] + " : " + contactos.keySet().toArray()[x]);
                        }
                        saveBook.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 1:
                    try {
                        BufferedReader loadBook = new BufferedReader(new FileReader("contactos.txt"));
                        System.out.println(loadBook.readLine());
                        String line;
                        while ((line = loadBook.readLine()) != null) {
                            System.out.println(line);
                        }
                        loadBook.close();
                    } catch  (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.exit(0);
            }

        }
    }
    void cambios(){
        Scanner scnr = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("¿Que desea cambiar?");
            System.out.println("0. List   1. Add  2. Delete  3. Exit");
            int seleccion = scnr.nextInt();
            switch (seleccion) {
                case 0:
                    if (contactos.isEmpty()) {
                        System.out.println("No hay cotactos que mostrar");
                        break;
                    } else {
                        for (int x = 0; x < contactos.size(); x++){
                            System.out.println("Contactos: ");
                            System.out.println(contactos.keySet().toArray()[x] + " : " + contactos.values().toArray()[x]);
                        }
                    }
                    break;
                case 1:
                    System.out.println("Ingrese el nombre del contacto (EN VEZ DE ESPACIOS USE -)");
                    String nombre = scnr.next();
                    System.out.println("Ingrese el numero del contacto en formato (000)000-0000");
                    String numero = scnr.next();
                    contactos.putIfAbsent(nombre, numero);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del contacto a borrar (EN VEZ DE ESPACIOS USE -)");
                    String nombreBorrar = scnr.next();
                    contactos.remove(nombreBorrar);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
