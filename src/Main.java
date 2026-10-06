public class Main {
    public static void main(String[] args) {
        Utilizador colaboradorComum = new Utilizador("Pedro", false);
        Utilizador gestor = new Utilizador("Ana", true);

        System.out.println("--- Cenário 1: Acesso Negado (Proxy de Proteção) ---");
        Video video1 = new ProxyVideo("treinamento_estrategico.mp4", colaboradorComum);
        video1.reproduzir();
        // O vídeo não é carregado nem reproduzido.

        System.out.println("\n--- Cenário 2: Acesso Permitido e Carregamento (Proxy Virtual) ---");
        Video video2 = new ProxyVideo("treinamento_estrategico.mp4", gestor);
        video2.reproduzir();
        // O vídeo é instanciado (carregado do servidor) e depois reproduzido.

        System.out.println("\n--- Cenário 3: Reutilização (Cache) ---");
        video2.reproduzir();
        // O vídeo já foi instanciado, logo apenas é reproduzido sem carregar novamente do servidor.
    }
}