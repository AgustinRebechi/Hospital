package hospital;

import hospital.estudios.Estado;
import hospital.estudios.Estudio;
import hospital.usuarios.Profesional;
import hospital.usuarios.Paciente;

public class Receta {
    private int id;
    private Paciente paciente;
    private Profesional profesional;
    private Estudio[] estudios;
    private Estado estado;

    //Constructor

    public Receta(int id, Paciente paciente, Profesional profesional, Estudio[] estudio){
        this.id = id;
        this.paciente = paciente;
        this.profesional = profesional;
        this.estudios = estudio;
        estado = Estado.PENDIENTE;
    }

    //metodos

    public boolean estaProcesada(){
        if(estado == Estado.PROCESADA){
            return true;
        }
        return false;
    }

    public void procesar() {
        estado = Estado.PROCESADA;
        for (Estudio e: estudios){
            e.procesar(paciente, profesional);
        }
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public int cantidadEstudios() {
        return estudios.length;
    }

    // Sobreescribimos
    @Override

    public String toString() {
        String salida =  "Receta" + id +
                "\n- Profesional: " + profesional +
                "\n- Paciente: " + paciente +
                "\n- Estado: " + estado +
                "\n- Estudios: " + estudios;
        for(Estudio e : estudios){
            salida += e.toString();
        }
        return salida;
    }


}
