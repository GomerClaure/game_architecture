package editor;
import java.util.ArrayList;
import java.util.List;

public abstract class Entorno {
    String nombreId;
    List<Puerta> puertas;
    
    public Entorno() {
        // this.nombreId = nombreId;
        puertas = new ArrayList<>();
        
    }

    public boolean agregarPuerta(Entorno entornoDestino, String nombreId){
        if (entornoDestino != null) {
            puertas.add(new Puerta(this, entornoDestino, nombreId));
            return true;
        }
        return false;
    }
    
    protected boolean sonDelMismoTipo(List <Entorno> entornos){
        boolean sonDelMismoTipo = true;
        for (int i = 1; i < entornos.size(); i++) {
            if(entornos.get(i-1).getClass() != entornos.get(i).getClass()){
                sonDelMismoTipo = false;
            }
        }
        return sonDelMismoTipo;
        
    }

    protected Entorno [] buscarEntornosEnVecinos(String entornoOrigen, String entornoDestino) {
        return new Entorno[2];
    }
    
    public abstract Boolean agregarA(String espacioIdDestino, Entorno espacio);

    public Entorno buscarEntorno(String espacioId){
        return espacioId == nombreId ? this: null;
    }

    public abstract String getName();

    public Entorno salirPuerta(String nombreId){
        return null;
    }

    public String getPuertas(){
        return "";
    }

    public Entorno getPrimerAmbiente(){
        return this;
    }

    
}
