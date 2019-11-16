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
public class Tenda {

    private String nome, cidade;
    public  ArrayList<Producto> productos = new ArrayList<>();
    public  ArrayList<Empregado> empregados = new ArrayList<>();

    public Tenda(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;

    }

    public Tenda() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean checkProducto(String id,String parametro) {
        boolean check = true;
        for (Producto productoO : this.productos) {
            if (productoO.getId().equals(id)) {
                check = false;
                if(parametro.equals("add")){
                    System.out.println("Producto repetido!!!");
                }
                break;
            }
        }
        return check;
    }

    public void addProducto(Producto p) {
        this.productos.add(p);
        System.out.println("Producto engadido!");
        Main.pausa(1);
        System.out.println(toString());
        Main.pausa(1);

    }

    public void removeProducto(Producto p) {
        int i;
        for (i=0; i < this.productos.size(); i++) {
            if (productos.get(i).getId().equals(p.getId())) {
                break;
            }
        }
        this.productos.remove(i);
        System.out.println("Producto eliminado!");
        Main.pausa(1);
        System.out.println(toString());
        Main.pausa(1);
    }

    public boolean checkEmpregado(String nome, String apelido) {
        boolean check = true;
        for (Empregado empregadoO : this.empregados) {
            if (!empregadoO.getNome().equals(nome) && !empregadoO.getApelido().equals(apelido)) {
                check = false;
                System.out.println("O empregado non existe!!!");
                break;
            }
        }
        return check;
    }

    public void addEmpregado(Empregado e) {
        int i ;
        for (i=0; i < this.empregados.size(); i++) {
            if (empregados.get(i).getNome().equals(e.getNome())&&empregados.get(i).getApelido().equals(e.getApelido())) {
                break;
            }
        }
        this.empregados.add(e);
        System.out.println("Empregado engadido!");
        Main.pausa(1);
        System.out.println(toString());
        Main.pausa(1);
    }

    public void removeEmpregado(Empregado e) {
        this.empregados.remove(e);
        System.out.println("Empregado eliminado!");
        Main.pausa(1);
        System.out.println(toString());
        Main.pausa(1);
    }

    @Override
    public String toString() {
        String salida = "Tenda:\n\tNome= " + nome + "\n\tCidade= " + cidade + "\n\tProductos: \n\n";
        for (Producto productoO : this.productos) {
            salida += productoO.toString();
        }
        salida += "\n\tEmpregados: \n\n";
        for (Empregado empregadoO : this.empregados) {
            salida += empregadoO.toString();
        }
        return salida + "\n";
    }
}
