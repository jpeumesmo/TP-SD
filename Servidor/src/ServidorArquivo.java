import java.rmi.registry.Registry;

public class ServidorArquivo {
	public ServidorArquivo(){
		try{ 
			Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
			r.rebind("ArquivoService", new ServidorArquivoImple());
        }  
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
	}
	public static void main(String[] args)  { 
        new ServidorArquivo(); 
    } 
}
