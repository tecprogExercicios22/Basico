class Cor:
    def __init__(self, r, g, b, a=255):
        self.r = r
        self.g = g
        self.b = b
        self.a = a

    @staticmethod
    def Black():
        return Cor(0, 0, 0)

    @staticmethod
    def Yellow():
        return Cor(255, 255, 0)

    @staticmethod
    def Cyan():
        return Cor(0, 255, 255)
