import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorConexao implements Runnable{

	//ATRIBUTOS

	private Socket cliente;
	private static ServidorSenha servidorSenha = new ServidorSenha();
	private static ServidorArquivo servidorArquivo = new ServidorArquivo();

	public ServidorConexao(Socket cliente){
		this.cliente = cliente;
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
			System.out.println(userName);
			System.out.println(password);
			boolean answer = servidorSenha.logar(userName, password);
			objetoEnviado.writeBoolean(answer);
			objetoEnviado.flush();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}


}
