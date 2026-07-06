public class Principal {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== TESTE DA CLASSE RELOGIO ===");
        System.out.println();

        // Teste 1: Criar relógio com data/hora atuais
        System.out.println("1. Criando relogio com data/hora atuais:");
        Relogio relogio1 = new Relogio();
        System.out.print("   Tempo inicial: ");
        relogio1.exibirTempoInicial();

        System.out.println("\n   Aguardando 1 segundo...");
        Thread.sleep(1000);
        System.out.print("   Tempo atual: ");
        relogio1.getAgora();

        System.out.println("\n   Aguardando mais 2 segundos...");
        Thread.sleep(2000);
        System.out.print("   Tempo atual: ");
        relogio1.getAgora();

        // Teste 2: Criar relógio com parâmetros específicos
        System.out.println("\n\n2. Criando relogio com parametros especificos:");
        Relogio relogio2 = new Relogio(2025, 10, 2, 14, 30, 45, 123456789);
        System.out.print("   Tempo inicial: ");
        relogio2.exibirTempoInicial();

        System.out.println("\n   Aguardando 500 ms...");
        Thread.sleep(500);
        System.out.print("   Tempo atual: ");
        relogio2.getAgora();

        // Teste 3: Verificar precisão com múltiplas leituras rápidas
        System.out.println("\n\n3. Teste de precisao - 5 leituras consecutivas:");
        Relogio relogio3 = new Relogio();
        System.out.print("   Tempo inicial: ");
        relogio3.exibirTempoInicial();
        System.out.println();

        for (int i = 1; i <= 5; i++) {
            System.out.print("   Leitura " + i + ": ");
            relogio3.getAgora();
            Thread.sleep(100);
        }

        // Teste 4: Verificar incremento gradual
        System.out.println("\n\n4. Verificando incremento gradual (10 leituras com 200ms):");
        Relogio relogio4 = new Relogio();
        for (int i = 1; i <= 10; i++) {
            System.out.print("   Leitura " + i + ": ");
            relogio4.getAgora();
            Thread.sleep(200);
        }

        System.out.println("\n=== TESTES CONCLUIDOS ===");
    }
}
