import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ServidorSenhaImple extends UnicastRemoteObject implements Senha{

	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public ServidorSenhaImple() throws RemoteException{
		if (usuarios.size() == 0){
			usuarios.add(new Usuario("root","123"));
			usuarios.add(new Usuario("jpeumesmo","123"));
		}
	}
	@Override
	public boolean logar(String userName,String password) throws RemoteException {
		// TODO Auto-generated method stub
		//TEM A ADICIONAR BD AQUI
		if (userName.equals("root")){
			byte[] chave = "0123456789abcdef".getBytes();
			try {
				byte[] decriptado = Decripta(password.getBytes(), chave);
				String senha = new String(decriptado);
				System.out.println(senha);
				if (senha.equals("123")){
					return true;
				}else{
					return false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println(userName);
			System.out.println(password);
			for (int i = 0; i < usuarios.size(); i++) {
				if (usuarios.get(i).getUserName().equals(userName) && 
						usuarios.get(i).getPassword().equals(password) ){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean useradd(String userName, String password) throws RemoteException {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario(userName,password);
		usuarios.add(usuario);
		return true;
	}

	@Override
	public boolean userdel(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getUserName().equals(userName) ){
				usuarios.remove(i);
				return true;
			}
		}

		return false;
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
