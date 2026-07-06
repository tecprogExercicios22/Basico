public class Carro
{
    private static final int ESTRADA = 0;
    private static final int CIDADE = 1;
    private static final int NIVEL_COMB_CRITICO = 1;

    private String nome;
    private float combustivelMax, combustivelAt;
    private int consumo, distPerc;
    private int[] disPercLocal = new int[2]; //Vetor para armazenar a dist�ncia percorrida na cidade e na estrada

    //Construtoras
    public Carro(float max, int cons, String n)
    {
        combustivelAt = 0;
        distPerc = 0;
        disPercLocal[0] = 0;
        disPercLocal[1] = 0;
        setNome(n);
        if(!setCombMax(max) || !setConsumo(cons))
            System.exit(0);
    }

    public Carro()
    {
        combustivelMax = 1;
        combustivelAt = 0;
        consumo = 1;
        distPerc = 0;
        disPercLocal[0] = 0;
        disPercLocal[1] = 0;
        setNome("");
    }

    //Set's
    public boolean setCombMax(float max)
    {
        //Testa de a capacidade máxima do tanque é válida
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

    public void setNome(String n)
    {
        nome = n;
    }

    //Get's
    public float getCombustivel()
    {
        return combustivelAt;
    }

    public String getNome()
    {
        return nome;
    }

    //O carro anda uma distância dada no respectivo local (estrada ou cidade)
    public void andar(int dist, int local)
    {
        //Verifica se o nível atual de combustível é o suficiente para percorrer a distância dada
        if(combustivelAt < (float)dist/consumo){
            System.out.println("Combustivel insuficiente.");
            disPercLocal[local] += combustivelAt*consumo; //Soma a distância percorrida no local
            distPerc += combustivelAt*consumo;
            combustivelAt = 0;
        }
        //Se o nível de combustível é insuficiente, percorre somente a distância máxima possível com o combustível
        else{
            combustivelAt -= (float)dist/consumo;
            disPercLocal[local] += dist; //Soma a distância percorrida no local
            distPerc += dist;
        }
    }

    //O carro abastece o tanque com uma quantia dada
    public void abastecer(float quantComb)
    {
        //Verifica se o abastecimento respeita a capacidade máxima do tanque
        if(quantComb + combustivelAt > combustivelMax)
            combustivelAt = combustivelMax;
        //Se não, abastece com a capacidade máxima do tanque
        else
            combustivelAt += quantComb;
    }

    //O carro realiza um viajem de uma distância e um nivel inicial de combustível no tanque, ambos parâmetros
    public void viajem(int dist, float comb)
    {
        System.out.println("Faltam " + dist + " para chegar ao destino...\n");

        //Abastece o carro antes de iniciar a viajem
        abastecer(comb);

        //Para utilizar valores aleatórios
        java.util.Random rand = new java.util.Random(System.currentTimeMillis() / 1000);

        //Executa enquanto não terminou o trajeto
        while(dist > 0)
        {
            int distTrajeto = rand.nextInt(10) + 1; //Obtém um valor aleatório de trajeto (1 até 10)

            //Arruma o valor do trajeto se for maior que a distância restante da viajem
            if(distTrajeto > dist)
                distTrajeto = dist;

            //Verifica se o combustível chegou em um nível critico, ou seja, precisa abastecer para não ficar na parado na estrada
            if(combustivelAt <= NIVEL_COMB_CRITICO)
                abastecer(combustivelMax/2); //Abastece com metade da capacidade máxima do tanque

            //Calcula aleatoriamente se o carro vai andar na estrada ou cidade
            andar(distTrajeto, rand.nextInt(2));
            dist -= distTrajeto;
        }

        System.out.println("O carro " + nome + " viajou por " + distPerc + " Km, sendo que " + disPercLocal[CIDADE] + " Km eram na cidade, e " + disPercLocal[ESTRADA] + " Km eram na estrada.\n");
    }
}
