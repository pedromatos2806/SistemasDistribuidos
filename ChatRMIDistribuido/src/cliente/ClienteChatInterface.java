package cliente;

import java.rmi.RemoteException;

/**
 * Interface local para interação do cliente.
 */
public interface ClienteChatInterface {
	void iniciarConversa() throws RemoteException;
}
