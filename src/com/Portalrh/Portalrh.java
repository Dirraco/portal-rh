package com.Portalrh;

import java.util.ArrayList;
import java.util.List;

public class Portalrh {

    private List<Funcionario> funcionarios;

    public Portalrh() {

        funcionarios = new ArrayList<>();

    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public Funcionario buscarFuncionarioPortalId(int id) {

        for (Funcionario f : funcionarios) {

            if (f.getId() == id) {
                return f;
            }
        }

        return null;

    }

    public void removerFuncionario(int id) {

        Funcionario funcionario = buscarFuncionarioPortalId(id);

        if (funcionario != null) {
            funcionarios.remove(funcionario);
        }
    }

    public void listarFuncionario() {

        for (Funcionario f : funcionarios) {
            System.out.println("ID: " + f.getId());
            System.out.println("Nome: " + f.getNome());
            System.out.println("Cargo: " + f.getTipoFuncionario());
            System.out.println("Total de registros: " + f.getRegistros().size());

            for (RegistroDePonto r : f.getRegistros()) {
                r.exibirRegistro();
            }

        }
    }

    public void registrarPonto(int id, RegistroDePonto registro) {

        Funcionario funcionario = buscarFuncionarioPortalId(id);

        if (funcionario == null) {
            System.out.println("Funcionario não encontrado");
            return;
        }

        if (!funcionario.podeBaterPonto()){
            System.out.println("Esse tipo de Funcionario não pode bater ponto");
            return;
        }

        long horasTrabalhadas = registro.getHoraTrabalhadas().toHours();
        long horaExtra = 0;

        if (horasTrabalhadas > 8) {
            horaExtra = horasTrabalhadas - 8;
        } else {
            horaExtra = 0;
        }

        if (horaExtra > funcionario.getLimiteHoraExtra()) {
            System.out.println("Erro");
            return;
        } funcionario.adicionarRegistro(registro);
            System.out.println("Sucesso");

    }



}
