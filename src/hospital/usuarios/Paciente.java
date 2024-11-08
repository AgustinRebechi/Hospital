package hospital.usuarios;

public class Paciente extends Usuario {

    //Atributos

    private int dni;

    // Constructor

    public Paciente(int dni, String nombre) {
        super(nombre);
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return nombre + "(" + dni + ")";
    }
}
