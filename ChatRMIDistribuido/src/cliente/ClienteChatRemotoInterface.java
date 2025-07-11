package cliente;

import java.rmi.RemoteException;

/**
 * Interface remota do cliente de chat, utilizada pelo servidor.
 */
public interface ClienteChatRemotoInterface {
	void receberMensagem(String mensagem) throws RemoteException;
}
