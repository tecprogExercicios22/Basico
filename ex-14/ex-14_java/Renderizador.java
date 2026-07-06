import java.util.List;

public class Renderizador {
    private JanelaRender janela;
    private double escalaX;
    private double escalaY;

    public Renderizador(JanelaRender janela, double larguraEspaco, double alturaEspaco) {
        this.janela = janela;
        atualizarEscala(larguraEspaco, alturaEspaco);
    }

    public void atualizarEscala(double larguraEspaco, double alturaEspaco) {
        int[] tamanhoJanela = janela.getSize();
        escalaX = tamanhoJanela[0] / larguraEspaco;
        escalaY = tamanhoJanela[1] / alturaEspaco;
    }

    private Vetor2f converterParaTela(Vetor2D posicaoEspaco) {
        float x = (float) (posicaoEspaco.getX() * escalaX);
        float y = (float) (posicaoEspaco.getY() * escalaY);
        return new Vetor2f(x, y);
    }

    public void renderizar(Simulacao simulacao) {
        janela.clear(Cor.Black());

        List<CorpoCeleste> corpos = simulacao.getCorpos();

        for (CorpoCeleste corpo : corpos) {
            List<Vetor2f> trajetoria = corpo.getTrajetoria();

            if (trajetoria.size() > 1) {
                VertexArray linhas = new VertexArray(VertexArray.LineStrip, trajetoria.size());
                for (int i = 0; i < trajetoria.size(); i++) {
                    linhas.get(i).position = trajetoria.get(i);
                    Cor corTrajetoria = corpo.getCor();
                    corTrajetoria.a = 100;
                    linhas.get(i).color = corTrajetoria;
                }
                janela.draw(linhas);
            }

            Vetor2f posicaoTela = converterParaTela(corpo.getPosicao());

            CircleShape circulo = new CircleShape((float) corpo.getRaio());
            circulo.setFillColor(corpo.getCor());
            circulo.setOrigin(new Vetor2f((float) corpo.getRaio(), (float) corpo.getRaio()));
            circulo.setPosition(posicaoTela);

            janela.draw(circulo);
        }

        janela.display();
    }
}
