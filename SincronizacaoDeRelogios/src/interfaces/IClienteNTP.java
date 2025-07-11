package interfaces;

import java.rmi.RemoteException;

/**
 * Interface que define o contrato do cliente NTP.
 */
public interface IClienteNTP {
	void sincronizarRelogio() throws RemoteException, InterruptedException;

	void exibirRelatorioSincronizacao();
}
