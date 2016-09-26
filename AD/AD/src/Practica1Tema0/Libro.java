package Practica1Tema0;

/**
 *
 * @author Alvaro
 */
public class Libro implements Comparable<Libro> {

    public int isbn;
    public String titulo;

    public Libro(int isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + '}';
    }

    @Override
    public int compareTo(Libro lib) {
        return this.isbn - lib.isbn;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
