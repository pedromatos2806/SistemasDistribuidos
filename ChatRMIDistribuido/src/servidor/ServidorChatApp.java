package servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Aplicação principal para iniciar o servidor de chat
public class ServidorChatApp {
    public static void main(String[] args) {
        try {
            ServidorChat servidor = new ServidorChat();
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("ServidorChat", servidor);
            System.out.println("Servidor RMI pronto para receber conexões!");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
