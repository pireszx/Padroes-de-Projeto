public class ProxyVideo implements Video {
    private VideoReal videoReal;
    private String nomeFicheiro;
    private Utilizador utilizador;

    public ProxyVideo(String nomeFicheiro, Utilizador utilizador) {
        this.nomeFicheiro = nomeFicheiro;
        this.utilizador = utilizador;
    }

    @Override
    public void reproduzir() {
        // Proxy de Proteção: verifica permissões antes de instanciar o objeto real
        if (!utilizador.isGestor()) {
            System.out.println("Acesso negado: O colaborador " + utilizador.getNome() +
                    " não tem permissão para aceder a este treinamento de gestores.");
            return;
        }

        // Proxy Virtual (Lazy Initialization): carrega o vídeo apenas na primeira solicitação
        if (videoReal == null) {
            videoReal = new VideoReal(nomeFicheiro);
        }

        videoReal.reproduzir();
    }
}