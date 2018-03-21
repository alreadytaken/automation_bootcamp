package test.PedidosYa;

public class Bandera{

	private String nombre;

	private String url; 
	
	public Bandera(String nom, String link) {
		
		this.nombre = nom;
		this.url = link;
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public String getUrl() {
		
		return url;
	}
}
