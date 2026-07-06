public class Vetor2D {
    private double x;
    private double y;

    public Vetor2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Vetor2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public Vetor2D normalizado() {
        double mag = magnitude();
        if (mag > 0) {
            return new Vetor2D(x / mag, y / mag);
        }
        return new Vetor2D(0, 0);
    }

    public Vetor2D somar(Vetor2D outro) {
        return new Vetor2D(x + outro.x, y + outro.y);
    }

    public Vetor2D subtrair(Vetor2D outro) {
        return new Vetor2D(x - outro.x, y - outro.y);
    }

    public Vetor2D multiplicar(double escalar) {
        return new Vetor2D(x * escalar, y * escalar);
    }

    public Vetor2D dividir(double escalar) {
        if (escalar != 0) {
            return new Vetor2D(x / escalar, y / escalar);
        }
        return new Vetor2D(0, 0);
    }

    public Vetor2D somarIgual(Vetor2D outro) {
        x += outro.x;
        y += outro.y;
        return this;
    }

    public Vetor2D subtrairIgual(Vetor2D outro) {
        x -= outro.x;
        y -= outro.y;
        return this;
    }
}
