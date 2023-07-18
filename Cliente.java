package paquete_biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private final String nombre;
	private final String apellido;
	private final String dni;
	private List<Libro> libros_prestados;
	
	public Cliente(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.libros_prestados = new ArrayList<Libro>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}
	
	public List<Libro> getLibrosPrestados(){
		return(this.libros_prestados);
	}
	
	public void prestarLibro(Libro libro_ingresado) {
		this.libros_prestados.add(libro_ingresado);
	}
	
	public void devolverLibro(Libro libro_ingresado) {
		this.libros_prestados.remove(libro_ingresado);
	}
}
