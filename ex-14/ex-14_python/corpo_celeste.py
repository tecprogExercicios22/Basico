from vetor2d import Vetor2D
from cor import Cor


class CorpoCeleste:
    def __init__(self, posicao, velocidade, massa, raio, cor):
        self.posicao = posicao
        self.velocidade = velocidade
        self.massa = massa
        self.raio = raio
        self.cor = cor
        self.trajetoria = []
        self.maxPontosTrajetoria = 1000
        self.aceleracao = Vetor2D(0, 0)

    def getPosicao(self):
        return self.posicao

    def getVelocidade(self):
        return self.velocidade

    def getMassa(self):
        return self.massa

    def getRaio(self):
        return self.raio

    def getCor(self):
        return Cor(self.cor.r, self.cor.g, self.cor.b, self.cor.a)

    def getTrajetoria(self):
        return self.trajetoria

    def setPosicao(self, pos):
        self.posicao = pos

    def setVelocidade(self, vel):
        self.velocidade = vel

    def setAceleracao(self, acel):
        self.aceleracao = acel

    def atualizar(self, dt):
        self.velocidade += self.aceleracao * dt
        self.posicao += self.velocidade * dt

    def adicionarPontoTrajetoria(self, ponto):
        self.trajetoria.append(ponto)
        if len(self.trajetoria) > self.maxPontosTrajetoria:
            self.trajetoria.pop(0)

    def limparTrajetoria(self):
        self.trajetoria.clear()
