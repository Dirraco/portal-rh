package com.Portalrh;

public class Assistente extends Funcionario{

    public Assistente(int id, String nome) {
        super(id, nome);

    }

    @Override
    public int getLimiteHoraExtra() {
        return 3;
    }

    @Override
    public boolean podeBaterPonto(){
        return true;
    }

    @Override
    public String getTipoFuncionario() {
        return "Assistente";
    }

}