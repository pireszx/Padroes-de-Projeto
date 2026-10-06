public class VideoReal implements Video {
    private String nomeFicheiro;

    public VideoReal(String nomeFicheiro) {
        this.nomeFicheiro = nomeFicheiro;
        carregarDoDisco();
    }

    private void carregarDoDisco() {
        // Simula o carregamento demorado e pesado de um vídeo gigante
        System.out.println("A carregar o vídeo gigante do servidor: " + nomeFicheiro);
    }

    @Override
    public void reproduzir() {
        System.out.println("A reproduzir o vídeo: " + nomeFicheiro);
    }
}