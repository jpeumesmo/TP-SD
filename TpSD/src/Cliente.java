import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	//ATRIBUTOS
	private String ip;
	private int porta;
	private Socket cliente;

	public Cliente(String ip, int porta) throws UnknownHostException, IOException{
		this.ip = ip;
		this.porta = porta;
		this.conectar();
	}

	public void conectar() throws UnknownHostException, IOException{
		cliente = new Socket(this.ip,this.porta);
	}

	public boolean logar(String userName,String password){
		
		try{

			ObjectOutputStream objetoEnviado = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream resposta = new ObjectInputStream(cliente.getInputStream());
			
			if(userName.equals("root")){
				//CONEXAO CRIPTROGRAFADA
				
				
				
				return resposta.readBoolean();
			}else{
				//CONEXAO NORMAL
				objetoEnviado.writeUTF(userName);	
				objetoEnviado.writeUTF(password);
				objetoEnviado.flush();
				
				return resposta.readBoolean();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
