package com.Portalrh;

public class Estagiario extends Funcionario{

    public Estagiario(int id, String nome) {
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
        return "Estagiario";
    }

}
