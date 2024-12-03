package models;

public class Cliente {
    private String id;
    private String nome;
    private String endereco;
    private String telefone;

    public Cliente(String id, String nome, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getTelefone() { return telefone; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    @Override
    public String toString() {
        return id + "," + nome + "," + endereco + "," + telefone;
    }

    public static Cliente fromString(String data) {
        String[] parts = data.split(",");
        return new Cliente(parts[0], parts[1], parts[2], parts[3]);
    }
}