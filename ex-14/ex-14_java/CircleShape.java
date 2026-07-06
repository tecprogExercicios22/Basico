public class CircleShape {
    private float raio;
    private Cor corPreenchimento;
    private Vetor2f origem;
    private Vetor2f posicao;

    public CircleShape(float raio) {
        this.raio = raio;
        this.corPreenchimento = new Cor(255, 255, 255);
        this.origem = new Vetor2f(0, 0);
        this.posicao = new Vetor2f(0, 0);
    }

    public void setFillColor(Cor cor) {
        this.corPreenchimento = cor;
    }

    public void setOrigin(Vetor2f origem) {
        this.origem = origem;
    }

    public void setPosition(Vetor2f posicao) {
        this.posicao = posicao;
    }

    public float getRaio() {
        return raio;
    }

    public Cor getCorPreenchimento() {
        return corPreenchimento;
    }

    public Vetor2f getPosicao() {
        return posicao;
    }
}
