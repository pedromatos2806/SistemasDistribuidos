package servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import interfaces.IServidorNTP;

public class ServidorNTP extends UnicastRemoteObject implements IServidorNTP {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8652483838443150823L;
	private static final int PORTA = 3240;
    private static final String NOME = "ServidorNTP";
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public ServidorNTP() throws RemoteException {
        super();
        inicializarServidor();
    }

    private void inicializarServidor() throws RemoteException {
        System.out.println(LocalDateTime.now().format(FORMATO) + " - Servidor NTP inicializando...");
        LocateRegistry.createRegistry(PORTA).rebind(NOME, this);
        System.out.println(LocalDateTime.now().format(FORMATO) + " - Servidor NTP pronto para uso.");
    }

    public static void main(String[] args) throws RemoteException {
        new ServidorNTP();
    }

    @Override
    public String obterTimestamp() throws RemoteException, InterruptedException {
        Random aleatorio = new Random();
        Thread.sleep(aleatorio.nextInt(2000));
        String agora = LocalDateTime.now().format(FORMATO);
        Thread.sleep(aleatorio.nextInt(2000));
        return agora;
    }
}
