package cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import interfaces.IServidorNTP;

public class ClienteNTP {
    private static final int PORTA_SERVIDOR = 3240;
    private static final String NOME_SERVIDOR = "ServidorNTP";
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private String timestampEnvio;
    private String timestampRecebimento;
    private String timestampServidor;
    private long tempoViagemTotal;
    private String relogioSincronizado;
    private IServidorNTP servidorNTP;

    public ClienteNTP() throws RemoteException, NotBoundException {
        this.servidorNTP = (IServidorNTP) LocateRegistry.getRegistry("localhost", PORTA_SERVIDOR)
                                                        .lookup(NOME_SERVIDOR);
    }

    public static void main(String[] args) throws NotBoundException, RemoteException, InterruptedException {
        ClienteNTP cliente = new ClienteNTP();
        while (true) {
            cliente.sincronizarRelogio();
            cliente.exibirRelatorioSincronizacao();
            Thread.sleep(5000);
        }
    }

    public void sincronizarRelogio() throws RemoteException, InterruptedException {
        this.timestampEnvio = LocalDateTime.now().format(FORMATO);
        this.timestampServidor = this.servidorNTP.obterTimestamp();
        this.timestampRecebimento = LocalDateTime.now().format(FORMATO);

        LocalDateTime envio = LocalDateTime.parse(this.timestampEnvio, FORMATO);
        LocalDateTime recebimento = LocalDateTime.parse(this.timestampRecebimento, FORMATO);
        LocalDateTime servidor = LocalDateTime.parse(this.timestampServidor, FORMATO);

        this.tempoViagemTotal = Duration.between(envio, recebimento).toMillis();
        this.relogioSincronizado = servidor.plusNanos((this.tempoViagemTotal / 2) * 1_000_000).format(FORMATO);
    }

    public void exibirRelatorioSincronizacao() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=============================================================\n");
        relatorio.append("Nome do Servidor: ").append(NOME_SERVIDOR).append("\n");
        relatorio.append("Porta do Servidor: ").append(PORTA_SERVIDOR).append("\n");
        relatorio.append("Timestamp de envio da requisição: ").append(this.timestampEnvio).append("\n");
        relatorio.append("Timestamp do servidor: ").append(this.timestampServidor).append("\n");
        relatorio.append("Timestamp de recebimento da resposta: ").append(this.timestampRecebimento).append("\n");
        relatorio.append("Tempo de viagem total (RTP): ").append(this.tempoViagemTotal).append(" ms\n");
        relatorio.append("Relógio sincronizado: ").append(this.relogioSincronizado).append("\n");
        relatorio.append("=============================================================\n");
        System.out.println(relatorio);
    }
}
