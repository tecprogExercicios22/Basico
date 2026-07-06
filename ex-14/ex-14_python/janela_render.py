from vertex_array import VertexArray
from circle_shape import CircleShape


class JanelaRender:
    MAX_QUADROS = 100

    def __init__(self):
        self.aberta = False
        self.largura = 0
        self.altura = 0
        self.titulo = ""
        self.limiteQuadros = 0
        self.quadrosRestantes = 0

    def create(self, largura, altura, titulo):
        self.largura = largura
        self.altura = altura
        self.titulo = titulo
        self.aberta = True
        self.quadrosRestantes = JanelaRender.MAX_QUADROS
        print("[Janela] Criada: " + titulo + " (" + str(largura) + "x" + str(altura) + ")")

    def setFramerateLimit(self, limite):
        self.limiteQuadros = limite

    def getSize(self):
        return (self.largura, self.altura)

    def isOpen(self):
        return self.aberta

    def close(self):
        self.aberta = False

    def pollEvent(self):
        return None

    def clear(self, cor):
        quadroAtual = JanelaRender.MAX_QUADROS - self.quadrosRestantes + 1
        print("[Quadro " + str(quadroAtual) + "] Tela limpa cor=(" +
              str(cor.r) + "," + str(cor.g) + "," + str(cor.b) + "," + str(cor.a) + ")")

    def draw(self, forma):
        if isinstance(forma, VertexArray):
            print("  [Desenho] Trajetoria (LineStrip) com " + str(forma.getVertexCount()) + " vertices")
        elif isinstance(forma, CircleShape):
            cor = forma.getCorPreenchimento()
            print("  [Desenho] Corpo circulo raio=%.1f pos=(%.2f, %.2f) cor=(%d,%d,%d,%d)" %
                  (forma.getRaio(), forma.getPosicao().x, forma.getPosicao().y,
                   cor.r, cor.g, cor.b, cor.a))

    def display(self):
        self.quadrosRestantes -= 1
        if self.quadrosRestantes <= 0:
            self.close()
