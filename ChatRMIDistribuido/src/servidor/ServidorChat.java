package servidor;

import interfaces.ServidorChatInterface;
import interfaces.ClienteChatInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Implementação do servidor de chat RMI
public class ServidorChat extends UnicastRemoteObject implements ServidorChatInterface {
    private static final long serialVersionUID = 1L;
    private final Map<String, ClienteChatInterface> usuarios;

    public ServidorChat() throws RemoteException {
        super();
        usuarios = new ConcurrentHashMap<>();
        System.out.println("Servidor de chat iniciado!");
    }

    @Override
    public synchronized void enviarMensagem(String mensagem, String nomeUsuario) throws RemoteException {
        String texto = "[" + nomeUsuario + "]: " + mensagem;
        for (ClienteChatInterface cliente : usuarios.values()) {
            cliente.receberMensagem(texto);
        }
        System.out.println("Mensagem enviada: " + texto);
    }

    @Override
    public synchronized void adicionarUsuario(String nomeUsuario, ClienteChatInterface referenciaCliente) throws RemoteException {
        usuarios.put(nomeUsuario, referenciaCliente);
        enviarMensagem(nomeUsuario + " entrou no chat.", "Sistema");
        System.out.println("Usuário adicionado: " + nomeUsuario);
    }

    @Override
    public synchronized void removerUsuario(String nomeUsuario) throws RemoteException {
        usuarios.remove(nomeUsuario);
        enviarMensagem(nomeUsuario + " saiu do chat.", "Sistema");
        System.out.println("Usuário removido: " + nomeUsuario);
    }
}
