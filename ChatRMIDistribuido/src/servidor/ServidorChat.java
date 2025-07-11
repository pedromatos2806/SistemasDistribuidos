package servidor;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cliente.ClienteChatRemotoInterface;

public class ServidorChat extends UnicastRemoteObject implements ServidorChatInterface {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 7428257194299748715L;
	 private String nomeServidor = "ServidorChat";
	    private int portaServidor = 3230;
	    private final List<UsuarioChat> usuariosConectados = new ArrayList<>();

	    public ServidorChat(String nomeServidor, int portaServidor) throws RemoteException {
	        super();
	        this.nomeServidor = nomeServidor;
	        this.portaServidor = portaServidor;
	        inicializarServidor();
	    }

	    public ServidorChat() throws RemoteException {
	        super();
	        inicializarServidor();
	    }

	    private void inicializarServidor() throws RemoteException {
	        System.out.println(LocalDateTime.now() + " - Inicializando servidor de chat...");
	        LocateRegistry.createRegistry(this.portaServidor).rebind(this.nomeServidor, this);
	        System.out.println(LocalDateTime.now() + " - Servidor de chat pronto para uso.");
	    }

	    private void notificarTodosUsuarios(String mensagem) throws RemoteException {
	        for (UsuarioChat usuario : usuariosConectados) {
	            usuario.referenciaCliente.receberMensagem(LocalDateTime.now() + " - <Servidor> " + mensagem
	            );
	        }
	    }

	    @Override
	    public void transmitirMensagem(String mensagem, String nomeUsuario) throws RemoteException {
	        for (UsuarioChat usuario : usuariosConectados) {
	            usuario.referenciaCliente.receberMensagem(LocalDateTime.now() + " - <" + nomeUsuario + "> " + mensagem
	            );
	        }
	    }

	    @Override
	    public void adicionarUsuario(String nomeUsuario, int portaCliente, String nomeObjetoCliente)
	            throws RemoteException, NotBoundException {
	        var referenciaCliente = (ClienteChatRemotoInterface) LocateRegistry.getRegistry(portaCliente)
	                .lookup(nomeObjetoCliente);
	        usuariosConectados.add(new UsuarioChat(nomeUsuario, referenciaCliente));
	        notificarTodosUsuarios(nomeUsuario + " entrou no chat.");
	    }

	    @Override
	    public void removerUsuario(String nomeUsuario) throws RemoteException {
	        Optional<UsuarioChat> usuarioParaRemover = usuariosConectados.stream()
	                .filter(usuario -> usuario.nome.equalsIgnoreCase(nomeUsuario))
	                .findFirst();

	        if (usuarioParaRemover.isPresent()) {
	            usuariosConectados.remove(usuarioParaRemover.get());
	            notificarTodosUsuarios(nomeUsuario + " saiu do chat.");
	        }
	    }

	    /**
	     * Classe interna para representar um usuário conectado ao chat.
	     */
	    public static class UsuarioChat {
	        private final String nome;
	        private final ClienteChatRemotoInterface referenciaCliente;

	        public UsuarioChat(String nome, ClienteChatRemotoInterface referenciaCliente) {
	            this.nome = nome;
	            this.referenciaCliente = referenciaCliente;
	        }
	    }
}
