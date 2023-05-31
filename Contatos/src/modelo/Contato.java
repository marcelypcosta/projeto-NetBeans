package modelo;

public class Contato {
    private int id;
    private String nome;
    private String sobrenome;
    private String numero;
    
    public Contato(int id, String nome, String sobrenome, String numero) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
    }

    public Contato(String nome, String sobrenome, String numero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
