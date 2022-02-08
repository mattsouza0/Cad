/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrofuncionario;

import java.util.ArrayList;

/**
 *
 * @author Mattg
 */
public class Funcionario {
    private int matricula;
    private String nome;
    private Departamento dep;   

    public Funcionario() {
    }

    public Funcionario(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
    
    public Departamento getDep() {
        return dep;
    }

    public void setDep(Departamento dep) {
        this.dep = dep;
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
