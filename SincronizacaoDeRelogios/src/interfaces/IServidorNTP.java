package interfaces;

import java.rmi.RemoteException;

/**
 * Interface que define o contrato do servidor NTP.
 */
public interface IServidorNTP {
	String obterTimestamp() throws RemoteException, InterruptedException;
}
