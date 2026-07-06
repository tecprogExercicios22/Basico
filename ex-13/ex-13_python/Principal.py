from Vetor import Vetor


class Principal:
    # Construtora
    def __init__(self):
        self.v1 = Vetor()
        self.v2 = Vetor()
        self.getEntradas()

    def executar(self):
        soma = self.v1.soma(self.v2)
        mult1 = self.v1.multiplica(4)
        mult2 = self.v2.multiplica(2)
        print("Soma dos vetores: <" + str(soma.getDx()) + "," + str(soma.getDy()) + ">")
        print("Multiplicação vetor 1: <" + str(mult1.getDx()) + "," + str(mult1.getDy()) + ">")
        print("Multiplicação vetor 2: <" + str(mult2.getDx()) + "," + str(mult2.getDy()) + ">")

    def getEntradas(self):
        print("Digita os valores de x e y do primeiro vetor <x> <y>:", end="")
        x, y = map(int, input().split())
        print()

        self.v1 = Vetor(x, y)

        print("Digite os valores de x e y do segundo vetor <x> <y>: ", end="")
        x, y = map(int, input().split())
        print()

        self.v2 = Vetor(x, y)
