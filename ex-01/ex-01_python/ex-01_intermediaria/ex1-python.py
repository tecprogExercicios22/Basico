#Feito pelo Monitor Voluntario Washington Ying Ye Wu  - 16/05/2025
#Versao do Python Utilizada Python 3
#Matéria Técnicas de Programação - Prof. Jean Marcelo Simao

#Exercicio 1   

class Horario:
    def __init__(self,hora,min):
        #inicializacao dos atributos
        self.hora = hora
        self.min = min

    def getHora(self):
        #metodo getter
        return self.hora  #retorna hora

    def getMin(self):
        #metodo getter
        return self.min #retorna minutos

    def setHora(self,hora):
        #metodo setter
        if hora >=0 and hora<=24: #aqui poderia mudar para hora<24 e nao ter tratamento de horario
            if hora ==24:   
                hora = 0
            self.hora=hora
            print("horas validas")
            return True     #retorna verdadeiro se hora e valido
        else:
            print("horas nao validas")
            return False    #retorna falso se hora nao e valido

    def setMin(self,min):
        if min >=0 and min<=60: #aqui poderia mudar para minutos<60 e nao ter tratamento de minutos
            if min == 60:
                min = 0
            self.min=min
            print("minutos validos")
            return True     #retorna verdadeiro se minutos e valido
        else:
            print("minutos nao validos")
            return False    #retorna falso se minutos nao e valido

    def calcularIntervalo(self,horario2):
        #usa metodo getter para receber horarios e converter todos para minutos
        tempo1 = self.getHora()*60 + self.getMin()    
        tempo2 = horario2.getHora()*60 + horario2.getMin()

        intervalo = (tempo2 - tempo1) 

        if intervalo < 0:   #caso seja negativo, quer dizer que o tempo de saida passou de meia noite
            return intervalo + 1440   
        else:
            return intervalo


def main():

    print("digite o horario de entrada: ")
    hora1 = int(input("hora: "))  #int(input) converte/garante que o valor inserido seja inteiro
    minuto1 = int(input("minuto: "))
    horarioentrada = Horario(hora1, minuto1) # recebe o valores

    print("digite o horario de saida: ")
    hora2 = int(input("hora: "))
    minuto2 = int(input("minuto: "))
    horariosaida = Horario(hora2, minuto2) # recebe o valores

    intervalo = horarioentrada.calcularIntervalo(horariosaida)  #faz o calculo do intervalo


    #calcular o quanto custou pelo intervalo entre os horarios
    if intervalo < 180:   #caso tenha ficado <= que 3 horas
        preco = 4.50
    elif intervalo >= 180 and intervalo <= 720:  #caso tenha ficado entre 3 a 12h
        horasdescontadas = intervalo - 180 #desconta 3 horas
        cobranca15minutos = horasdescontadas  // 15  #conta os blocos de 15 minutos
        preco = 4.50 + cobranca15minutos * 0.75  
    else:  # mais de 12h
        preco = 33.00

    print(f"custo: R$ {preco:.2f} ")   #printa o preco


if __name__ == "__main__":  #inicializa o main e chama
    main()