package hospital.estudios;

public class EstudioLaboratorio extends Estudio {

    //atributos

    private int cantItems;

    //Constructor

    public EstudioLaboratorio(int cantItems){
        super("nombre laboratorio", "Estudio de laboratorio", Estado.PENDIENTE);
        this.cantItems = cantItems;
    }

}
