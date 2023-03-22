import java.util.ArrayList;

public abstract class Entorno {
    String nombreId;
    
    // ArrayList<Entorno> destinos;
    public Entorno(String nombreId) {
        this.nombreId = nombreId;
        
    }

    
    protected boolean sonDelMismoTipo(ArrayList <Entorno> entornos){
        boolean sonDelMismoTipo = true;
        for (int i = 1; i < entornos.size(); i++) {
            if(entornos.get(i-1).getClass() != entornos.get(i).getClass()){
                sonDelMismoTipo = false;
            }
        }
        return sonDelMismoTipo;
        
    }

    public boolean agregarPuerta(Entorno entornoDestino,int posx, int posy){
        return false;
    }

    protected Entorno [] buscarEntornosEnVecinos(String entornoOrigen, String entornoDestino) {
        return new Entorno[2];
    }
    
    

    public Boolean agregarA(String espacioIdDestino, Entorno espacio){
        return false;
    }

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
