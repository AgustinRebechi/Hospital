package hospital.estudios;

public class EstudioRX extends Estudio {

    private String zona;

    public EstudioRX(String zona){
        super("RX", "Estudio de imagex RX de " + zona, Estado.PENDIENTE);
        this.zona = zona;
    }
}
