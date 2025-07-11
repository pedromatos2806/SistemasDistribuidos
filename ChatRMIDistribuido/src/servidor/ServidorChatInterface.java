package servidor;

import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

/**
 * Interface remota do servidor de chat.
 */
public interface ServidorChatInterface {
	void transmitirMensagem(String mensagem, String nomeUsuario) throws RemoteException;

	void adicionarUsuario(String nomeUsuario, int portaCliente, String nomeObjetoCliente)
			throws RemoteException, NotBoundException, MalformedURLException;

	void removerUsuario(String nomeUsuario) throws RemoteException;
}
