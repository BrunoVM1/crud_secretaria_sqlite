package model;

public class Secretaria {
    private int id;
    private String nome;
    private String email;
    private String setor;

    public Secretaria() {
        this.id = 0;
        this.nome = "";
        this.email = "";
        this.setor = "";
    }

    public Secretaria(int id, String nome, String email, String setor) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}


