package cliente;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteChatApp {
	public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        ClienteChatInterface cliente;

        if (args.length == 2) {
            cliente = new ClienteChat(args[0], Integer.parseInt(args[1]));
        } else if (args.length == 4) {
            cliente = new ClienteChat(args[0], Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
        } else {
            cliente = new ClienteChat();
        }

        cliente.iniciarConversa();
    }
}
