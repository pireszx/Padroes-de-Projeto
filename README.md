# Sistema de Streaming de Vídeos de Treinamento Corporativo

## 1. Resolução dos Problemas através do Padrão Proxy

Este projeto implementa o padrão de desenho Proxy para resolver dois problemas críticos identificados na plataforma de Treinamentos Corporativos: o consumo excessivo de recursos e a falta de segurança nos acessos.

* **Desempenho (Proxy Virtual):** Inicialmente, o sistema tentava carregar todos os ficheiros de vídeo gigantes de uma só vez na página inicial. A introdução do **Proxy Virtual** aplica o conceito de *Lazy Initialization*. O objeto `VideoReal` agora só é instanciado, e o ficheiro efetivamente carregado para a memória, no momento exato em que um utilizador autorizado clica para o exibir. Solicitações subsequentes ao mesmo objeto reutilizam a instância já em memória, poupando largura de banda.
* **Segurança (Proxy de Proteção):** Treinamentos restritos estavam expostos a cliques de qualquer colaborador. O **Proxy de Proteção** atua como uma barreira antes de acionar o objeto real. Quando o método `reproduzir()` é chamado no `ProxyVideo`, o sistema verifica primeiro o perfil do utilizador. Se este não for um gestor, a execução é interrompida imediatamente, impedindo não apenas a visualização, mas também o carregamento desnecessário do vídeo para a memória, garantindo assim um controlo de acesso rigoroso.

A utilização de uma **Interface Comum** (`Video`) garante que o código cliente (`Main`) possa interagir de forma transparente tanto com os objetos reais quanto com os proxies, preservando o princípio do polimorfismo.

## 2. Instruções de Execução (IntelliJ IDEA)

Para compilar e executar este projeto localmente utilizando o IntelliJ IDEA, siga os passos abaixo:

1. Certifique-se de que possui o **Java Development Kit (JDK)** configurado no seu IntelliJ IDEA.
2. Abra o seu projeto (por exemplo, a pasta `exercicio`) no IntelliJ.
3. Certifique-se de que todos os ficheiros de código (`Video.java`, `VideoReal.java`, `Utilizador.java`, `ProxyVideo.java` e `Main.java`) estão guardados dentro da pasta **`src`** no painel de navegação do projeto (à esquerda).
4. Localize o ficheiro **`Main`** dentro da pasta `src`.
5. Clique com o botão direito do rato sobre o ficheiro `Main` e selecione **`Run 'Main.main()'`** (em alternativa, clique no triângulo verde de "Play" que aparece ao lado da linha `public class Main` diretamente no código).
6. O IntelliJ irá compilar o projeto automaticamente. A aba da consola (janela de execução/Run) abrir-se-á na parte inferior do ecrã e apresentará o output correspondente aos três cenários exigidos: Acesso negado (proteção), Acesso permitido com primeiro carregamento (virtual), e Reutilização sem novo carregamento (cache).