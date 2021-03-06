import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		int porta;

		System.out.println("Digite o numero da porta\n");
		porta = in.nextInt();
		in.nextLine();

		in.close();
		ServerSocket servidor = new ServerSocket(porta);
		System.out.println("Servidor escutando porta "+ porta);

		while (true) {
			Socket sock = null;
			try {
				sock = servidor.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			System.out.println("Conectado");
			new Thread(new ServidorConexao(sock)).start();
		}
		servidor.close();
	}
}