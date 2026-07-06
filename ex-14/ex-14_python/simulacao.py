from vetor2d import Vetor2D


class Simulacao:
    def __init__(self, larguraEspaco, alturaEspaco, dt):
        self.corpos = []
        self.larguraEspaco = larguraEspaco
        self.alturaEspaco = alturaEspaco
        self.dt = dt
        self.G = 6.67430e-11

    def adicionarCorpo(self, corpo):
        self.corpos.append(corpo)

    def calcularForcaGravitacional(self, corpo1, corpo2):
        direcao = corpo2.getPosicao() - corpo1.getPosicao()
        distancia = direcao.magnitude()

        if distancia < 1e3:
            distancia = 1e3

        forcaMagnitude = (self.G * corpo1.getMassa() * corpo2.getMassa()) / (distancia * distancia)

        forcaUnitaria = direcao.normalizado()
        return forcaUnitaria * forcaMagnitude

    def atualizar(self):
        for i in range(len(self.corpos)):
            forcaTotal = Vetor2D(0, 0)

            for j in range(len(self.corpos)):
                if i != j:
                    forca = self.calcularForcaGravitacional(self.corpos[i], self.corpos[j])
                    forcaTotal += forca

            aceleracao = forcaTotal / self.corpos[i].getMassa()
            self.corpos[i].setAceleracao(aceleracao)

        for i in range(len(self.corpos)):
            self.corpos[i].atualizar(self.dt)

    def limpar(self):
        self.corpos.clear()

    def getCorpos(self):
        return self.corpos

    def getLarguraEspaco(self):
        return self.larguraEspaco

    def getAlturaEspaco(self):
        return self.alturaEspaco

    def getDt(self):
        return self.dt

    def setDt(self, novoDt):
        self.dt = novoDt
