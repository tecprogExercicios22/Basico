import time
from datetime import datetime


class Relogio:
    # Construtora com parâmetros
    def __init__(self, ano=None, mes=None, dia=None, hora=None, minutos=None, segundos=None, nanossegundos=None):
        if ano is not None:
            self.ano = ano
            self.mes = mes
            self.dia = dia
            self.hora = hora
            self.minutos = minutos
            self.segundos = segundos
            self.nanossegundos = nanossegundos
            self.tempoInicial = time.monotonic_ns()
        else:
            # Construtora com data/hora atuais
            # Obtém o tempo atual do sistema
            agora = datetime.now()

            self.ano = agora.year
            self.mes = agora.month
            self.dia = agora.day
            self.hora = agora.hour
            self.minutos = agora.minute
            self.segundos = agora.second
            # Obtém os milissegundos e converte para nanossegundos
            ms = agora.microsecond // 1000
            self.nanossegundos = ms * 1000000  # 1 ms = 10^6 ns

            self.tempoInicial = time.monotonic_ns()

    # Método getAgora() - retorna o tempo atual com precisão de nanossegundos
    def getAgora(self):
        # Calcula o tempo decorrido desde a criação do relógio
        tempoAtual = time.monotonic_ns()
        tempoDecorrido = tempoAtual - self.tempoInicial

        # Adiciona o tempo decorrido ao tempo original
        nsTotal = self.nanossegundos + tempoDecorrido
        segTotal = self.segundos
        minTotal = self.minutos
        horaTotal = self.hora
        diaTotal = self.dia

        # Ajusta nanossegundos (1 segundo = 10^9 nanossegundos)
        segTotal += nsTotal // 1000000000
        nsTotal = nsTotal % 1000000000

        # Ajusta segundos
        minTotal += segTotal // 60
        segTotal = segTotal % 60

        # Ajusta minutos
        horaTotal += minTotal // 60
        minTotal = minTotal % 60

        # Ajusta horas
        diaTotal += horaTotal // 24
        horaTotal = horaTotal % 24

        # Exibe o resultado
        print("{:04d}-{:02d}-{:02d} {:02d}:{:02d}:{:02d}.{:09d} ns".format(
            self.ano, self.mes, diaTotal, horaTotal, minTotal, segTotal, nsTotal))

    # Método para exibir o tempo inicial
    def exibirTempoInicial(self):
        print("{:04d}-{:02d}-{:02d} {:02d}:{:02d}:{:02d}.{:09d} ns".format(
            self.ano, self.mes, self.dia, self.hora, self.minutos, self.segundos, self.nanossegundos))
