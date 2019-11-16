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

    private String nome, apelido;

    public Empregado(String nome, String apelido) {
        this.nome = nome;
        this.apelido = apelido;
    }

    public Empregado() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Override
    public String toString() {
        return "\t\tEmpregado:\n\t\tNombre= " + nome + "\n\t\tApellido= " + apelido+"\n";
    }

}
