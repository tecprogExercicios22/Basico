import java.util.Scanner;

public class Principal {
    private Colaborador[] colaboradores = new Colaborador[3];

    private static Scanner cin = new Scanner(System.in);

    //Construtora
    public Principal() {
        for (int i = 0; i < 3; i++)
            colaboradores[i] = new Colaborador();
    }

    //Obtém os valores de entrada dos colaboradores
    public void getColaboradores() {
        System.out.println("EMPREGADO  -> 0");
        System.out.println("SOCIO      -> 1");
        System.out.println("ESTAGIARIO -> 2");
        String n;
        int vinculo, i, horasTrabalhadas;
        int temp;
        float hora;
        for (i = 0; i < 3; i++) {
            System.out.print("Digite os dados do colaborador <nome> <vinculo>: ");
            n = cin.next();
            vinculo = cin.nextInt();
            System.out.println();
            colaboradores[i] = new Colaborador(n, vinculo);

            //Se o vínculo é diferente de estagiário precisa perguntar o número de horas trabalhadas
            if (vinculo != Colaborador.ESTAGIARIO) {
                System.out.print("Digite o tempo de serviço do colaborador, o valor da hora de trabalho, e o número de horas trabalhadas <tempo> <hora> <numero>: ");
                temp = cin.nextInt();
                hora = cin.nextFloat();
                horasTrabalhadas = cin.nextInt();
                System.out.println();

                colaboradores[i].setHorasTrabalha(horasTrabalhadas);

            } else {
                System.out.print("Digite o tempo de serviço do colaborador e o valor da hora de trabalho <tempo> <hora>: ");
                temp = cin.nextInt();
                hora = cin.nextFloat();
                System.out.println();

                colaboradores[i].setHorasTrabalha(Colaborador.HORAS_TRABALHADAS_MES_PADRAO);

            }
            colaboradores[i].setTempoServico(temp);
            colaboradores[i].setValorHoraTrabalho(hora);
        }

    }

    //Obtém colaborador com maior rendimento
    public Colaborador getMaiorRendimento() {
        float rendimentoC1, rendimentoC2, rendimentoC3;
        rendimentoC1 = colaboradores[0].getRendimento();
        rendimentoC2 = colaboradores[1].getRendimento();
        rendimentoC3 = colaboradores[2].getRendimento();

        if (rendimentoC1 >= rendimentoC2) {
            if (rendimentoC1 >= rendimentoC3)
                return colaboradores[0];
            else
                return colaboradores[2];
        } else {
            if (rendimentoC2 >= rendimentoC3)
                return colaboradores[1];
            else
                return colaboradores[2];
        }
    }

    //Obtém colaborador com maior custo
    public Colaborador getMaiorCusto() {
        float custoC1, custoC2, custoC3;
        custoC1 = colaboradores[0].getCusto();
        custoC2 = colaboradores[1].getCusto();
        custoC3 = colaboradores[2].getCusto();

        if (custoC1 >= custoC2) {
            if (custoC1 >= custoC3)
                return colaboradores[0];
            else
                return colaboradores[2];
        } else {
            if (custoC2 >= custoC3)
                return colaboradores[1];
            else
                return colaboradores[2];

        }
    }

    public void executar() {
        Colaborador rende, custa;
        getColaboradores();


        for (int i = 0; i < 3; i++) {
            colaboradores[i].calculaRendimento();
            colaboradores[i].calculaCusto();
        }

        rende = getMaiorRendimento();
        custa = getMaiorCusto();

        System.out.println("O colaborador com maior rendimento foi " + rende.getNome());
        System.out.println("O colaborador com maior custo foi " + custa.getNome());
    }

    //Monitor: Thiago Henrique Frois Menon Cunha
    //Data: Semestre 2022/1

    public static void main(String[] args) {
        Principal principal = new Principal();

        principal.executar();
    }
}
