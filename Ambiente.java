import java.util.ArrayList;

public class Ambiente extends Entorno  {
    
    public Ambiente(String nombreId) {
        super(nombreId);
    }

    public Entorno salirPuerta(String nombreId){
        for (Puerta puerta : puertas) {
            if (puerta.estaEnLaPuerta(nombreId)) {
                return puerta.salirSinRetorno();
            }
        }
        return null;
    }
    
    

    @Override
    public String getName(){
        return "Ambiente: "+nombreId;
    }

    @Override
    public String getPuertas(){
        String todasLasPuertas = "";
        for (Puerta puerta : puertas) {
            todasLasPuertas += puerta.toString();
        }
        return todasLasPuertas;
    }

    @Override
    public Boolean agregarA(String espacioIdDestino, Entorno espacio) {
        return false;
    }

}
