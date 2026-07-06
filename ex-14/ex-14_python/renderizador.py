from vetor2f import Vetor2f
from cor import Cor
from vertex_array import VertexArray, LineStrip
from circle_shape import CircleShape


class Renderizador:
    def __init__(self, janela, larguraEspaco, alturaEspaco):
        self.janela = janela
        self.escalaX = 0.0
        self.escalaY = 0.0
        self.atualizarEscala(larguraEspaco, alturaEspaco)

    def atualizarEscala(self, larguraEspaco, alturaEspaco):
        tamanhoJanela = self.janela.getSize()
        self.escalaX = tamanhoJanela[0] / larguraEspaco
        self.escalaY = tamanhoJanela[1] / alturaEspaco

    def converterParaTela(self, posicaoEspaco):
        x = float(posicaoEspaco.getX() * self.escalaX)
        y = float(posicaoEspaco.getY() * self.escalaY)
        return Vetor2f(x, y)

    def renderizar(self, simulacao):
        self.janela.clear(Cor.Black())

        corpos = simulacao.getCorpos()

        for corpo in corpos:
            trajetoria = corpo.getTrajetoria()

            if len(trajetoria) > 1:
                linhas = VertexArray(LineStrip, len(trajetoria))
                for i in range(len(trajetoria)):
                    linhas[i].position = trajetoria[i]
                    corTrajetoria = corpo.getCor()
                    corTrajetoria.a = 100
                    linhas[i].color = corTrajetoria
                self.janela.draw(linhas)

            posicaoTela = self.converterParaTela(corpo.getPosicao())

            circulo = CircleShape(float(corpo.getRaio()))
            circulo.setFillColor(corpo.getCor())
            circulo.setOrigin(Vetor2f(float(corpo.getRaio()), float(corpo.getRaio())))
            circulo.setPosition(posicaoTela)

            self.janela.draw(circulo)

        self.janela.display()
