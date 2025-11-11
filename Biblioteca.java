import java.util.ArrayList;
import java.util.Iterator;


public class Biblioteca {


    private ArrayList<Libro> libros = new ArrayList<Libro>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    

    // ===== LIBROS =====
    public Libro buscarLibro(String titulo) {
        for (int i = 0; i < libros.size(); i++) {
            Libro l = libros.get(i);
            if (l.getTitulo().equals(titulo))
                return l;
        }
        return null;
    }

    private boolean tituloExiste(String titulo) {
        if (titulo == null) return false;
        String t = titulo.trim().toLowerCase();
        for (Libro l : libros) {
            if (l.getTitulo() != null && l.getTitulo().trim().toLowerCase().equals(t))
                return true;
        }
        return false;
    }

   


    public void agregarLibro(Libro l) {
        libros.add(l);
        //comprobar si existe ya?
        if (buscarLibro(l.getTitulo()) != null) {

            System.out.println("Libro con Titulo " + l.getTitulo() + " ya exite.");
            return;
        }

         if (tituloExiste(l.getTitulo())) {
            System.out.println("Error: Ya existe un libro con el título \"" + l.getTitulo() + "\".");
            return;
        }
       
    }

    public boolean actualizarLibro(String nuevoTitulo, String nuevoAutor, String nuevaCategoria) {
        Libro l = buscarLibro(nuevoTitulo);
        if (l == null)
            return false;
       
        l.setTitulo(nuevoTitulo);
        l.setAutor(nuevoAutor);
        l.setCategoria(nuevaCategoria);
        return true;

    }

    public boolean eliminarLibro(String titulo) {
        for (int i = 0; i < libros.size(); i++) {
            Libro l = libros.get(i);
            if (l.getTitulo().equals(titulo)) {
                libros.remove(i);
                return true;
            }
        }
        return false;
    }

    public void listarLibros() {
        System.out.println("=== Libros ===");
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    // ===== USUARIOS =====
    public Usuario buscUsuario(String id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id))
                return usuarios.get(i);
        }
        return null;
    }

    public void registrarUsuarios(Usuario u) {
        usuarios.add(u);
        
    }

    public boolean removerUsuario(String id) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u.getId().equals(id)) {
                usuarios.remove(i);  
                return true;
            }
        }
        return false;
    }

    public void listarUsuarios() {
        System.out.println("=== Usuarios ===");
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

}

 
