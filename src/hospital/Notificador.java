package hospital;

import hospital.estudios.Estudio;
import hospital.usuarios.Paciente;
import hospital.usuarios.Profesional;
import hospital.usuarios.Usuario;

public class Notificador {
    
    public static void notificar(Paciente paciente, Profesional profesional, Estudio estudio) {
        notificarA("paciente", paciente, estudio);
        notificarA("profesional", profesional, estudio);
    }

    private static void notificarA(String notificado, Usuario usuario, Estudio estudio){
        System.out.println("Notificando a" + notificado + usuario + " sobre " + estudio);
    }

}
