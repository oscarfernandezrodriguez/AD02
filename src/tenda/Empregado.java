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
public class Empregado {

    private String nome, apelido1, apelido2;

    public Empregado(String nome, String apelido1, String apelido2) {
        this.nome = nome;
        this.apelido1 = apelido1;
        this.apelido2 = apelido2;
    }

    public Empregado() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido1() {
        return apelido1;
    }

    public void setApelido1(String apelido1) {
        this.apelido1 = apelido1;
    }

    public String getApelido2() {
        return apelido2;
    }

    public void setApelido2(String apelido2) {
        this.apelido2 = apelido2;
    }
    @Override
    public String toString() {
        return "\t\tEmpregado:\n\t\tNombre= " + nome + "\n\t\tApellido1= " + apelido1+"\n";
    }

}
