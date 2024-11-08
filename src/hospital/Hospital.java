package hospital;

import hospital.estudios.Estudio;
import hospital.usuarios.Paciente;
import hospital.usuarios.Profesional;

import java.nio.file.ClosedFileSystemException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {
    private String nombre;
    private List<Profesional> profesionales;
    private List<Paciente> pacientes;
    private List<Receta> recetas;
    private static int idReceta;

    //Contructor
    public Hospital(String nombre) {
        this.nombre = nombre;
        profesionales = new ArrayList<>();
        pacientes = new ArrayList<>();
        recetas = new ArrayList<>();
        idReceta = 0;
    }

    //metodos

    public Profesional registrarProfesional(String nombre, int matricula) {
        if (matriculaRegistrada(matricula)) {
            throw new SystemException("El profesional ya está registrado");
        }
        Profesional p = new Profesional(nombre, matricula);
        profesionales.add(p);
        return p;
    }


    public Paciente registrarPaciente(String nombre, int dni){
        if (dniRegistrado(dni)) {
            throw new SystemException("El paciente ya está registrado");
        }
        Paciente p = new Paciente(dni, nombre);
        pacientes.add(p);
        return p;

    }

    public Receta cargarReceta(Profesional juana, Paciente pedro, Estudio[] estudios){
        Receta r = new Receta(idReceta, pedro, juana, estudios);
        idReceta++;
        recetas.add(r);
        return r;
    }

    private boolean dniRegistrado(int dni) {
        for (Paciente p : pacientes) {
            if (p.getDni() == dni) {
                return true;
            }
        }
        return false;
    }

    private boolean matriculaRegistrada(int matricula) {
        for (Profesional p : profesionales) {
            if (p.getMatricula() == matricula) {
                return true;
            }
        }
        return false;

    private boolean pacienteRegistrado(int dni){
        Boolean encontrado = false;
        for (Paciente p : pacientes) {
            if (p.getDni() == dni) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    private boolean profesionalRegistrado(int matricula){
        Boolean encontrado = false;
        for (Profesional p : profesionales) {
            if (p.getMatricula() == matricula) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public void procesar(Receta receta) {
        if (receta.estaProcesada()){
            throw new SystemException("la receta ya esta procesada")
        }
        receta.procesar();


    }

    public void mostrarRecetas() {
        for (Receta r : recetas){
            System.out.println(r);
        }
    }

    public void mostrarRecetasProcesadas() {
        for (Receta r : recetas){
            if (r.estaProcesada()){
                System.out.println(r);
            }
        }
    }


    public void mostrarPacientesConEstudios(int cantMinima) {
        for (Paciente p : pacientesConEstudios(cantMinima)){
            System.out.println(p);
        }
    }

    private List<Paciente> pacientesConEstudios(int cantMinima){
        Map<Integer, Integer> pacientesConEstudios = pacientesEstudios();
        List<Paciente> pacientesConEstudiosCant = ArrayList<>();

        for(Map.Entry<Integer, Integer> entrada : pacientesEstudios().entrySet()){
            if(entrada.getValue() >= cantMinima) {
                Paciente p = getPacienteByDni(entrada.getKey());
                pacientesConEstudiosCant.add(p);
            }
        }

        return pacientesConEstudiosCant;
    }

    private Paciente getPacienteByDni(int dni) {
        for(Paciente p : paciente) {
            if(p.getDni() == dni) {
                return p;
            }
        }
        throw new SystemException("El Paciente con DNI:" + dni + "no esta registrado.");
    }

    private Map<Integer, Integer> pacientesEstudios(){
        Map<Integer, Integer> pacientesEstudios = new HashMap<>();
        for(Receta r : recetas){
            Integer pacienteDni = r.getPaciente().getDni;
            Integer cantEstudios = r.cantidadEstudios();
            if(pacientesEstudios.containsKey(pacienteDni)){
                pacientesEstudios.put(pacienteDni, 0);
            }
            Integer cantEstudiosPrevio = pacientesEstudios.get(pacienteDni);
            pacientesEstudios.put(pacienteDni, cantEstudiosPrevio + cantEstudios);
        }
        return pacientesEstudios;
    }
}
