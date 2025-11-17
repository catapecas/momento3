import java.util.ArrayList;
public class Usuario {

    private String id;
    private String nombre;
    private ArrayList<Libro> librosPrestados = new ArrayList<>();

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarLibroPrestado(Libro libro) {
        librosPrestados.add(libro);
    }

    public boolean removerLibroPrestado(String tituloLibro) {
        for (int i = 0; i < librosPrestados.size(); i++) {
            if (librosPrestados.get(i).getTitulo().equals(tituloLibro)) {
                librosPrestados.remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Usuario [" + "id=" + id + ", nombre=" + nombre + ']';
    }
}