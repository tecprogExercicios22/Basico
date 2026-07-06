public class Principal {
  public static void main(String[] args) {
    // Cria vetores
    Vetor vetorA = new Vetor(10.5, 10.25);
    Vetor vetorB = new Vetor(2.f, 5.75);
    // Testa operadores
    Vetor vetorC = vetorA.multiply(vetorB);
    Vetor vetorD = vetorA.add(vetorB);
    // Imprime valor dos vetores
    System.out.println("Vetor A -> (" + vetorA.getX() + ", " + vetorA.getY() + ")");
    System.out.println("Vetor B -> (" + vetorB.getX() + ", " + vetorB.getY() + ")");
    System.out.println("Vetor C -> (" + vetorC.getX() + ", " + vetorC.getY() + ")");
    System.out.println("Vetor D -> (" + vetorD.getX() + ", " + vetorD.getY() + ")");
  }
}
