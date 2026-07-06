import math


class Vetor2D:
    def __init__(self, x=0.0, y=0.0):
        self.x = x
        self.y = y

    def getX(self):
        return self.x

    def getY(self):
        return self.y

    def setX(self, x):
        self.x = x

    def setY(self, y):
        self.y = y

    def magnitude(self):
        return math.sqrt(self.x * self.x + self.y * self.y)

    def normalizado(self):
        mag = self.magnitude()
        if mag > 0:
            return Vetor2D(self.x / mag, self.y / mag)
        return Vetor2D(0, 0)

    def __add__(self, outro):
        return Vetor2D(self.x + outro.x, self.y + outro.y)

    def __sub__(self, outro):
        return Vetor2D(self.x - outro.x, self.y - outro.y)

    def __mul__(self, escalar):
        return Vetor2D(self.x * escalar, self.y * escalar)

    def __truediv__(self, escalar):
        if escalar != 0:
            return Vetor2D(self.x / escalar, self.y / escalar)
        return Vetor2D(0, 0)

    def __iadd__(self, outro):
        self.x += outro.x
        self.y += outro.y
        return self

    def __isub__(self, outro):
        self.x -= outro.x
        self.y -= outro.y
        return self
