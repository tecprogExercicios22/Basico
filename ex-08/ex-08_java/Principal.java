//Nome: Thiago Henrique Frois Menon Cunha
//Data: Semestre 2022/1

public class Principal
{
    private Carro gol, uno;

    //Construtora
    public Principal()
    {
        gol = new Carro(45, 12);
        uno = new Carro(40, 14);
    }

    public void executar()
    {
        gol.abastecer(20);
        System.out.println("O gol tem atualmente " + gol.getCombustivel() + " litros de combustível.");

        uno.abastecer(25);
        System.out.println("O uno tem atualmente " + uno.getCombustivel() + " litros de combustível.");

        uno.andar(150);
        System.out.println("Depois de viajar o uno tem " + uno.getCombustivel() + " litros de combustível.");

        gol.andar(80);
        System.out.println("Depois de viajar o gol tem " + gol.getCombustivel() + " litros de combustível.");

    }

    public static void main(String[] args)
    {
        Principal principal = new Principal();

        principal.executar();
    }
}
