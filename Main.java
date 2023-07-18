package paquete_biblioteca;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
	public static void pasarVector(ArrayList vector_numeros) {
		vector_numeros.add(0);
		vector_numeros.add(1);
		vector_numeros.add(2);
		System.out.println(vector_numeros);
	}
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        // Agregar libros a la biblioteca
        Libro libro1 = new Libro("1234567890", "El nombre del viento", new Date(), new String[]{"Patrick Rothfuss"}, 5);
        biblioteca.agregarLibro(libro1);
        Libro libro2 = new Libro("0987654321", "La música del silencio", new Date(), new String[]{"Patrick Rothfuss"}, 3);
        biblioteca.agregarLibro(libro2);

        // Consultar stock de libros
        int stock = biblioteca.consultarStockDeLibrosPorTitulo("El nombre del viento");
        System.out.println("Stock de 'El nombre del viento': " + stock);

        //Consultar stock por autor
        stock = biblioteca.consultarStockDeLibrosPorAutor("Patrick Rothfuss");
        System.out.println("Stock de libros de Patrick Rothfuss: " +stock);

        // Prestar libro
        Cliente cliente1 = new Cliente("Juan", "Pérez", "123456");
        biblioteca.prestarLibro(libro1, cliente1);

        // Consultar libros prestados
        List<Libro> librosPrestados = biblioteca.consultarLibrosPrestadosPorCliente(cliente1);
        for (Libro libro : librosPrestados) {
            System.out.println(libro.getTitulo());
        }
        
        ArrayList vector_figuras = new ArrayList();
        
        pasarVector(vector_figuras);    
    }
}
