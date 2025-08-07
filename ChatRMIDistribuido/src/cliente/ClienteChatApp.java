package cliente;

// Aplicação principal para iniciar o cliente de chat
public class ClienteChatApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Informe seu nome de usuário como argumento!");
            return;
        }
        String nomeUsuario = args[0];
        try {
            ClienteChat cliente = new ClienteChat(nomeUsuario);
            cliente.iniciarChat();
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
