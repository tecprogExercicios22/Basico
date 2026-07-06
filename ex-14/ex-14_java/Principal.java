import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    private JanelaRender janela;
    private Simulacao simulacao;
    private Renderizador renderizador;

    private final int larguraJanela = 1200;
    private final int alturaJanela = 800;

    private Scanner scanner;
    private Random random;

    public Principal() {
        janela = new JanelaRender();
        simulacao = null;
        renderizador = null;
        scanner = new Scanner(System.in);
        random = new Random();
    }

    private double lerDouble() {
        return Double.parseDouble(scanner.next());
    }

    private int lerInt() {
        return Integer.parseInt(scanner.next());
    }

    private void inicializar() {
        janela.create(larguraJanela, alturaJanela, "Simulacao Gravitacional");
        janela.setFramerateLimit(60);
        obterDadosUsuario();
    }

    private void obterDadosUsuario() {
        System.out.println("=== SIMULACAO DE ATRACAO GRAVITACIONAL ===");
        System.out.println();

        double larguraEspaco, alturaEspaco;
        System.out.print("Digite a largura do espaco (em metros, ex: 100e9 para 100 milhoes de km): ");
        larguraEspaco = lerDouble();
        System.out.print("Digite a altura do espaco (em metros): ");
        alturaEspaco = lerDouble();

        double dt;
        System.out.print("Digite o intervalo de tempo (em segundos, ex: 3600 para 1 hora): ");
        dt = lerDouble();

        simulacao = new Simulacao(larguraEspaco, alturaEspaco, dt);
        renderizador = new Renderizador(janela, larguraEspaco, alturaEspaco);

        System.out.println();
        System.out.print("Deseja posicionar os corpos aleatoriamente? (1-Sim, 0-Nao): ");
        int aleatorio;
        aleatorio = lerInt();

        for (int i = 0; i < 2; i++) {
            System.out.println();
            System.out.println("=== CORPO " + (i + 1) + " ===");

            double posX, posY;
            if (aleatorio == 1) {
                posX = random.nextDouble() * larguraEspaco;
                posY = random.nextDouble() * alturaEspaco;
                System.out.println("Posicao aleatoria: X=" + posX + " m, Y=" + posY + " m");
            } else {
                System.out.print("Digite a posicao X (em metros): ");
                posX = lerDouble();
                System.out.print("Digite a posicao Y (em metros): ");
                posY = lerDouble();
            }

            double velX, velY;
            System.out.print("Digite a velocidade X (em m/s, ex: 30000 para 30 km/s): ");
            velX = lerDouble();
            System.out.print("Digite a velocidade Y (em m/s): ");
            velY = lerDouble();

            double massa;
            System.out.print("Digite a massa (em kg, ex: 6e27): ");
            massa = lerDouble();

            double raio = 10.0 + i * 5.0;
            Cor cor = (i == 0) ? Cor.Yellow() : Cor.Cyan();

            Vetor2D posicao = new Vetor2D(posX, posY);
            Vetor2D velocidade = new Vetor2D(velX, velY);

            CorpoCeleste corpo = new CorpoCeleste(posicao, velocidade, massa, raio, cor);
            simulacao.adicionarCorpo(corpo);
        }

        System.out.println();
        System.out.println("Simulacao iniciada! Pressione ESC para sair.");
        System.out.println("Pressione ESPACO para pausar/continuar.");
        System.out.println("Pressione R para reiniciar.");
    }

    private void processarEventos() {
        Evento evento;
        while ((evento = janela.pollEvent()) != null) {
            if (evento.isClosed()) {
                janela.close();
            }

            Integer keyPressed = evento.getKeyPressed();
            if (keyPressed != null) {
                if (keyPressed == Evento.Escape) {
                    janela.close();
                }
                if (keyPressed == Evento.R) {
                    finalizar();
                    obterDadosUsuario();
                }
            }
        }
    }

    private void atualizar() {
        if (simulacao != null) {
            simulacao.atualizar();

            for (int i = 0; i < simulacao.getCorpos().size(); i++) {
                CorpoCeleste corpo = simulacao.getCorpos().get(i);
                int[] tamanhoJanela = janela.getSize();

                double escalaX = tamanhoJanela[0] / simulacao.getLarguraEspaco();
                double escalaY = tamanhoJanela[1] / simulacao.getAlturaEspaco();

                float x = (float) (corpo.getPosicao().getX() * escalaX);
                float y = (float) (corpo.getPosicao().getY() * escalaY);

                Vetor2f posicaoTela = new Vetor2f(x, y);

                corpo.adicionarPontoTrajetoria(posicaoTela);
            }
        }
    }

    private void renderizar() {
        if (renderizador != null && simulacao != null) {
            renderizador.renderizar(simulacao);
        }
    }

    private void finalizar() {
        if (simulacao != null) {
            simulacao = null;
        }
        if (renderizador != null) {
            renderizador = null;
        }
    }

    public void executar() {
        inicializar();

        while (janela.isOpen()) {
            processarEventos();
            atualizar();
            renderizar();
        }

        finalizar();
    }
}
