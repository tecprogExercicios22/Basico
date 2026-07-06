public class Vetor {
  private double dx, dy;

  // Construtora & Destrutora
  public Vetor(double dx, double dy) {
    this.dx = dx;
    this.dy = dy;
  }

  // Getters & Setters
  public double getX() {
    return this.dx;
  }

  public double getY() {
    return this.dy;
  }

  public void setX(double dx) {
    this.dx = dx;
  }

  public void setY(double dy) {
    this.dy = dy;
  }

  // Operadores
  public Vetor add(Vetor v) {
    // Calcula valores do novo vetor
    double dx = this.getX() + v.getX();
    double dy = this.getY() + v.getY();
    // Cria vetor com os valores calculados e retorna
    return new Vetor(dx, dy);
  }

  public Vetor multiply(Vetor v) {
    // Calcula valores do novo vetor
    double dx = this.getX() * v.getX();
    double dy = this.getY() * v.getY();
    // Cria vetor com os valores calculados e retorna
    return new Vetor(dx, dy);
  }
}
