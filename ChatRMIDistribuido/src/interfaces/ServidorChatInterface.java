package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface do servidor de chat RMI
public interface ServidorChatInterface extends Remote {
    // Envia uma mensagem para todos os usuários conectados
    void enviarMensagem(String mensagem, String nomeUsuario) throws RemoteException;

    // Adiciona um novo usuário ao chat
    void adicionarUsuario(String nomeUsuario, ClienteChatInterface referenciaCliente) throws RemoteException;

    // Remove um usuário do chat
    void removerUsuario(String nomeUsuario) throws RemoteException;
}
