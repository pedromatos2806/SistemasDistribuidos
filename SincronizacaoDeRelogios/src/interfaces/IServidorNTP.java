package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface que define o contrato do servidor NTP.
 */
public interface IServidorNTP extends Remote {
	String obterTimestamp() throws RemoteException, InterruptedException;
}
