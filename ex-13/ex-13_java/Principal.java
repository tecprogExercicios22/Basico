import java.util.Scanner;

public class Principal
{
    private Vetor v1, v2;

    //Construtora
    public Principal()
    {
        getEntradas();
    }

    public void executar()
    {
        Vetor soma = v1.soma(v2);
        Vetor mult1 = v1.multiplica(4);
        Vetor mult2 = v2.multiplica(2);
        System.out.println("Soma dos vetores: <" + soma.getDx() + "," + soma.getDy() + ">");
        System.out.println("Multiplicação vetor 1: <" + mult1.getDx() + "," + mult1.getDy() + ">");
        System.out.println("Multiplicação vetor 2: <" + mult2.getDx() + "," + mult2.getDy() + ">");
    }

    public void getEntradas()
    {
        int x, y;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digita os valores de x e y do primeiro vetor <x> <y>:");
        x = scanner.nextInt();
        y = scanner.nextInt();
        System.out.println();

        v1 = new Vetor(x, y);

        System.out.print("Digite os valores de x e y do segundo vetor <x> <y>: ");
        x = scanner.nextInt();
        y = scanner.nextInt();
        System.out.println();

        v2 = new Vetor(x, y);
    }

    public static void main(String[] args)
    {
        Principal principal = new Principal();

        principal.executar();
    }
}
