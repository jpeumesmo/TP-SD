import java.rmi.RemoteException;

public class ServidorArquivo implements Arquivo{

	@Override
	public boolean mkdir() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rmdir() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String ls() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean put() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cd(String path) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
