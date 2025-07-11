package cliente;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.Scanner;

import servidor.ServidorChatInterface;

/**
 * Implementação do cliente de chat.
 */
public class ClienteChat extends UnicastRemoteObject implements ClienteChatRemotoInterface, ClienteChatInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1728144441245668665L;
	private final String prefixoNomeCliente = "ClienteChat_";
	private String nomeCliente = "usuario_desconhecido";
	private int portaCliente = 9032;
	private String nomeServidor = "ServidorChat";
	private int portaServidor = 3230;
	private ServidorChatInterface referenciaServidor;

	protected ClienteChat() throws RemoteException, NotBoundException, MalformedURLException {
		super();
		inicializarCliente();
		conectarServidor();
	}

	protected ClienteChat(String nomeCliente, int portaCliente)
			throws RemoteException, NotBoundException, MalformedURLException {
		super();
		this.nomeCliente = nomeCliente;
		this.portaCliente = portaCliente;
		inicializarCliente();
		conectarServidor();
	}

	protected ClienteChat(String nomeCliente, int portaCliente, String nomeServidor, int portaServidor)
			throws RemoteException, NotBoundException, MalformedURLException {
		super();
		this.nomeCliente = nomeCliente;
		this.portaCliente = portaCliente;
		this.nomeServidor = nomeServidor;
		this.portaServidor = portaServidor;
		inicializarCliente();
		conectarServidor();
	}

	private void inicializarCliente() throws RemoteException {
		System.out.println(LocalDateTime.now() + " - Inicializando cliente de chat...");
		LocateRegistry.createRegistry(this.portaCliente).rebind(this.prefixoNomeCliente + this.nomeCliente, this);
		System.out.println(LocalDateTime.now() + " - Cliente de chat pronto.");
	}

	private void conectarServidor() throws RemoteException, NotBoundException, MalformedURLException {
		System.out.println(LocalDateTime.now() + " - Conectando ao servidor [" + this.nomeServidor + "]...");
		this.referenciaServidor = (ServidorChatInterface) LocateRegistry.getRegistry(this.portaServidor)
				.lookup(this.nomeServidor);

		this.referenciaServidor.adicionarUsuario(this.nomeCliente, this.portaCliente,
				this.prefixoNomeCliente + this.nomeCliente);

		System.out.println(LocalDateTime.now() + " - Conectado ao servidor.");
	}

	@Override
	public void receberMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	@Override
	public void iniciarConversa() throws RemoteException {
		System.out.println("Digite /sair para sair do chat.");

		try (Scanner scanner = new Scanner(System.in)) {
			String texto;

			while (true) {
				texto = scanner.nextLine();
				if (texto.equals("/sair"))
					break;
				referenciaServidor.transmitirMensagem(texto, this.nomeCliente);
			}
		}
		referenciaServidor.removerUsuario(this.nomeCliente);
	}
}
