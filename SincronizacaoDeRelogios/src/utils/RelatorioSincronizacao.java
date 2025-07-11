package utils;
/**
 * Classe responsável por armazenar e exibir o relatório da sincronização.
 */
public class RelatorioSincronizacao {
	private final String nomeServidor;
	private final int portaServidor;
	private final String timestampEnvio;
	private final String timestampServidor;
	private final String timestampRecebimento;
	private final long tempoViagemTotal;
	private final String relogioSincronizado;

	public RelatorioSincronizacao(String nomeServidor, int portaServidor, String timestampEnvio,
			String timestampServidor, String timestampRecebimento, long tempoViagemTotal, String relogioSincronizado) {
		this.nomeServidor = nomeServidor;
		this.portaServidor = portaServidor;
		this.timestampEnvio = timestampEnvio;
		this.timestampServidor = timestampServidor;
		this.timestampRecebimento = timestampRecebimento;
		this.tempoViagemTotal = tempoViagemTotal;
		this.relogioSincronizado = relogioSincronizado;
	}

	public void exibir() {
		StringBuilder relatorio = new StringBuilder();
		relatorio.append("=============================================================\n");
		relatorio.append("Nome do Servidor: ").append(this.nomeServidor).append("\n");
		relatorio.append("Porta do Servidor: ").append(this.portaServidor).append("\n");
		relatorio.append("Timestamp de envio da requisição: ").append(this.timestampEnvio).append("\n");
		relatorio.append("Timestamp do servidor: ").append(this.timestampServidor).append("\n");
		relatorio.append("Timestamp de recebimento da resposta: ").append(this.timestampRecebimento).append("\n");
		relatorio.append("Tempo de viagem total (RTP): ").append(this.tempoViagemTotal).append(" ms\n");
		relatorio.append("Relógio sincronizado: ").append(this.relogioSincronizado).append("\n");
		relatorio.append("=============================================================\n");
		System.out.println(relatorio);
	}
}
