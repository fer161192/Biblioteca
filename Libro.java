package paquete_biblioteca;
import java.util.Date;

public class Libro {
	private final String codigo_isbn;
	private final String titulo;
	private final Date fechaPublicacion;
	private final String autores[];
	private int stock;
	
	public Libro(String codigo_ingresado,String titulo_ingresado,Date date_ingresado,String autores_ingresado[],int stock_ingresado) {
		this.codigo_isbn = codigo_ingresado;
		this.titulo = titulo_ingresado;
		this.autores = autores_ingresado;
		this.fechaPublicacion = date_ingresado;
		this.stock = stock_ingresado;
	}
	
	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCodigo_isbn() {
		return this.codigo_isbn;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public String[] getAutores() {
		return this.autores;
	}
}
