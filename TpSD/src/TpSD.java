import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TpSD {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o ip para se concetar");
		String ip = in.nextLine();
		System.out.println("Digite o numero da porta\n");
		int porta = in.nextInt();
				
		String comando;		
		String userName;
		String password;
		
		try {
			Cliente cliente = new Cliente(ip,porta);
			while(true){
				System.out.println("User");
				userName = in.next();
				System.out.println("Password");
				password = in.next();
				
				if(cliente.logar(userName,password)){
					break;
				}else{
					System.out.println("Falha no login");
					System.out.println("Tente de novo");
				}
			}
			while(true){
				System.out.println("");
				comando = in.next();

								
				if(comando.equals("exit")){
	
					
					in.close();
					break;
				}		
		}
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
