from C1 import C1


class C2:
    # Constructor
    def __init__(self):
        self.a2 = 0

    # Destructors
    def __del__(self):
        pass

    def accesar(self):
        c1 = C1()
        c1.setA1(self.a2)
        c1.getA1()

    # Getters & Setters
    def setA2(self, a2):
        self.a2 = a2

    def getA2(self):
        return self.a2
