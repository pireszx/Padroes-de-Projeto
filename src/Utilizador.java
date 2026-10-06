public class Utilizador {
    private String nome;
    private boolean isGestor;

    public Utilizador(String nome, boolean isGestor) {
        this.nome = nome;
        this.isGestor = isGestor;
    }

    public String getNome() {
        return nome;
    }

    public boolean isGestor() {
        return isGestor;
    }
}