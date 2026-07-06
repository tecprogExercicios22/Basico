from cor import Cor
from vetor2f import Vetor2f


class CircleShape:
    def __init__(self, raio):
        self.raio = raio
        self.corPreenchimento = Cor(255, 255, 255)
        self.origem = Vetor2f(0, 0)
        self.posicao = Vetor2f(0, 0)

    def setFillColor(self, cor):
        self.corPreenchimento = cor

    def setOrigin(self, origem):
        self.origem = origem

    def setPosition(self, posicao):
        self.posicao = posicao

    def getRaio(self):
        return self.raio

    def getCorPreenchimento(self):
        return self.corPreenchimento

    def getPosicao(self):
        return self.posicao
