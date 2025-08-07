package cliente;

import interfaces.ClienteChatInterface;
import interfaces.ServidorChatInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

// Implementação do cliente de chat RMI
public class ClienteChat extends UnicastRemoteObject implements ClienteChatInterface {
    private static final long serialVersionUID = 1L;
    private String nomeUsuario;
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
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            servidor = (ServidorChatInterface) registro.lookup("ServidorChat");
            servidor.adicionarUsuario(nomeUsuario, this);
            System.out.println("**** Bem-vindo ao chat, " + nomeUsuario + "! ****");
            Scanner scanner = new Scanner(System.in);
            String texto;
            while (true) {
                texto = scanner.nextLine();
                if (texto.equalsIgnoreCase("/sair")) {
                    servidor.removerUsuario(nomeUsuario);
                    System.out.println("**** Você saiu do chat.... ****");
                    break;
                }
                servidor.enviarMensagem(texto, nomeUsuario);
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
