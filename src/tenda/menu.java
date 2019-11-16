/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tenda;

import com.google.gson.Gson;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author koke
 */
public class menu {

    public void mostrar() {
        System.out.println("Menu:\n"
                + "[0] Engadir unha tenda.\n"
                + "[1] Eliminar unha tenda (elimínanse tódolos productos e empragados desta).\n"
                + "[2] Engadir un producto a tenda.\n"
                + "[3] Eliminar un producto a tenda.\n"
                + "[4] Engadir un empregado a tenda.\n"
                + "[5] Eliminar un empregado a tenda.\n"
                + "[6] Engadir un cliente.\n"
                + "[7] Eliminar un cliente.\n"
                + "[8] Crear unha copia de seguridade dos datos (Explícase máis abaixo).\n"
                + "[9] Ler os titulares do periódico El País. (Explícase máis abaixo)\n"
                + "[10] Sair do programa\n\n");
    }

    public int pedirDatos() {
        Scanner scanner = new Scanner(System.in);
        int numero;
        do {
            System.out.println("Introduzca el número del menú:");
            numero = scanner.nextInt();
            if (numero > 10 || numero < 0) {
                System.out.println("\nNumero Incorrecto, no contemplado!\n");
            }
        } while (numero > 10 || numero < 0);
        return numero;
    }

    public void procesarAccion(int numero, Franquicia f) {
        switch (numero) {
            case 0:
                //Engadir tenda
                addTenda(f);
                break;
            case 1:
                //Eliminar tenda
                removeTenda(f);
                break;
            case 2:
                //Engadir producto
                addProducto(f);
                break;
            case 3:
                //Eliminar producto
                removeProducto(f);
                break;
            case 4:
                //Engadir empregado
                addEmpregado(f);
                break;
            case 5:
                //Eliminar empregado
                removeEmpregado(f);
                break;
            case 6:
                //Engadir cliente
                addCliente(f);
                break;
            case 7:
                //Eliminar cliente
                removeCliente(f);
                break;
            case 8:
                //Crear copia
                backup(f);
                break;
            case 9:
                //Leer titulares
                readTitulares();
                break;
            case 10:
                //Sair
                break;

        }
        if (numero != 10) {
            mostrar();
            int dato = pedirDatos();
            procesarAccion(dato, f);
        }
    }

    public void addTenda(Franquicia f) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String cidade;
        do {
            System.out.print("Introduzca o nome da tenda: ");
            nome = scanner.nextLine();
            System.out.print("Introduzca a cidade da tenda: ");
            cidade = scanner.nextLine();
        } while (!f.checkTenda(nome, cidade, "add"));
        Tenda t = new Tenda(nome, cidade);
        f.addTenda(t);
        guardado(f);

    }

    public void removeTenda(Franquicia f) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String cidade;
        if (f.Tendas.size() > 0) {
            do {
                System.out.print("Introduzca o nome da tenda: ");
                nome = scanner.nextLine();
                System.out.print("Introduzca a cidade da tenda: ");
                cidade = scanner.nextLine();
            } while (f.checkTenda(nome, cidade, "remove"));
            Tenda t = new Tenda(nome, cidade);
            f.removeTenda(t);
            guardado(f);
        } else {
            Main.pausa(1);
            System.out.println("\nNo hay tiendas!! Introduzca antes tiendas\n");
            Main.pausa(1);
        }
    }

    public void addProducto(Franquicia f) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String cidade;
        String id;
        String descripcion;
        String cantidade;
        String prezo;
        if (f.Tendas.size() > 0) {
            do {
                System.out.print("Introduzca o nome da tenda: ");
                nome = scanner.nextLine();
                System.out.print("Introduzca a cidade da tenda: ");
                cidade = scanner.nextLine();
            } while (f.checkTenda(nome, cidade, "check"));
            Tenda t = new Tenda(nome, cidade);
            int numero = f.orderTenda(t);
            do {
                System.out.print("Introduzca o id do producto: ");
                id = scanner.nextLine();
                System.out.print("Introduzca a descripción do producto: ");
                descripcion = scanner.nextLine();
                System.out.print("Introduzca a cantidade do producto: ");
                cantidade = scanner.nextLine();
                System.out.print("Introduzca o prezo do producto: ");
                prezo = scanner.nextLine();
            } while (!f.checkProducto(numero, id, "add"));
            Producto p = new Producto(id, descripcion, cantidade, prezo);
            f.addProducto(numero, p);
            guardado(f);
        } else {
            Main.pausa(1);
            System.out.println("\nNo hay tiendas!! Introduzca antes tiendas\n");
            Main.pausa(1);
        }
    }

    public void removeProducto(Franquicia f) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String cidade;
        String id;
        String descripcion;
        String cantidade;
        String prezo;
        if (f.Tendas.size() > 0) {
            do {
                System.out.print("Introduzca o nome da tenda: ");
                nome = scanner.nextLine();
                System.out.print("Introduzca a cidade da tenda: ");
                cidade = scanner.nextLine();
            } while (f.checkTenda(nome, cidade, "check"));
            Tenda t = new Tenda(nome, cidade);
            int numero = f.orderTenda(t);
            if (f.Tendas.get(numero).productos.size() > 0) {
                do {
                    System.out.print("Introduzca o id do producto: ");
                    id = scanner.nextLine();
                    System.out.print("Introduzca a descripción do producto: ");
                    descripcion = scanner.nextLine();
                    System.out.print("Introduzca a cantidade do producto: ");
                    cantidade = scanner.nextLine();
                    System.out.print("Introduzca o prezo do producto: ");
                    prezo = scanner.nextLine();
                } while (f.checkProducto(numero, id, "remove"));
                Producto p = new Producto(id, descripcion, cantidade, prezo);
                f.removeProducto(numero, p);
                guardado(f);
            } else {
                Main.pausa(1);
                System.out.println("\nAún no hay productos!!\n");
                Main.pausa(1);
            }
        } else {
            Main.pausa(1);
            System.out.println("\nNo hay tiendas!! Introduzca antes tiendas\n");
            Main.pausa(1);
        }
    }

    public void addEmpregado(Franquicia f) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String cidade;
        String nomeE;
        String apelidoE;
        if (f.Tendas.size() > 0) {
            do {
                System.out.print("Introduzca o nome da tenda: ");
                nome = scanner.nextLine();
                System.out.print("Introduzca a cidade da tenda: ");
                cidade = scanner.nextLine();
            } while (f.checkTenda(nome, cidade, "check"));
            Tenda t = new Tenda(nome, cidade);
            int numero = f.orderTenda(t);
            do {
                System.out.print("Introduzca o nome do empregado: ");
                nomeE = scanner.nextLine();
                System.out.print("Introduzca o apelido do empregado: ");
                apelidoE = scanner.nextLine();
            } while (!f.checkEmpregado(numero, nomeE, apelidoE));
            Empregado e = new Empregado(nomeE, apelidoE);
            f.addEmpregado(numero, e);
            guardado(f);
        } else {
            Main.pausa(1);
            System.out.println("\nNo hay tiendas!! Introduzca antes tiendas\n");
            Main.pausa(1);
        }
    }

    public void removeEmpregado(Franquicia f) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String cidade;
        String nomeE;
        String apelidoE;
        if (f.Tendas.size() > 0) {
            do {
                System.out.print("Introduzca o nome da tenda: ");
                nome = scanner.nextLine();
                System.out.print("Introduzca a cidade da tenda: ");
                cidade = scanner.nextLine();
            } while (f.checkTenda(nome, cidade, "check"));
            Tenda t = new Tenda(nome, cidade);
            int numero = f.orderTenda(t);
            if (f.Tendas.get(numero).productos.size() > 0) {
                do {
                    System.out.print("Introduzca o nome do empregado: ");
                    nomeE = scanner.nextLine();
                    System.out.print("Introduzca o apelido do empregado: ");
                    apelidoE = scanner.nextLine();
                } while (f.checkEmpregado(numero, nomeE, apelidoE));
                Empregado e = new Empregado(nomeE, apelidoE);
                f.removeEmpregado(numero, e);
                guardado(f);
            } else {
                Main.pausa(1);
                System.out.println("\nAún no hay empreados!!\n");
                Main.pausa(1);
            }
        } else {
            Main.pausa(1);
            System.out.println("\nNo hay tiendas!! Introduzca antes tiendas\n");
            Main.pausa(1);
        }
    }

    public void addCliente(Franquicia f) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String apelido;
        String correo;
        do {
            System.out.print("Introduzca o nome: ");
            nome = scanner.nextLine();
            System.out.print("Introduzca o seu aplido: ");
            apelido = scanner.nextLine();
            System.out.print("Introduzca o correo: ");
            correo = scanner.nextLine();
        } while (!f.checkCliente(correo, "add"));
        Cliente t = new Cliente(nome, apelido, correo);
        f.addCliente(t);
        guardado(f);
    }

    public void removeCliente(Franquicia f) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String apelido;
        String correo;
        do {
            System.out.print("Introduzca o nome: ");
            nome = scanner.nextLine();
            System.out.print("Introduzca o seu apelido: ");
            apelido = scanner.nextLine();
            System.out.print("Introduzca o correo: ");
            correo = scanner.nextLine();
        } while (f.checkCliente(correo, "remove"));
        Cliente t = new Cliente(nome, apelido, correo);
        f.removeCliente(t);
        guardado(f);
    }

    public void backup(Franquicia f) {
        Gson gson = new Gson();
        String franquicia = gson.toJson(f);
        System.out.println(franquicia);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("backup.backup");
            pw = new PrintWriter(fichero);
            pw.println(franquicia);
        } catch (IOException e) {
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }
    }

    public void readTitulares() {
        tituloxml titulos = new tituloxml();
        Main.pausa(1);
        titulos.leerxml();
        Main.pausa(1);
    }

    public void guardado(Franquicia f) {
        Gson gson = new Gson();
        String franquicia = gson.toJson(f);
        System.out.println(franquicia);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("franquicia.json");
            pw = new PrintWriter(fichero);
            pw.println(franquicia);
        } catch (IOException e) {
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }
    }



}
