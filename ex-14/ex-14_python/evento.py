class Evento:
    Escape = 256
    R = 82

    def __init__(self):
        self.fechado = False
        self.codigoTecla = None

    def isClosed(self):
        return self.fechado

    def getKeyPressed(self):
        return self.codigoTecla
