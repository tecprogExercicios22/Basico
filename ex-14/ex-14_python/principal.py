import sys
import random

from janela_render import JanelaRender
from simulacao import Simulacao
from renderizador import Renderizador
from corpo_celeste import CorpoCeleste
from vetor2d import Vetor2D
from vetor2f import Vetor2f
from cor import Cor
from evento import Evento


def _gerador_tokens():
    for linha in sys.stdin:
        for token in linha.split():
            yield token


class Principal:
    def __init__(self):
        self.janela = JanelaRender()
        self.simulacao = None
        self.renderizador = None
        self.larguraJanela = 1200
        self.alturaJanela = 800
        self._tokens = _gerador_tokens()

    def _proximoToken(self):
        return next(self._tokens)

    def lerDouble(self):
        return float(self._proximoToken())

    def lerInt(self):
        return int(self._proximoToken())

    def inicializar(self):
        self.janela.create(self.larguraJanela, self.alturaJanela, "Simulacao Gravitacional")
        self.janela.setFramerateLimit(60)
        self.obterDadosUsuario()

    def obterDadosUsuario(self):
        print("=== SIMULACAO DE ATRACAO GRAVITACIONAL ===")
        print()

        print("Digite a largura do espaco (em metros, ex: 100e9 para 100 milhoes de km): ", end="")
        larguraEspaco = self.lerDouble()
        print("Digite a altura do espaco (em metros): ", end="")
        alturaEspaco = self.lerDouble()

        print("Digite o intervalo de tempo (em segundos, ex: 3600 para 1 hora): ", end="")
        dt = self.lerDouble()

        self.simulacao = Simulacao(larguraEspaco, alturaEspaco, dt)
        self.renderizador = Renderizador(self.janela, larguraEspaco, alturaEspaco)

        print()
        print("Deseja posicionar os corpos aleatoriamente? (1-Sim, 0-Nao): ", end="")
        aleatorio = self.lerInt()

        for i in range(2):
            print()
            print("=== CORPO " + str(i + 1) + " ===")

            if aleatorio == 1:
                posX = random.uniform(0, larguraEspaco)
                posY = random.uniform(0, alturaEspaco)
                print("Posicao aleatoria: X=" + str(posX) + " m, Y=" + str(posY) + " m")
            else:
                print("Digite a posicao X (em metros): ", end="")
                posX = self.lerDouble()
                print("Digite a posicao Y (em metros): ", end="")
                posY = self.lerDouble()

            print("Digite a velocidade X (em m/s, ex: 30000 para 30 km/s): ", end="")
            velX = self.lerDouble()
            print("Digite a velocidade Y (em m/s): ", end="")
            velY = self.lerDouble()

            print("Digite a massa (em kg, ex: 6e27): ", end="")
            massa = self.lerDouble()

            raio = 10.0 + i * 5.0
            cor = Cor.Yellow() if i == 0 else Cor.Cyan()

            posicao = Vetor2D(posX, posY)
            velocidade = Vetor2D(velX, velY)

            corpo = CorpoCeleste(posicao, velocidade, massa, raio, cor)
            self.simulacao.adicionarCorpo(corpo)

        print()
        print("Simulacao iniciada! Pressione ESC para sair.")
        print("Pressione ESPACO para pausar/continuar.")
        print("Pressione R para reiniciar.")

    def processarEventos(self):
        evento = self.janela.pollEvent()
        while evento is not None:
            if evento.isClosed():
                self.janela.close()

            keyPressed = evento.getKeyPressed()
            if keyPressed is not None:
                if keyPressed == Evento.Escape:
                    self.janela.close()
                if keyPressed == Evento.R:
                    self.finalizar()
                    self.obterDadosUsuario()

            evento = self.janela.pollEvent()

    def atualizar(self):
        if self.simulacao:
            self.simulacao.atualizar()

            for i in range(len(self.simulacao.getCorpos())):
                corpo = self.simulacao.getCorpos()[i]
                tamanhoJanela = self.janela.getSize()

                escalaX = tamanhoJanela[0] / self.simulacao.getLarguraEspaco()
                escalaY = tamanhoJanela[1] / self.simulacao.getAlturaEspaco()

                x = float(corpo.getPosicao().getX() * escalaX)
                y = float(corpo.getPosicao().getY() * escalaY)

                posicaoTela = Vetor2f(x, y)

                corpo.adicionarPontoTrajetoria(posicaoTela)

    def renderizar(self):
        if self.renderizador and self.simulacao:
            self.renderizador.renderizar(self.simulacao)

    def finalizar(self):
        if self.simulacao:
            self.simulacao = None
        if self.renderizador:
            self.renderizador = None

    def executar(self):
        self.inicializar()

        while self.janela.isOpen():
            self.processarEventos()
            self.atualizar()
            self.renderizar()

        self.finalizar()
