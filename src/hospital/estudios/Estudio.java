package hospital.estudios;

import hospital.usuarios.Paciente;
import hospital.usuarios.Profesional;
import hospital.Notificador;

public abstract class Estudio {

    // atributos

    private String nombre;
    private String descripcion;
    private Estado estado;

    // Constructor

    public Estudio(String descipcion, String nombre, Estado estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = Estado.PENDIENTE;
    }

    // metodos

    public void procesar(Paciente paciente, Profesional profesional){
        estado = Estado.PROCESADA;
        Notificador.notificar(paciente, profesional, this);

    }

    // Sobreescribimos

    @Override
    public String toString() {
        return nombre + ": " + descripcion + "(" + estado + ")";
    }




}
