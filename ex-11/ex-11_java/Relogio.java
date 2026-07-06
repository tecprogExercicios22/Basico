import java.time.LocalDateTime;

public class Relogio {
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    private int segundos;
    private long nanossegundos;

    // Armazena o tempo de criação do relógio
    private long tempoInicial;

    // Construtora com parâmetros
    public Relogio(int ano, int mes, int dia, int hora, int minutos, int segundos, long nanossegundos) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
        this.nanossegundos = nanossegundos;
        this.tempoInicial = System.nanoTime();
    }

    // Construtora com data/hora atuais
    public Relogio() {
        // Obtém o tempo atual do sistema
        LocalDateTime agora = LocalDateTime.now();

        this.ano = agora.getYear();
        this.mes = agora.getMonthValue();
        this.dia = agora.getDayOfMonth();
        this.hora = agora.getHour();
        this.minutos = agora.getMinute();
        this.segundos = agora.getSecond();
        // Obtém os milissegundos e converte para nanossegundos
        long ms = agora.getNano() / 1000000;
        this.nanossegundos = ms * 1000000; // 1 ms = 10^6 ns

        this.tempoInicial = System.nanoTime();
    }

    // Método getAgora() - retorna o tempo atual com precisão de nanossegundos
    public void getAgora() {
        // Calcula o tempo decorrido desde a criação do relógio
        long tempoAtual = System.nanoTime();
        long tempoDecorrido = tempoAtual - tempoInicial;

        // Adiciona o tempo decorrido ao tempo original
        long nsTotal = nanossegundos + tempoDecorrido;
        int segTotal = segundos;
        int minTotal = minutos;
        int horaTotal = hora;
        int diaTotal = dia;

        // Ajusta nanossegundos (1 segundo = 10^9 nanossegundos)
        segTotal += nsTotal / 1000000000;
        nsTotal = nsTotal % 1000000000;

        // Ajusta segundos
        minTotal += segTotal / 60;
        segTotal = segTotal % 60;

        // Ajusta minutos
        horaTotal += minTotal / 60;
        minTotal = minTotal % 60;

        // Ajusta horas
        diaTotal += horaTotal / 24;
        horaTotal = horaTotal % 24;

        // Exibe o resultado
        System.out.printf("%04d-%02d-%02d %02d:%02d:%02d.%09d ns%n",
                ano, mes, diaTotal, horaTotal, minTotal, segTotal, nsTotal);
    }

    // Método para exibir o tempo inicial
    public void exibirTempoInicial() {
        System.out.printf("%04d-%02d-%02d %02d:%02d:%02d.%09d ns%n",
                ano, mes, dia, hora, minutos, segundos, nanossegundos);
    }
}
