class Vetor:
    # Construtora & Destrutora
    def __init__(self, dx, dy):
        self.dx = dx
        self.dy = dy

    # Getters & Setters
    def getX(self):
        return self.dx

    def getY(self):
        return self.dy

    def setX(self, dx):
        self.dx = dx

    def setY(self, dy):
        self.dy = dy

    # Operadores
    def __add__(self, v):
        # Calcula valores do novo vetor
        dx = self.getX() + v.getX()
        dy = self.getY() + v.getY()
        # Cria vetor com os valores calculados e retorna
        return Vetor(dx, dy)

    def __mul__(self, v):
        # Calcula valores do novo vetor
        dx = self.getX() * v.getX()
        dy = self.getY() * v.getY()
        # Cria vetor com os valores calculados e retorna
        return Vetor(dx, dy)
