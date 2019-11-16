/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tenda;

/**
 *
 * @author koke
 */
public class Producto {

    private String id, descripcion, cantidade, prezo;

    public Producto(String id, String descripcion, String cantidade, String prezo) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidade = cantidade;
        this.prezo = prezo;
    }

    public Producto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidade() {
        return cantidade;
    }

    public void setCantidade(String cantidade) {
        this.cantidade = cantidade;
    }

    public String getPrezo() {
        return prezo;
    }

    public void setPrezo(String prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "\t\tProducto:\n\t\tId= " + id + "\n\t\tDescripcion= " + descripcion + "\n\t\tCantidade= " + cantidade + "\n\t\tPrezo= " + prezo+"\n";
    }

}
