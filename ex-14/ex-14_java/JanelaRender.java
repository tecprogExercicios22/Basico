public class JanelaRender {
    private static final int MAX_QUADROS = 100;

    private boolean aberta;
    private int largura;
    private int altura;
    private String titulo;
    private int limiteQuadros;
    private int quadrosRestantes;

    public JanelaRender() {
        this.aberta = false;
        this.largura = 0;
        this.altura = 0;
        this.titulo = "";
        this.limiteQuadros = 0;
        this.quadrosRestantes = 0;
    }

    public void create(int largura, int altura, String titulo) {
        this.largura = largura;
        this.altura = altura;
        this.titulo = titulo;
        this.aberta = true;
        this.quadrosRestantes = MAX_QUADROS;
        System.out.println("[Janela] Criada: " + titulo + " (" + largura + "x" + altura + ")");
    }

    public void setFramerateLimit(int limite) {
        this.limiteQuadros = limite;
    }

    public int[] getSize() {
        return new int[]{largura, altura};
    }

    public boolean isOpen() {
        return aberta;
    }

    public void close() {
        aberta = false;
    }

    public Evento pollEvent() {
        return null;
    }

    public void clear(Cor cor) {
        int quadroAtual = MAX_QUADROS - quadrosRestantes + 1;
        System.out.println("[Quadro " + quadroAtual + "] Tela limpa cor=(" + cor.r + "," + cor.g + "," + cor.b + "," + cor.a + ")");
    }

    public void draw(Object forma) {
        if (forma instanceof VertexArray) {
            VertexArray va = (VertexArray) forma;
            System.out.println("  [Desenho] Trajetoria (LineStrip) com " + va.getVertexCount() + " vertices");
        } else if (forma instanceof CircleShape) {
            CircleShape c = (CircleShape) forma;
            Cor cor = c.getCorPreenchimento();
            System.out.printf("  [Desenho] Corpo circulo raio=%.1f pos=(%.2f, %.2f) cor=(%d,%d,%d,%d)%n",
                    c.getRaio(), c.getPosicao().x, c.getPosicao().y, cor.r, cor.g, cor.b, cor.a);
        }
    }

    public void display() {
        quadrosRestantes--;
        if (quadrosRestantes <= 0) {
            close();
        }
    }
}
