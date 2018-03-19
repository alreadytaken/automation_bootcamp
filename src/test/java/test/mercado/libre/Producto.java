package test.mercado.libre;

public class Producto {
	
	private String nombre;
	private String precio;
	private String descuento;
	
	public Producto(String nom, String pr, String desc) {
		nombre = nom;
		precio = pr;
		descuento = desc;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getPrecio(){
		return precio;
	}
	
	public String getDescuento(){
		return descuento;
	}

	public boolean equals(Producto p) {
		if((this.nombre == p.getNombre())&&(this. precio == p.getPrecio())&&(this.descuento == p.getDescuento()))
			return true;
		else
			return false;
	}

}
