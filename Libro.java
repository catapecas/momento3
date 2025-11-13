
public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private String categoria;
    private boolean disponible;

    public Libro(String titulo, String autor,String isbn, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.disponible = true; // cuando se crea un libro esta disponible

    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;

    }

    public String getIsbn() {
        return isbn;
    }   

    public String getCategoria() {
        return categoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }   

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

     @Override
    public String toString() {
        return "Libro [" + "titulo=" + titulo + ", autor=" + autor + ",isbn=" + isbn + ", categoria=" + categoria + ", disponible=" + disponible + ']';
    }

}