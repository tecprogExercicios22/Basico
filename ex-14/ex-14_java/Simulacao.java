import java.util.ArrayList;
import java.util.List;

public class Simulacao {
    private List<CorpoCeleste> corpos;
    private double dt;
    private double larguraEspaco;
    private double alturaEspaco;
    private final double G = 6.67430e-11;

    public Simulacao(double larguraEspaco, double alturaEspaco, double dt) {
        this.larguraEspaco = larguraEspaco;
        this.alturaEspaco = alturaEspaco;
        this.dt = dt;
        this.corpos = new ArrayList<>();
    }

    public void adicionarCorpo(CorpoCeleste corpo) {
        corpos.add(corpo);
    }

    private Vetor2D calcularForcaGravitacional(CorpoCeleste corpo1, CorpoCeleste corpo2) {
        Vetor2D direcao = corpo2.getPosicao().subtrair(corpo1.getPosicao());
        double distancia = direcao.magnitude();

        if (distancia < 1e3) {
            distancia = 1e3;
        }

        double forcaMagnitude = (G * corpo1.getMassa() * corpo2.getMassa()) / (distancia * distancia);

        Vetor2D forcaUnitaria = direcao.normalizado();
        return forcaUnitaria.multiplicar(forcaMagnitude);
    }

    public void atualizar() {
        for (int i = 0; i < corpos.size(); i++) {
            Vetor2D forcaTotal = new Vetor2D(0, 0);

            for (int j = 0; j < corpos.size(); j++) {
                if (i != j) {
                    Vetor2D forca = calcularForcaGravitacional(corpos.get(i), corpos.get(j));
                    forcaTotal.somarIgual(forca);
                }
            }

            Vetor2D aceleracao = forcaTotal.dividir(corpos.get(i).getMassa());
            corpos.get(i).setAceleracao(aceleracao);
        }

        for (int i = 0; i < corpos.size(); i++) {
            corpos.get(i).atualizar(dt);
        }
    }

    public void limpar() {
        corpos.clear();
    }

    public List<CorpoCeleste> getCorpos() {
        return corpos;
    }

    public double getLarguraEspaco() {
        return larguraEspaco;
    }

    public double getAlturaEspaco() {
        return alturaEspaco;
    }

    public double getDt() {
        return dt;
    }

    public void setDt(double novoDt) {
        dt = novoDt;
    }
}
