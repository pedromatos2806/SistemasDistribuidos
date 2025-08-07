package cliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import interfaces.ClienteChatInterface;
import interfaces.ServidorChatInterface;

// Implementação do cliente de chat RMI
public class ClienteChat extends UnicastRemoteObject implements ClienteChatInterface {
    private static final long serialVersionUID = 1L;
    private final String nomeUsuario;
    private ServidorChatInterface servidor;

    public ClienteChat(String nomeUsuario) throws RemoteException {
        super();
        this.nomeUsuario = nomeUsuario;
    }

    @Override
    public void receberMensagem(String mensagem) throws RemoteException {
        System.out.println(mensagem);
    }

    public void iniciarChat() {
        try {
            conectarAoServidor();
            exibirMensagemBoasVindas();
            gerenciarEntradaUsuario();
        } catch (Exception e) {
            tratarErro(e, "Erro ao iniciar o chat");
        }
    }

    private void conectarAoServidor() throws Exception {
        Registry registro = LocateRegistry.getRegistry("localhost", 1099);
        servidor = (ServidorChatInterface) registro.lookup("ServidorChat");
        servidor.adicionarUsuario(nomeUsuario, this);
    }

    private void exibirMensagemBoasVindas() {
        System.out.println("**** Bem-vindo ao chat, " + nomeUsuario + "! ****");
        System.out.println("Digite suas mensagens abaixo. Para sair, digite '/sair'.");
    }

    private void gerenciarEntradaUsuario() throws RemoteException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String texto = scanner.nextLine();
            if (texto.equalsIgnoreCase("/sair")) {
                sairDoChat();
                break;
            }
            enviarMensagem(texto);
        }
        scanner.close();
    }

    private void enviarMensagem(String mensagem) throws RemoteException {
        servidor.enviarMensagem(mensagem, nomeUsuario);
    }

    private void sairDoChat() throws RemoteException {
        servidor.removerUsuario(nomeUsuario);
        System.out.println("**** Você saiu do chat.... ****");
    }

    private void tratarErro(Exception e, String mensagem) {
        System.err.println(mensagem + ": " + e.getMessage());
        e.printStackTrace();
    }
}
