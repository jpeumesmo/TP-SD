import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ServidorConexao implements Runnable{

	//ATRIBUTOS

	private Socket cliente;
	//private static ServidorSenhaImple servidorSenha = new ServidorSenhaImple();
	private static Senha servidorSenha;
	private static ServidorArquivo servidorArquivo = new ServidorArquivo();

	public ServidorConexao(Socket cliente){
		this.cliente = cliente;
		try {
			servidorSenha = (Senha) Naming.lookup("//127.0.0.1:1099/SenhaService");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void run(){

		//VARIAVEIS DE COMUNICACAO


			try {
			//	DataInputStream tipoOperacao = new DataInputStream(cliente.getInputStream());
			
			ObjectInputStream objetoRecebido = new ObjectInputStream(cliente.getInputStream());
			ObjectOutputStream objetoEnviado = new ObjectOutputStream(cliente.getOutputStream());
			//DataOutputStream resposta = new DataOutputStream(cliente.getOutputStream());

			//VARIAVEIS PARA RECEBER E ENVIAR ARQUIVOS
			//byte[] buffer = new byte[4096];//buffer de 4kb
		//	int len = 0;


			//TESTE
			System.out.println(cliente.getInetAddress());
			String userName = objetoRecebido.readUTF();
			String password = objetoRecebido.readUTF();
			boolean answer = servidorSenha.logar(userName, password);
			objetoEnviado.writeBoolean(answer);
			objetoEnviado.flush();

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}


}
