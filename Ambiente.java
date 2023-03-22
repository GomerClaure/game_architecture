import java.util.ArrayList;

public class Ambiente extends Entorno  {
    ArrayList<Puerta> puertas;
    public Ambiente(String nombreId) {
        super(nombreId);
        puertas = new ArrayList<>();
    }

    public Entorno salirPuerta(String nombreId){
        for (Puerta puerta : puertas) {
            if (puerta.estaEnLaPuerta(nombreId)) {
                return puerta.salirSinRetorno();
            }
        }
        return null;
    }
    
    public boolean agregarPuerta(Entorno entornoDestino, String nombreId){
        if (entornoDestino != null) {
            puertas.add(new Puerta(this, entornoDestino, nombreId));
            return true;
        }
        return false;
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

}
