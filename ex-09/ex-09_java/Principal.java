//Monitor: Thiago Henrique Frois Menon Cunha
//Data: Semestre 2022/1

import java.util.Scanner;

public class Principal
{
    private Carro gol;

    //Construtora
    public Principal()
    {
        gol = new Carro(45, 12, "Gol");
    }

    public void setViajem()
    {
        int dist = 1;
        float comb = 1;

        System.out.print("Digite a dist�ncia da viajem, e o n�vel de combust�vel do ve�culo <distancia, combustivel> :");
        Scanner cin = new Scanner(System.in);
        dist = cin.nextInt();
        comb = cin.nextFloat();
        System.out.println();

        gol.viajem(dist, comb);
    }

    public void executar()
    {
        setViajem();
    }

    public static void main(String[] args)
    {
        Principal principal = new Principal();

        principal.executar();
    }
}
