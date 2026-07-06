from cor import Cor
from vetor2f import Vetor2f

LineStrip = 0


class Vertice:
    def __init__(self):
        self.position = Vetor2f(0, 0)
        self.color = Cor(255, 255, 255)


class VertexArray:
    def __init__(self, tipoPrimitiva, contagem):
        self.tipoPrimitiva = tipoPrimitiva
        self.vertices = [Vertice() for _ in range(contagem)]

    def __getitem__(self, i):
        return self.vertices[i]

    def getVertexCount(self):
        return len(self.vertices)

    def getTipoPrimitiva(self):
        return self.tipoPrimitiva
