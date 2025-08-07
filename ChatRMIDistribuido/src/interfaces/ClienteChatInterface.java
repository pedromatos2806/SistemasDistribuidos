package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface do cliente remoto para receber mensagens
public interface ClienteChatInterface extends Remote {
    // Método chamado pelo servidor para entregar mensagem ao cliente
    void receberMensagem(String mensagem) throws RemoteException;
}
