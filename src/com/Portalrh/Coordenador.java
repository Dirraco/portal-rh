package com.Portalrh;

public class Coordenador extends Funcionario{

    public Coordenador(int id, String nome) {
        super(id, nome);

    }

    @Override
    public int getLimiteHoraExtra() {
        return 5;
    }

    @Override
    public boolean podeBaterPonto(){
        return true;
    }

    @Override
    public String getTipoFuncionario() {
        return "Coordenador";
    }

}
