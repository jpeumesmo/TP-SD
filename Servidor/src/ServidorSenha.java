import java.rmi.registry.Registry;

public class ServidorSenha {

	public ServidorSenha(){
		try{ 
			Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
			r.rebind("SenhaService", new ServidorSenhaImple());
        }  
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
	}
	public static void main(String[] args)  { 
        new ServidorSenha(); 
    } 
}
