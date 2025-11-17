import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {

    private ArrayList<Libro> libros = new ArrayList<Libro>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Prestamos> prestamos = new ArrayList<Prestamos>();
    ArrayList<Libro> respaldoLibros = new ArrayList<>();
    ArrayList<Usuario> respaldoUsuarios = new ArrayList<>();
    ArrayList<Prestamos> respaldoPrestamos = new ArrayList<>();
    
    public void guardarEstadoLibros() {
        // Copia superficial de la lista (suficiente para una versión simple)
        respaldoLibros = new ArrayList<>(libros);
    }
     public void guardarEstadoUsuarios() {
        // Copia superficial de la lista (suficiente para una versión simple)
        respaldoUsuarios = new ArrayList<>(usuarios);
    }
        public void guardarEstadoPrestamos() {
            respaldoPrestamos = new ArrayList<>(prestamos);
        }

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
        guardarEstadoLibros();
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
        guardarEstadoLibros();
        l.setTitulo(nuevoTitulo);
        l.setAutor(nuevoAutor);
        l.setCategoria(nuevaCategoria);
        return true;
    }

    public boolean eliminarLibro(String titulo) {
        for (int i = 0; i < libros.size(); i++) {
            Libro l = libros.get(i);
            if (l.getTitulo().equals(titulo)) {
                guardarEstadoLibros();
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

    public void deshacerLibros() {
        // Regresa al estado anterior
        libros = new ArrayList<>(respaldoLibros);
        System.out.println("Último cambio deshecho.");
    }

     public void deshacerUsuarios() {
        // Regresa al estado anterior
        usuarios = new ArrayList<>(respaldoUsuarios);
        System.out.println("Último cambio deshecho.");
    }

           // ===== USUARIOS =====
    public Usuario buscarUsuario(String id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id))
                return usuarios.get(i);
        }
        return null;
    }

    public void registrarUsuarios(Usuario u) {
        guardarEstadoUsuarios();
        usuarios.add(u);
        
    }

    public boolean removerUsuario(String id) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u.getId().equals(id)) {
                guardarEstadoUsuarios();
                usuarios.remove(i);  
                return true;
            }
        }
        return false;
    }

    public void listarUsuarios() {
        System.out.println("Usuarios ");
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

    // ===== PRESTAMOS =====

    public boolean prestarLibro(String idUsuario, String tituloLibro) {
     guardarEstadoLibros();
     guardarEstadoUsuarios();

            Usuario usuario = buscarUsuario(idUsuario);
            Libro l = buscarLibro(tituloLibro);
            if(usuario == null){
                System.out.println("Usuario no encontrado.");
                return false;   
            }
            if (l == null) {
                System.out.println("Libro no encontrado.");
                return false;
            }
            if (!l.isDisponible()) {
                System.out.println("Libro no disponible.");
                return false;
            }
            l.setDisponible(false);
            usuario.agregarLibroPrestado(l);
            System.out.println("Libro prestado exitosamente.");
            return true;
        }
        public boolean devolverLibro(String idUsuario, String tituloLibro) {
         guardarEstadoLibros();
         guardarEstadoUsuarios(); 

            Usuario usuario = buscarUsuario(idUsuario);
            Libro l = buscarLibro(tituloLibro);

            if (usuario == null) {
                System.out.println("Usuario no encontrado.");
                return false;
            }
            if (l == null) {
                System.out.println("Libro no encontrado.");
                return false;
            }
            if(usuario.removerLibroPrestado(tituloLibro)){
                l.setDisponible(true);
                System.out.println("Libro devuelto exitosamente.");
                return true;
            } else {
                System.out.println("El usuario no tiene este libro prestado.");
                return false;
            }
        }

    public void deshacerUltimaAccion() {
        deshacerLibros();
        deshacerUsuarios();
        System.out.println("Último cambio deshecho."); 
    }
}

 
