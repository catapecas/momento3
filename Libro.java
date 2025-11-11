
public class Libro {
    private String titulo;
    private String autor;
    private String categoria;
    private boolean disponible;

    public Libro(String titulo, String autor, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponible = true; // cuando se crea un libro esta disponible

    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;

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

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

     @Override
    public String toString() {
        return "Libro [" + "titulo=" + titulo + ", autor=" + autor + ", categoria=" + categoria + ", disponible=" + disponible + ']';
    }

}