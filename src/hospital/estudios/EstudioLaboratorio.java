package hospital.estudios;

public class EstudioLaboratorio extends Estudio {

    //atributos

    private int cantItems;

    //metodos

    public EstudioLaboratorio(int cantItems){
        super("nombre laboratorio", "Estudio de laboratorio");
        this.cantItems = cantItems;
    }

}
