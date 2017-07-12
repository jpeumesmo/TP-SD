import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
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
//			String chave = new String ("0123456789abcdef");
			try {
		//		System.out.println(password);
	//			System.out.println(new String (password));
	//			String  decriptado = Decripta(password, chave);
//				System.out.println(decriptado);
				if (password.equals("123")){
					return true;
				}else{
					return false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
	//			System.out.println("aqui");
				e.printStackTrace();
			}
		}else{
	//		System.out.println(userName);
	//		System.out.println(password);
	//		System.out.println(new String(password));
			for (int i = 0; i < usuarios.size(); i++) {
				if (usuarios.get(i).getUserName().equals(userName) && 
						usuarios.get(i).getPassword().equals(new String(password)) ){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean useradd(String userName, String password) throws RemoteException {
		// TODO Auto-generated method stub
		//System.out.println("chegou");
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

	public static byte[] Encripta(String textopuro, String chaveencriptacao) throws Exception {
		Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(new String("AAAAAAAAAAAAAAAA").getBytes("UTF-8")));
		return encripta.doFinal(textopuro.getBytes("UTF-8"));
	}

	public static String Decripta(byte[] textoencriptado, String chaveencriptacao) throws Exception{
		Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(new String("AAAAAAAAAAAAAAAA").getBytes("UTF-8")));
		return new String(decripta.doFinal(textoencriptado),"UTF-8");
	}

}
