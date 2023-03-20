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
    public Entorno [] buscarEntornosEnVecinos(String entornoOrigen, String entornoDestino) {
        return new Entorno[2];
    }
    
    // public Entorno irA(String ambienteDestino){
    //     puertas.get(0).cambiarConRetorno();
    // }

    public Boolean agregarA(String espacioIdDestino, Entorno espacio){
        return false;
    }

    public Entorno buscarEntorno(String espacioId){
        return espacioId == nombreId ? this: null;
    }

    public boolean agregarPuerta(Entorno entornoDestino){
        if (entornoDestino != null) {
            puertas.add(new Puerta(this, entornoDestino));
            return true;
        }
        return false;
    }
}
