import java.rmi.RemoteException;

public class ServidorArquivoImple implements Arquivo{
	
	private static Path path;
	private String diretorioAtual;
	
	public ServidorArquivoImple(){
		
	}
	@Override
	public boolean mkdir(String nome) throws RemoteException {
		// TODO Auto-generated method stub
		path.addToPath(diretorioAtual+"/"+nome);
		return false;
	}

	@Override
	public boolean rmdir(String nome) throws RemoteException {
		// TODO Auto-generated method stub
		path.removeOfPath(diretorioAtual+"/"+nome);
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
	@Override
	public void log(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		this.diretorioAtual = userName;
	}
	
	

}
