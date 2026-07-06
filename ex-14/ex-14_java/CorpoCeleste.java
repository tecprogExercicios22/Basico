import java.util.ArrayList;
import java.util.List;

public class CorpoCeleste {
    private Vetor2D posicao;
    private Vetor2D velocidade;
    private Vetor2D aceleracao;
    private double massa;
    private double raio;
    private Cor cor;
    private List<Vetor2f> trajetoria;
    private final int maxPontosTrajetoria = 1000;

    public CorpoCeleste(Vetor2D posicao, Vetor2D velocidade, double massa, double raio, Cor cor) {
        this.posicao = posicao;
        this.velocidade = velocidade;
        this.massa = massa;
        this.raio = raio;
        this.cor = cor;
        this.trajetoria = new ArrayList<>();
        aceleracao = new Vetor2D(0, 0);
    }

    public Vetor2D getPosicao() {
        return posicao;
    }

    public Vetor2D getVelocidade() {
        return velocidade;
    }

    public double getMassa() {
        return massa;
    }

    public double getRaio() {
        return raio;
    }

    public Cor getCor() {
        return new Cor(cor.r, cor.g, cor.b, cor.a);
    }

    public List<Vetor2f> getTrajetoria() {
        return trajetoria;
    }

    public void setPosicao(Vetor2D pos) {
        posicao = pos;
    }

    public void setVelocidade(Vetor2D vel) {
        velocidade = vel;
    }

    public void setAceleracao(Vetor2D acel) {
        aceleracao = acel;
    }

    public void atualizar(double dt) {
        velocidade.somarIgual(aceleracao.multiplicar(dt));
        posicao.somarIgual(velocidade.multiplicar(dt));
    }

    public void adicionarPontoTrajetoria(Vetor2f ponto) {
        trajetoria.add(ponto);
        if (trajetoria.size() > maxPontosTrajetoria) {
            trajetoria.remove(0);
        }
    }

    public void limparTrajetoria() {
        trajetoria.clear();
    }
}
