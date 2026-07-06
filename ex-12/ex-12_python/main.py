from Vetor import Vetor


def main():
    # Cria vetores
    vetorA = Vetor(10.5, 10.25)
    vetorB = Vetor(2.0, 5.75)
    # Testa operadores
    vetorC = vetorA * vetorB
    vetorD = vetorA + vetorB
    # Imprime valor dos vetores
    print("Vetor A -> (" + str(vetorA.getX()) + ", " + str(vetorA.getY()) + ")")
    print("Vetor B -> (" + str(vetorB.getX()) + ", " + str(vetorB.getY()) + ")")
    print("Vetor C -> (" + str(vetorC.getX()) + ", " + str(vetorC.getY()) + ")")
    print("Vetor D -> (" + str(vetorD.getX()) + ", " + str(vetorD.getY()) + ")")


if __name__ == "__main__":
    main()
