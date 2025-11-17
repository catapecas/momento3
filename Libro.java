
public class Libro {
    private String titulo;
    private String autor;
    private String categoria;
    private boolean disponible;


// constructor inicializa  nombre de la clase
    public Libro(String titulo, String autor,String categoria) { 
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponible = true; // cuando se crea un libro esta disponible

    }

    // firma metodo publico ,retorna String, no recibe parametro tipo String     
 
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;

    } 

    public String getCategoria() {
        return categoria;
    }

    
    // firma metodo publico , no retorna nada, recibe un parametro tipo String   

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    // void no retorna
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

      /*tostring es un metodo de la clase object , 
      que se implementa en las clases diferentes se llama sobreescritura @override 
    */
     @Override
    public String toString() {
        return "Libro [titulo=" + titulo + ", autor=" + autor + ", categoria=" + categoria + ", disponible=" + disponible + ']';
    }

}