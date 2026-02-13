package com.Portalrh;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Representa um registro diário de jornada de trabalho.
 */
public class RegistroDePonto {

    private LocalDate data;
    private LocalTime entrada;
    private LocalTime saida;
    private Duration horaTrabalhadas;

    public RegistroDePonto(LocalDate data, LocalTime entrada, LocalTime saida) {

        if (saida.isBefore(entrada) || saida.equals(entrada)) {
            throw new IllegalArgumentException("Saída deve ser após entrada.");
        }

        if (entrada.isBefore(LocalTime.of(6, 0))) {
            throw new IllegalArgumentException("Entrada antes das 06:00 não permitida.");
        }

        if (saida.isAfter(LocalTime.of(22, 0))) {
            throw new IllegalArgumentException("Saída após 22:00 não permitida.");
        }

        this.data = data;
        this.entrada = entrada;
        this.saida = saida;

        Duration total = Duration.between(entrada, saida);

        // Desconto fixo de 1 hora de almoço
        this.horaTrabalhadas = total.minus(Duration.ofHours(1));
    }

    public Duration getHoraTrabalhadas() {
        return horaTrabalhadas;
    }

    public void exibirRegistro() {
        System.out.println("Data: " + data +
                " | Entrada: " + entrada +
                " | Saída: " + saida +
                " | Horas trabalhadas: " + horaTrabalhadas.toHours());
    }
}