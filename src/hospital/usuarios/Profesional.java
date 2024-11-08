package hospital.usuarios;

public class Profesional extends Usuario {

    // Atributos

    private int matricula;

    // Constructor

    public Profesional(String nombre, int matricula) {
        super(nombre);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    //Sobreescribimos

    @Override
    public String toString() {
        return nombre +  "[" + matricula + "]";
    }
}
