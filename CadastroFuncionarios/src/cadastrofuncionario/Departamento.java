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
public class Departamento {
    private int codigo;
    private String nome;
    ArrayList<Funcionario> lisaFunc;

    public Departamento() {
        this.lisaFunc = new ArrayList();
    }

    public Departamento(int Codigo, String nome) {
        this.codigo = Codigo;
        this.nome = nome;
        this.lisaFunc = new ArrayList();
    }

    public ArrayList<Funcionario> getLisaFunc() {
        return lisaFunc;
    }

    public void setLisaFunc(ArrayList<Funcionario> lisaFunc) {
        this.lisaFunc = lisaFunc;
    }
    
    public void addFunc(Funcionario F){
        F.setDep(this);       //relaciona um funcionario a um departamneto especifico..(existem vaios departamentos)
        this.lisaFunc.add(F);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int Codigo) {
        this.codigo = Codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
