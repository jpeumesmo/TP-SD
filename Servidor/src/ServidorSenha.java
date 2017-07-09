import java.rmi.RemoteException;
import java.util.ArrayList;

public class ServidorSenha implements Senha{

	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public ServidorSenha(){
		if (usuarios.size() == 0){
			usuarios.add(new Usuario("root","123"));
		}
	}
	@Override
	public boolean logar(String userName,String password) throws RemoteException {
		// TODO Auto-generated method stub
		//TEM A ADICIONAR BD AQUI
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getUserName().equals(userName) && 
					usuarios.get(i).getPassword().equals(password) ){
				return true;
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

}
