class Vetor:
    # Construtoras
    def __init__(self, x=0, y=0):
        self.dx = x
        self.dy = y

    # Set's
    def setDx(self, x):
        self.dx = x

    def setDy(self, y):
        self.dy = y

    # Get's
    def getDx(self):
        return self.dx

    def getDy(self):
        return self.dy

    # Soma dois vetores
    def soma(self, v):
        return Vetor(v.dx + self.dx, v.dy + self.dy)

    # Multiplica um vetor por uma constante
    def multiplica(self, i):
        return Vetor(self.dx * i, self.dy * i)
