from C1 import C1
from C2 import C2
from C4 import C4


class C3:
    # Constructor
    def __init__(self):
        self.a3 = 0

    # Destructors
    def __del__(self):
        pass

    def executar(self):
        c1 = C1()
        c2 = C2()
        c4 = C4()

        c1.setA1(1)
        c2.setA2(1)
        c4.setA4(1)

        c1.getA1()
        c2.getA2()
        c4.getA4()

    # Getters & Setters
    def setA3(self, a3):
        self.a3 = a3

    def getA3(self):
        return self.a3
