import java.util.ArrayList;

public abstract class Entorno {
    String nombreId;
    ArrayList<Puerta> puertas;
    // ArrayList<Entorno> destinos;
    public Entorno(String nombreId) {
        this.nombreId = nombreId;
        puertas = new ArrayList<>();
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
    protected Entorno [] buscarEntornosEnVecinos(String entornoOrigen, String entornoDestino) {
        return new Entorno[2];
    }
    
    public Entorno salirPuerta(int posx, int posy){
        return puertas.get(0).salirSinRetorno();
    }

    public Boolean agregarA(String espacioIdDestino, Entorno espacio){
        return false;
    }

    public Entorno buscarEntorno(String espacioId){
        return espacioId == nombreId ? this: null;
    }

    public boolean agregarPuerta(Entorno entornoDestino,int posx, int posy){
        if (entornoDestino != null) {
            puertas.add(new Puerta(this, entornoDestino, posx, posy));
            return true;
        }
        return false;
    }
}
