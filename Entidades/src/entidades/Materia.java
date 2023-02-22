
package entidades;

public class Materia {
    
    String nombre;
    int calificacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Materia{" + "nombre=" + nombre + ", calificacion=" + calificacion + '}';
    }
    
}
