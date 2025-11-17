public class Prestamos {
   
    private String usuarioId;
    private String libroTitulo;
    
    public Prestamos(String usuarioId, String libroTitulo) {
        this.usuarioId = usuarioId;
        this.libroTitulo = libroTitulo;

    }

    public String getUsuarioId() {
        return usuarioId;
    }
    public String getLibroTitulo() {
        return libroTitulo;
    }

    public String toString() {
        return "[Prestamos usuario=" + usuarioId + ", libro=" + libroTitulo + ']';
    }
}

