import time
from relogio import Relogio


def main():
    print("=== TESTE DA CLASSE RELOGIO ===")
    print()

    # Teste 1: Criar relógio com data/hora atuais
    print("1. Criando relogio com data/hora atuais:")
    relogio1 = Relogio()
    print("   Tempo inicial: ", end="")
    relogio1.exibirTempoInicial()

    print("\n   Aguardando 1 segundo...")
    time.sleep(1)
    print("   Tempo atual: ", end="")
    relogio1.getAgora()

    print("\n   Aguardando mais 2 segundos...")
    time.sleep(2)
    print("   Tempo atual: ", end="")
    relogio1.getAgora()

    # Teste 2: Criar relógio com parâmetros específicos
    print("\n\n2. Criando relogio com parametros especificos:")
    relogio2 = Relogio(2025, 10, 2, 14, 30, 45, 123456789)
    print("   Tempo inicial: ", end="")
    relogio2.exibirTempoInicial()

    print("\n   Aguardando 500 ms...")
    time.sleep(0.5)
    print("   Tempo atual: ", end="")
    relogio2.getAgora()

    # Teste 3: Verificar precisão com múltiplas leituras rápidas
    print("\n\n3. Teste de precisao - 5 leituras consecutivas:")
    relogio3 = Relogio()
    print("   Tempo inicial: ", end="")
    relogio3.exibirTempoInicial()
    print()

    for i in range(1, 6):
        print("   Leitura " + str(i) + ": ", end="")
        relogio3.getAgora()
        time.sleep(0.1)

    # Teste 4: Verificar incremento gradual
    print("\n\n4. Verificando incremento gradual (10 leituras com 200ms):")
    relogio4 = Relogio()
    for i in range(1, 11):
        print("   Leitura " + str(i) + ": ", end="")
        relogio4.getAgora()
        time.sleep(0.2)

    print("\n=== TESTES CONCLUIDOS ===")


if __name__ == "__main__":
    main()
