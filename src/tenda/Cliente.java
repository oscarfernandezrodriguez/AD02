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
public class Cliente {

    private String nome, apelidos, correo;

    public Cliente(String nome, String apelidos, String correo) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.correo = correo;
    }

    public Cliente() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente:\n\tNome=" + nome + "\n\tApelidos=" + apelidos + "\n\tCorreo=" + correo+"\n" ;
    }

}
