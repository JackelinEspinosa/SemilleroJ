    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
    import java.util.Scanner;

public class Principal {
    private static Map<String, ListaDeTareas> listasDeTareas = new HashMap<>(); // Declaración de un mapa para almacenar listas de tareas.
    private static Scanner scanner = new Scanner(System.in); // Inicialización de un objeto Scanner para la entrada del usuario.

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("1. Crear nueva lista de tareas"); // Imprime el menú principal.
            System.out.println("2. Ver listas de tareas");
            System.out.println("3. Ver tareas de lista");
            System.out.println("4. Actualizar lista de tareas");
            System.out.println("5. Eliminar lista de tareas");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt(); // Lee la opción seleccionada por el usuario.
            scanner.nextLine(); // Consumir la nueva línea después de leer la opción

            switch (opcion) { // Realiza una acción según la opción seleccionada por el usuario.
                case 1:
                    crearNuevaListaDeTareas(); // Llama al método para crear una nueva lista de tareas.
                    break;
                case 2:
                    verListasDeTareas(); // Llama al método para ver las listas de tareas existentes.
                    break;
                case 3:
                    verTareasDeLista(); // Llama al método para ver las tareas de una lista específica.
                    break;
                case 4:
                    actualizarListaDeTareas(); // Llama al método para actualizar una lista de tareas.
                    break;
                case 5:
                    eliminarListaDeTareas(); // Llama al método para eliminar una lista de tareas.
                    break;
                case 6:
                    System.out.println("¡Adiós!"); // Imprime un mensaje de despedida.
                    System.exit(0); // Termina el programa.
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }

    private static void crearNuevaListaDeTareas() {
        // Solicita al usuario que ingrese el nombre de la nueva lista de tareas.
        System.out.print("Nombre de la nueva lista de tareas: ");
        String nombreLista = scanner.nextLine();
        
        // Crea una nueva instancia de ListaDeTareas con el nombre proporcionado.
        ListaDeTareas nuevaLista = new ListaDeTareas(nombreLista);
        
        // Agrega la nueva lista de tareas al mapa 'listasDeTareas' utilizando el nombre como clave.
        listasDeTareas.put(nombreLista, nuevaLista);
        
        // Imprime un mensaje de éxito para informar al usuario que la lista de tareas se ha creado con éxito.
        System.out.println("Lista de tareas '" + nombreLista + "' creada con éxito.");
    }
    
    private static void verListasDeTareas() {
        // Verifica si el mapa 'listasDeTareas' está vacío.
        if (listasDeTareas.isEmpty()) {
            // Si está vacío, imprime un mensaje indicando que no hay listas de tareas disponibles.
            System.out.println("No hay listas de tareas disponibles.");
        } else {
            // Si no está vacío, imprime un encabezado y recorre todas las listas de tareas disponibles.
            System.out.println("Listas de tareas disponibles:");
            for (String nombreLista : listasDeTareas.keySet()) {
                // Imprime el nombre de cada lista de tareas y [ ] para representar tareas pendientes (a completar).
                System.out.println("- " + nombreLista + " [ ]");
            }
        }
    }

    private static void verTareasDeLista() {
        // Solicita el nombre de la lista de tareas al usuario.
        System.out.print("Nombre de la lista de tareas: ");
        String nombreLista = scanner.nextLine();
    
        // Obtén la lista de tareas correspondiente al nombre ingresado.
        ListaDeTareas lista = listasDeTareas.get(nombreLista);
    
        // Verifica si la lista existe.
        if (lista != null) {
            // Obtiene la lista de tareas asociada.
            List<Tarea> tareas = lista.getTareas();
    
            // Comprueba si la lista de tareas está vacía.
            if (tareas.isEmpty()) {
                System.out.println("La lista de tareas '" + nombreLista + "' está vacía.");
            } else {
                // Imprime las tareas en la lista.
                System.out.println("Tareas en la lista '" + nombreLista + "':");
                for (Tarea tarea : tareas) {
                    System.out.println("- " + tarea.getNombre() + ": " + tarea.getDescripcion());
                }
            }
        } else {
            // La lista de tareas no existe.
            System.out.println("La lista de tareas '" + nombreLista + "' no existe.");
        }
    }
    
    private static void actualizarListaDeTareas() {
        // Solicita el nombre de la lista de tareas a actualizar al usuario.
        System.out.print("Nombre de la lista de tareas a actualizar: ");
        String nombreLista = scanner.nextLine();
    
        // Obtén la lista de tareas correspondiente al nombre ingresado.
        ListaDeTareas lista = listasDeTareas.get(nombreLista);
    
        // Verifica si la lista existe.
        if (lista != null) {
            System.out.println("Lista de tareas '" + nombreLista + "':");
            List<Tarea> tareas = lista.getTareas();
    
            // Comprueba si la lista de tareas está vacía.
            if (tareas.isEmpty()) {
                System.out.println("La lista de tareas está vacía.");
            } else {
                // Imprime las tareas en la lista junto con su índice.
                for (int i = 0; i < tareas.size(); i++) {
                    Tarea tarea = tareas.get(i);
                    System.out.println((i + 1) + ". " + tarea.getNombre() + ": " + tarea.getDescripcion());
                }
            }
        } else {
            // La lista de tareas no existe.
            System.out.println("La lista de tareas '" + nombreLista + "' no existe.");
        }
    }

    private static void eliminarListaDeTareas() {
        // Solicitar el nombre de la lista de tareas a eliminar
        System.out.print("Nombre de la lista de tareas a eliminar: ");
        String nombreLista = scanner.nextLine();
        
        // Obtener la lista de tareas correspondiente al nombre
        ListaDeTareas lista = listasDeTareas.get(nombreLista);
        
        // Verificar si la lista existe y eliminarla si es el caso
        if (lista != null) {
            listasDeTareas.remove(nombreLista);
            System.out.println("Lista de tareas '" + nombreLista + "' eliminada con éxito.");
        } else {
            // Mostrar un mensaje si la lista no existe
            System.out.println("La lista de tareas '" + nombreLista + "' no existe.");
        }
    }
    }
