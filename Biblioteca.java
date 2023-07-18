package paquete_biblioteca;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
	private List<Libro> lista_libros;
	private List<Cliente> lista_clientes;
	
	public Biblioteca() {
		this.lista_clientes = new ArrayList<Cliente>();
		this.lista_libros = new ArrayList<Libro>();
	}
	
	public void agregarLibro(Libro libro_ingresado) {
		this.lista_libros.add(libro_ingresado);
	}
	
	public void quitarLibro(Libro libro_ingresado) {
		this.lista_libros.remove(libro_ingresado);
	}
	
	public int consultarStockDeLibrosPorTitulo(String titulo_ingresado) {
		int cantidad_stock = 0;
		for (int i = 0;i<this.lista_libros.size();i++) {
			if (this.lista_libros.get(i).getTitulo().equals(titulo_ingresado)) {
				cantidad_stock = this.lista_libros.get(i).getStock();
				break;
			}
		}
		return(cantidad_stock);
	}
	
	//Se asume que el cliente, puede buscar mas de un libro por esa misma fecha ingresada.
	public int consultarStockDeLibrosPorFecha(Date fecha_ingresada) {
		int cantidad_stock = 0;
		for (int i = 0;i<this.lista_libros.size();i++) {
			if (this.lista_libros.get(i).getFechaPublicacion().equals(fecha_ingresada)) {
				cantidad_stock = cantidad_stock + this.lista_libros.get(i).getStock();
			}
		}
		return(cantidad_stock);
	}
	
	//Se asume que se puede buscar, un mismo autor, de distintos libros y por eso, no hay break.
	public int consultarStockDeLibrosPorAutor(String autor_ingresado) {
		int cantidad_stock = 0;
		for (int i = 0;i<this.lista_libros.size();i++) {
			Libro auxiliar_libro = this.lista_libros.get(i);
			for (int j = 0; j<auxiliar_libro.getAutores().length;j++) {
				if (auxiliar_libro.getAutores()[j].equals(autor_ingresado)) {
					cantidad_stock = cantidad_stock + auxiliar_libro.getStock();
				}
			}
		}
		return(cantidad_stock);
	}

	public void prestarLibro(Libro libro_ingresado,Cliente cliente_ingresado) {
		if (this.consultarStockDeLibrosPorTitulo(libro_ingresado.getTitulo()) == 0)
			System.out.println("No hay stock");
		else {
			this.lista_clientes.add(cliente_ingresado);
			for (int i = 0; i<this.lista_libros.size();i++) {
				if (this.lista_libros.get(i).equals(libro_ingresado)) {
					this.lista_libros.get(i).setStock(this.lista_libros.get(i).getStock() - 1);
					cliente_ingresado.prestarLibro(libro_ingresado);
					break;
				}
			}
		}
			
	}
	
	public void devolverLibro(Libro libro_ingresado, Cliente cliente_ingresado) {
		for (int i = 0; i<this.lista_clientes.size();i++) {
			if (this.lista_clientes.get(i).equals(cliente_ingresado)) {
				for (int j = 0; j<this.lista_libros.size();j++) {
					if (this.lista_libros.get(j).equals(libro_ingresado)) {
						this.lista_libros.get(j).setStock(this.lista_libros.get(i).getStock() + 1);
						cliente_ingresado.devolverLibro(libro_ingresado);
						break;
					}
				}
				break;
			}
		}
	}
	
	public List<Libro> consultarLibrosPrestadosPorCliente(Cliente cliente_ingresado) {
		return(cliente_ingresado.getLibrosPrestados());
	}
	
}
