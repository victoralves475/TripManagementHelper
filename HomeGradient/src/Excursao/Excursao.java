package Excursao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Excursao {

    private int codExcursao;
    private double precoExcursao;
    private int maxReservas;
    private ArrayList<String[]> listaReservas = new ArrayList<>();

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

    public Excursao(int cod) throws Exception {
        verificarExcursao(cod, 1, 1);
        codExcursao = cod;
        carregar();
    }

    private void verificarExcursao(int cod, double preco, int max) throws Exception {
        if (cod <= 0 || preco <= 0 || max <= 0) {
            throw new Exception("Dado(s) inválido(s)");
        }
    }

    public void criarReserva(String cpf, String nome) throws Exception {
        verificarCapacidade();
        verificarNome(nome);
        listaReservas.add(new String[]{cpf, nome});
    }

    private void verificarCapacidade() throws Exception {
        if (getMaxReservas() == listaReservas.size()) {
            throw new Exception("Capacidade máxima da excursão excedida");
        }
    }

    private void verificarNome(String nome) throws Exception {
        for (String[] reserva : listaReservas) {
            if (reserva[1].equals(nome)) {
                throw new Exception("Nome já cadastrado");
            }
        }
    }

    private ArrayList<Integer> verificarReserva(String cpf, String nome) {
        ArrayList<Integer> ocorrencias = new ArrayList<>();
        for (int i = 0; i < listaReservas.size(); i++) {
            String[] reserva = listaReservas.get(i);
            if (reserva[0].equals(cpf) && (nome.isEmpty() || reserva[1].equals(nome))) {
                ocorrencias.add(i);
            }
        }
        return ocorrencias;
    }

    public void cancelarReserva(String cpf, String nome) throws Exception {
        ArrayList<Integer> ocorrencias = verificarReserva(cpf, nome);
        if (ocorrencias.isEmpty()) {
            throw new Exception("Reserva inexistente");
        }
        for (int i = ocorrencias.size() - 1; i >= 0; i--) {
            listaReservas.remove((int) ocorrencias.get(i));
        }
    }

    public void cancelarReserva(String cpf) throws Exception {
        cancelarReserva(cpf, "");
    }

    public ArrayList<String> listarReservasPorCpf(String digitos) {
        ArrayList<String> listaRetorno = new ArrayList<>();
        for (String[] reserva : listaReservas) {
            if (digitos.isBlank() || reserva[0].contains(digitos)) {
                listaRetorno.add(reserva[0] + "/" + reserva[1]);
            }
        }
        return listaRetorno;
    }

    public ArrayList<String> listarReservasPorNome(String nome) {
        ArrayList<String> listaRetorno = new ArrayList<>();
        for (String[] reserva : listaReservas) {
            if (nome.isBlank() || reserva[1].contains(nome)) {
                listaRetorno.add(reserva[0] + "/" + reserva[1]);
            }
        }
        return listaRetorno;
    }

    public double calcularValorTotal() {
        return listaReservas.size() * getPrecoExcursao();
    }

    @Override
    public String toString() {
        return "Excursao [codigo=" + getCodExcursao() + ", preco=" + getPrecoExcursao() + ", maximo de reservas=" + getMaxReservas()
                + ", total de reservas" + listaReservas.size() + "]";
    }

    public void carregar() throws Exception {
        try {
            File f = new File(new File(".\\" + getCodExcursao() + ".txt").getCanonicalPath());
            Scanner arquivo = new Scanner(f);
            String[] dadosConstrutor = arquivo.nextLine().split("/"); // primeira linha de cabecalho é descartada
            precoExcursao = Double.parseDouble(dadosConstrutor[0]);
            maxReservas = Integer.parseInt(dadosConstrutor[1]);
            String[] reserva;
            while (arquivo.hasNextLine()) {
                reserva = arquivo.nextLine().split("/"); // leitura de uma linha
                listaReservas.add(reserva);
                // criarReserva(reserva[0], reserva[1]);
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
            for (String[] reserva : listaReservas) {
                arquivo.write(reserva[0] + "/" + reserva[1] + "\n");
            }
            arquivo.close();
        } catch (IOException e) {
            throw new Exception("Problema na gravação do arquivo de saída");
        }
    }

    /**
     * @return the codExcursao
     */
    public int getCodExcursao() {
        return codExcursao;
    }

    /**
     * @return the precoExcursao
     */
    public double getPrecoExcursao() {
        return precoExcursao;
    }

    /**
     * @return the maxReservas
     */
    public int getMaxReservas() {
        return maxReservas;
    }
}
