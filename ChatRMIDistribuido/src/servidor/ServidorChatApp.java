package servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import servidor.ServidorChat;

// Aplicação principal para iniciar o servidor de chat
public class ServidorChatApp {
    public static void main(String[] args) {
        try {
            iniciarServidor();
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void iniciarServidor() throws Exception {
        ServidorChat servidor = new ServidorChat();
        Registry registro = LocateRegistry.createRegistry(1099);
        registro.rebind("ServidorChat", servidor);
        System.out.println("Servidor RMI pronto para receber conexões!!!!");
    }
}
