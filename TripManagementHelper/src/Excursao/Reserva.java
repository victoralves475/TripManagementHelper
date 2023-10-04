package Excursao;

/**
 *
 * @author antoniovictoralvesdacosta
 */
public class Reserva {
    private String cpf;
    private String nome;

    public Reserva(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return cpf + "/" + nome;
    }
}

