package com.Portalrh;

public class Analista extends Funcionario{

    public Analista(int id, String nome) {
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
        return "Analista";
    }

}
