package com.Portalrh;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata que representa o modelo base de um funcionário.
 * Define comportamentos que devem ser implementados pelas subclasses.
 */
public abstract class Funcionario {

    private int id;
    private String nome;
    private List<RegistroDePonto> registros;

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.registros = new ArrayList<>();
    }

    public void adicionarRegistro(RegistroDePonto registro) {
        registros.add(registro);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<RegistroDePonto> getRegistros() {
        return registros;
    }

    // Métodos abstratos que cada tipo deve definir
    public abstract int getLimiteHoraExtra();
    public abstract boolean podeBaterPonto();
    public abstract String getTipoFuncionario();
}