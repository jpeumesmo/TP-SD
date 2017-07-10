import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

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
	
	public void desconectar(){
		try {
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void comando(String comando){
		try{

			ObjectOutputStream objetoEnviado = new ObjectOutputStream(cliente.getOutputStream());
			objetoEnviado.writeUTF(comando);
			objetoEnviado.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
				byte[] mensagem = password.getBytes();
			    byte[] chave = "0123456789abcdef".getBytes();
			    
			    try {
			    	objetoEnviado.writeUTF(userName);	
					byte[] encriptado = Encripta(mensagem, chave);
					objetoEnviado.writeUTF(new String(encriptado));
					objetoEnviado.flush();
			    } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
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
	public static byte[] Encripta(byte[] msg, byte[] chave) throws Exception {
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"));
	    byte[] encrypted = cipher.doFinal(msg);
	    return encrypted;
	}

	public static byte[] Decripta(byte[] msg, byte[] chave) throws Exception {
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(chave, "AES"));
	    byte[] decrypted = cipher.doFinal(msg);
	    return decrypted;
	}
}
