import java.util.ArrayList;
import java.util.List;

// La línea anterior importa las clases ArrayList y List del paquete java.util.

public class ListaDeTareas {
    // Declaración de la clase ListaDeTareas.

    private String nombre;
    // Declaración de una variable privada llamada 'nombre' que almacenará el nombre de la lista de tareas.

    private List<Tarea> tareas;
    // Declaración de una variable privada llamada 'tareas' que será una lista de objetos de tipo Tarea.

    public ListaDeTareas(String nombre) {
        // Constructor de la clase ListaDeTareas que toma un argumento 'nombre'.
        this.nombre = nombre;
        // Inicializa la variable 'nombre' con el valor pasado como argumento.
        this.tareas = new ArrayList<>();
        // Inicializa la variable 'tareas' como una nueva instancia de ArrayList, que es una implementación de la interfaz List.
    }

    public String getNombre() {
        // Método para obtener el nombre de la lista de tareas.
        return nombre;
    }

    public void agregarTarea(Tarea tarea) {
        // Método para agregar una tarea a la lista.
        tareas.add(tarea);
        // Agrega la tarea pasada como argumento a la lista de tareas.
    }

    public List<Tarea> getTareas() {
        // Método para obtener la lista de tareas.
        return tareas;
    }
}
