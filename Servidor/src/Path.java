import java.util.ArrayList;

public class Path {

	private ArrayList<String> diretorio = new ArrayList<>();

	public Path(){
		this.diretorio.add("root");
		this.diretorio.add("jpeumesmo");
	}
	
	public void removeOfPath(String nome){
		this.diretorio.remove(nome);
	}
	public void addToPath(String nova){
		this.diretorio.add(nova);
	}
	public ArrayList<String> getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(ArrayList<String> diretorio) {
		this.diretorio = diretorio;
	}
	
	
}
