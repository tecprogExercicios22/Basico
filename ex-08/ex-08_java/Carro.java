public class Carro
{
    private int combustivelMax, combustivelAt, consumo;

    //Construtoras
    public Carro(int max, int cons)
    {
        combustivelAt = 0;
        if(!setCombMax(max) || !setConsumo(cons))
            System.exit(0);
    }

    public Carro()
    {
        combustivelMax = 1;
        combustivelAt = 0;
        consumo = 1; //Inicializa os atributos com os valores mínimos de acordo com as restrições.
    }

    //Set's
    public boolean setCombMax(int max)
    {
        //Testa se a capacidade máxima do tanque de combustível é válida
        if(max < 1)
        {
            System.out.println("Capacidade máxima do tanque inválida!");
            return false;
        }
        combustivelMax = max;
        return true;
    }

    public boolean setConsumo(int cons)
    {
        //Testa se o valor de consumo é válido
        if(cons < 1)
        {
            System.out.println("Consumo do veículo incorreto!");
            return false;
        }
        consumo = cons;
        return true;
    }

    //Get's
    public int getCombustivel()
    {
        return combustivelAt;
    }

    //O carro anda uma distância dada
    public void andar(int dist)
    {
        if(combustivelAt < dist/consumo){
            System.out.println("Combustível insuficiente.");
            combustivelAt = 0;
        }
        else
            combustivelAt -= dist/consumo;
    }

    //O carro abastece o tanque com um quantidade dada
    public void abastecer(int quantComb)
    {
        combustivelAt += quantComb;
    }
}
