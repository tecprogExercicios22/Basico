from C1 import C1
from C3 import C3


def main():
    # Cria objetos
    c1 = C1()  # Deve-se usar p1:: para aceder à classe por causa que ela encontra-se nesse namespace
    c3 = C3()
    # Utiliza Setters
    c1.setA1(1)
    c3.setA3(1)
    # Utiloza Getters
    c1.getA1()
    c3.getA3()
    # Chama executar do objeto c3
    c3.executar()
    return 0


if __name__ == "__main__":
    main()
