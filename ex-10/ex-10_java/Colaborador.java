public class Colaborador {
    public static final int HORAS_TRABALHADAS_MES_PADRAO = 80;

    public static final int EMPREGADO = 0;
    public static final int SOCIO = 1;
    public static final int ESTAGIARIO = 2;

    private String nome;
    private int tempoServico, tipoVinculo, horasTrabalha;
    private float valorHoraTrabalho;
    private float rendimento, custo;

    //Construtoras
    public Colaborador(String n, int vinc) {
        tempoServico = 0;
        horasTrabalha = HORAS_TRABALHADAS_MES_PADRAO;
        valorHoraTrabalho = 0;
        setNome(n);
        if (!setVinculo(vinc))
            System.exit(0);
    }

    public Colaborador() {
        tempoServico = 0;
        tipoVinculo = 0;
        horasTrabalha = HORAS_TRABALHADAS_MES_PADRAO;
        valorHoraTrabalho = 0;
        setNome("");
    }

    //Set's
    public void setNome(String n) {
        nome = n;
    }

    public boolean setTempoServico(int temp) {
        //Se o tempo de serviço é um valor válido
        if (temp < 0) {
            System.out.println("Tempo de serviço incorreto!");
            return false;
        }
        tempoServico = temp;
        return true;
    }

    public boolean setVinculo(int vinc) {
        //Testa se o tipo de vínculo é valido
        if (vinc < 0 || vinc > 2) {
            System.out.println("Vínculo incorreto!");
        }
        tipoVinculo = vinc;
        return true;
    }

    public boolean setValorHoraTrabalho(float valor) {
        //Testa se o valor da hora de trabalho válida
        if (valor < 0) {
            System.out.println("Valor da hora de trabalho incorreto!");
            return false;
        }

        valorHoraTrabalho = valor;

        return true;
    }

    public boolean setHorasTrabalha(int horas) {
        //Testa se a quantidade de horas trabalhadas em um dia é um valor válido
        if (horas < 0) {
            System.out.println("Número de horas trabalhadas por dia incorreto!");
        }
        horasTrabalha = horas;
        return true;
    }

    public String getNome() {
        return nome;
    }

    public float getRendimento() {
        return rendimento;
    }

    public float getCusto() {
        return custo;
    }

    //Calcula o rendimento com base no vínculo e o número de horas trabalhadas
    public void calculaRendimento() {
        int resto;
        int valorHoraTrabalhoTemp;

        switch (tipoVinculo) {
            case EMPREGADO:
                //Calcula o valor da hora de trabalho com base no tempo de serviço
                valorHoraTrabalhoTemp = (int) (valorHoraTrabalho * Math.pow(1.1, tempoServico));

                rendimento = valorHoraTrabalhoTemp * horasTrabalha;

                //Verica se o empregado fez hora extra e calcula o rendimento das horas trabalhadas
                if (horasTrabalha > 144) {
                    resto = horasTrabalha - 144; //Periodo da hora extra
                    rendimento += resto * valorHoraTrabalhoTemp * 0.5;
                }
                break;
            default:
                rendimento = valorHoraTrabalho * horasTrabalha;
        }
    }

    //Calcula o custo de um colaborador
    public void calculaCusto() {
        switch (tipoVinculo) {
            case EMPREGADO:
                custo = rendimento * 1.8f;
                break;
            default:
                custo = rendimento;
        }
    }
}
