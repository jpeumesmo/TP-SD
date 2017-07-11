import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Arquivo extends Remote{
	boolean mkdir() throws RemoteException;
	boolean rmdir() throws RemoteException;
	String ls() throws RemoteException;
	boolean put() throws RemoteException;
	Object get() throws RemoteException;
	String cd(String path) throws RemoteException;
}
