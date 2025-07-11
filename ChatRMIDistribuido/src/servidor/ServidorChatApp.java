package servidor;

import java.rmi.RemoteException;

public class ServidorChatApp {
    public static void main(String[] args) throws RemoteException {
        if (args.length == 2)
            new ServidorChat(args[0], Integer.parseInt(args[1]));
        else
            new ServidorChat();
    }
}
