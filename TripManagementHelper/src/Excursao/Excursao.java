package Excursao;

/**
 *
 * @author antoniovictoralvesdacosta
 */

import Excursao.Reserva;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Excursao {

    // Atributos da excursão
    private int codExcursao;
    private double precoExcursao;
    private int maxReservas;
    private ArrayList<Reserva> listaReservas = new ArrayList<>();

    // Construtor principal da excursão
    public Excursao(int cod, double preco, int max) throws Exception {
        verificarExcursao(cod, preco, max);
        codExcursao = cod;
        precoExcursao = preco;
        maxReservas = max;

        try {
            carregar();
        } catch (Exception e) {
            salvar();
        }
    }

    // Construtor apenas com o código da excursão
    public Excursao(int cod) throws Exception {
        verificarExcursao(cod, 1, 1);
        codExcursao = cod;
        carregar();
    }

    // Método para verificar a validade dos dados da excursão
    private void verificarExcursao(int cod, double preco, int max) throws Exception {
        if (cod <= 0 || preco <= 0 || max <= 0) {
            throw new Exception("Dado(s) inválido(s)");
        }
    }

    // Método para criar uma nova reserva
    public void criarReserva(String cpf, String nome) throws Exception {
        verificarCapacidade();
        verificarNome(nome);
        listaReservas.add(new Reserva(cpf, nome));
    }

    // Método para verificar se a capacidade máxima de reservas foi atingida
    private void verificarCapacidade() throws Exception {
        if (getMaxReservas() == listaReservas.size()) {
            throw new Exception("Capacidade máxima da excursão excedida");
        }
    }

    // Método para verificar se o nome já foi cadastrado em uma reserva
    private void verificarNome(String nome) throws Exception {
        for (Reserva reserva : listaReservas) {
            if (reserva.getNome().equals(nome)) {
                throw new Exception("Nome já cadastrado");
            }
        }
    }

    // Método para verificar se uma reserva existe
    private ArrayList<Integer> verificarReserva(String cpf, String nome) {
        ArrayList<Integer> ocorrencias = new ArrayList<>();
        for (int i = 0; i < listaReservas.size(); i++) {
            Reserva reserva = listaReservas.get(i);
            if (reserva.getCpf().equals(cpf) && (nome.isEmpty() || reserva.getNome().equals(nome))) {
                ocorrencias.add(i);
            }
        }
        return ocorrencias;
    }

    // Método para cancelar uma reserva com base no CPF e nome
    public void cancelarReserva(String cpf, String nome) throws Exception {
        ArrayList<Integer> ocorrencias = verificarReserva(cpf, nome);
        if (ocorrencias.isEmpty()) {
            throw new Exception("Reserva inexistente");
        }
        for (int i = ocorrencias.size() - 1; i >= 0; i--) {
            listaReservas.remove((int) ocorrencias.get(i));
        }
    }

    // Método para cancelar uma reserva apenas com base no CPF
    public void cancelarReserva(String cpf) throws Exception {
        cancelarReserva(cpf, "");
    }

    // Método para listar reservas com base no CPF ou nome
    public ArrayList<String> listarReservasPorCpf(String digitos) {
        ArrayList<String> listaRetorno = new ArrayList<>();
        for (Reserva reserva : listaReservas) {
            if (digitos.isBlank() || reserva.getCpf().contains(digitos)) {
                listaRetorno.add(reserva.getCpf() + "/" + reserva.getNome());
            }
        }
        return listaRetorno;
    }

    // Método para listar reservas com base no nome
    public ArrayList<String> listarReservasPorNome(String nome) {
        ArrayList<String> listaRetorno = new ArrayList<>();
        for (Reserva reserva : listaReservas) {
            if (nome.isBlank() || reserva.getNome().contains(nome)) {
                listaRetorno.add(reserva.getCpf() + "/" + reserva.getNome());
            }
        }
        return listaRetorno;
    }

    // Método para calcular o valor total da excursão com base no preço e número de reservas
    public double calcularValorTotal() {
        return listaReservas.size() * getPrecoExcursao();
    }

    @Override
    public String toString() {
        return "Excursao [codigo=" + getCodExcursao() + ", preco=" + getPrecoExcursao() + ", maximo de reservas=" + getMaxReservas()
                + ", total de reservas=" + listaReservas.size() + "]";
    }

    // Métodos para carregar e salvar dados em um arquivo
    public void carregar() throws Exception {
        try {
            File f = new File(new File(".\\" + getCodExcursao() + ".txt").getCanonicalPath());
            Scanner arquivo = new Scanner(f);
            String[] dadosConstrutor = arquivo.nextLine().split("/"); // primeira linha de cabecalho é descartada
            precoExcursao = Double.parseDouble(dadosConstrutor[0]);
            maxReservas = Integer.parseInt(dadosConstrutor[1]);
            while (arquivo.hasNextLine()) {
                String[] dadosReserva = arquivo.nextLine().split("/"); // leitura de uma linha
                listaReservas.add(new Reserva(dadosReserva[0], dadosReserva[1]));
            }
            arquivo.close();

        } catch (FileNotFoundException e) {
            throw new Exception("Excursão inexistente");
        }
    }

    public void salvar() throws Exception {
        try {
            File f = new File(new File(".\\" + getCodExcursao() + ".txt").getCanonicalPath()); // pasta do projeto
            FileWriter arquivo = new FileWriter(f, false); // append=false apaga o conteudo anterior
            arquivo.write(getPrecoExcursao() + "/" + getMaxReservas() + "\n"); // grava primeira linha de cabecalho
            for (Reserva reserva : listaReservas) {
                arquivo.write(reserva.getCpf() + "/" + reserva.getNome() + "\n");
            }
            arquivo.close();
        } catch (IOException e) {
            throw new Exception("Problema na gravação do arquivo de saída");
        }
    }

    // Getters para os atributos da excursão
    public int getCodExcursao() {
        return codExcursao;
    }

    public double getPrecoExcursao() {
        return precoExcursao;
    }

    public int getMaxReservas() {
        return maxReservas;
    }
}