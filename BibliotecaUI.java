import java.util.Scanner;

public class BibliotecaUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca bib = new Biblioteca();

        boolean ejecutar = true;
        while (ejecutar) {
            System.out.println("\n==== Menú Biblioteca ====");
            System.out.println("1) Libros");
            System.out.println("2) Usuarios");
            System.out.println("0) Salir");
            System.out.print("Elegir una opción: ");
            String opt = sc.nextLine();

            if ("1".equals(opt))
                librosMenu(sc, bib);
            else if ("2".equals(opt))
                usuariosMenu(sc, bib);
            else if ("0".equals(opt))
                ejecutar = false;
            else
                System.out.println("Opción Inválida.");
        }
        sc.close();
        System.out.println("Fin de la Ejecución");
    }

    private static void librosMenu(Scanner sc, Biblioteca bib) {
        boolean regresar = false;
        while (!regresar) {
            System.out.println("\n-- Libros --");
            System.out.println("1) Agregar");
            System.out.println("2) Actualizar");
            System.out.println("3) Eliminar");
            System.out.println("4) Listar");
            System.out.println("0) Regresar");
            System.out.print("Elegir opción : ");
            String o = sc.nextLine();

            if ("1".equals(o)) {
                String autor = sc.nextLine();
                System.out.print("ISBN: ");
                System.out.print("Titulo: ");
                String titulo = sc.nextLine();
                System.out.print("Autor: ");
                String isbn = sc.nextLine();
                System.out.print("Categoria: ");
                String categoria = sc.nextLine();
                bib.agregarLibro(new Libro(isbn, titulo, autor,categoria));

            } else if ("2".equals(o)) {
                System.out.println("Nuevo isbn del libro a actualizar: ");
                System.out.print("Nuevo titulo: ");
                String titulo = sc.nextLine();
                System.out.print("Nuevo Autor: ");
                String autor = sc.nextLine();
                System.out.print("Nueva Categoria: ");
                String categoria = sc.nextLine();
                if (!bib.actualizarLibro(titulo, autor, categoria))
                    System.out.println("Libro no encontrado.");

            } else if ("3".equals(o)) {
                System.out.print("Titulo a eliminar: ");
                String titulo = sc.nextLine();
                if (!bib.eliminarLibro(titulo))
                    System.out.println("Libro no encontrado.");
            } else if ("4".equals(o)) {
                bib.listarLibros();
            } else if ("0".equals(o))
                regresar = true;
            else
                System.out.println("Opción inválida.");
        }
    }

    private static void usuariosMenu(Scanner sc, Biblioteca bib) {
        boolean regresar = false;
        while (!regresar) {
            System.out.println("\n-- Usuario --");
            System.out.println("1) Registrar");
            System.out.println("2) Eliminar");
            System.out.println("3) Listar");
            System.out.println("0) Regresar");
            System.out.print("Elegir una opción: ");
            String o = sc.nextLine();

            if ("1".equals(o)) {
                System.out.print("Id: ");
                String id = sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                bib.registrarUsuarios(new Usuario(id, nombre));
            } else if ("2".equals(o)) {
                System.out.print("Remover usuario por Id: ");
                String id = sc.nextLine();
                if (!bib.removerUsuario(id))
                    System.out.println("Usuario no encontrado.");
            } else if ("3".equals(o)) {
                bib.listarUsuarios();
            } else if ("0".equals(o))
                regresar = true;
            else
                System.out.println("opcion inválida.");
        }
    }

}