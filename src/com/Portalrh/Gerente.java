package com.Portalrh;

public class Gerente extends Funcionario{

    public Gerente(int id, String nome) {
        super(id, nome);

    }

    @Override
    public int getLimiteHoraExtra() {
        return 0;
    }

    @Override
    public boolean podeBaterPonto(){
        return false;
    }

    @Override
    public String getTipoFuncionario() {
        return "Gerente";
    }
}
