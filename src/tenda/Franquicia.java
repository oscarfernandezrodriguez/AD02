/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tenda;

import java.util.ArrayList;

/**
 *
 * @author koke
 */
public class Franquicia {

    public ArrayList<Tenda> Tendas = new ArrayList<>();
    public ArrayList<Cliente> Clientes = new ArrayList<>();

    public Franquicia() {

        this.Tendas = new ArrayList<>();
        this.Clientes = new ArrayList<>();
    }

    public void addTenda(Tenda t) {
        this.Tendas.add(t);
    }

    public boolean checkTenda(String nome, String cidade, String parametro) {
        boolean check = true;
        for (Tenda tendaO : this.Tendas) {
            if (tendaO.getNome().equals(nome) && tendaO.getCidade().equals(cidade)) {
                check = false;
                break;
            }
        }
        return check;
    }

    public int orderTenda(Tenda t) {
        int posicion = 0;
        for (int i = 0; i < this.Tendas.size(); i++) {
            if (Tendas.get(i).getNome().equals(t.getNome()) && Tendas.get(i).getCidade().equals(t.getCidade())) {
                posicion = i;
            }
        }
        return posicion;
    }

    public void removeTenda(Tenda t) {
        for (int i = 0; i < this.Tendas.size(); i++) {
            if (Tendas.get(i).getNome().equals(t.getNome()) && Tendas.get(i).getCidade().equals(t.getCidade())) {
                Tendas.remove(i);
                Main.pausa(1);
                System.out.println("Tenda Borrada!!!");
                Main.pausa(1);
            }
        }
    }

    public boolean checkCliente(String correo, String parametro) {
        boolean check = true;
        for (Cliente clienteO : this.Clientes) {
            if (clienteO.getCorreo().equals(correo)) {
                check = false;
                if (parametro.equals("add")) {
                    System.out.println("Correo repetido!!!");
                }
                break;
            }
        }
        return check;
    }

    public void addCliente(Cliente c) {
        this.Clientes.add(c);

    }

    public void removeCliente(Cliente c) {
        for (int i = 0; i < this.Clientes.size(); i++) {
            if (Clientes.get(i).getCorreo().equals(c.getCorreo())) {
                Clientes.remove(i);
                Main.pausa(1);
                System.out.println("Cliente Borrado!!!");
                Main.pausa(1);
            }
        }
    }

    public boolean checkProducto(int posicion, String id,String parametro) {
        boolean check = this.Tendas.get(posicion).checkProducto(id,parametro);
        return check;
    }

    public void addProducto(int posicion, Producto producto) {
        this.Tendas.get(posicion).addProducto(producto);
    }

    public void removeProducto(int posicion, Producto producto) {
        this.Tendas.get(posicion).removeProducto(producto);
    }
    
    public boolean checkEmpregado(int posicion, String nomeE, String apelido1E,String apelido2E) {
        boolean check = this.Tendas.get(posicion).checkEmpregado(nomeE,apelido1E,apelido2E);
        return check;
    }

    public void addEmpregado(int posicion, Empregado empregado) {
        this.Tendas.get(posicion).addEmpregado(empregado);
    }

    public void removeEmpregado(int posicion, int numEmp) {
        this.Tendas.get(posicion).removeEmpregado(numEmp);
    }
}
