// Definición de la clase Tarea
public class Tarea {
    // Variables miembro privadas para almacenar el nombre y la descripción de la tarea
    private String nombre;
    private String descripcion;

    // Constructor de la clase que recibe un nombre y una descripción al crear un objeto Tarea
    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Método para obtener el nombre de la tarea
    public String getNombre() {
        return nombre;
    }

    // Método para obtener la descripción de la tarea
    public String getDescripcion() {
        return descripcion;
    }
}


