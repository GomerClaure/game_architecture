package editor;
import java.util.ArrayList;

public class Escenario extends Entorno {
    ArrayList <Entorno> entornos;
    // ArrayList <Escenario> escenarios;
    public Escenario(String nombreId) {
        super(nombreId);
        entornos = new ArrayList<>();
    }

    public boolean agregarPuerta(String entornoOrigen,String entornoDestino, String nombreId){
        Entorno [] entornosVecinos =  buscarEntornosEnVecinos(entornoOrigen,entornoDestino);
        if(entornosVecinos[0] != null && entornosVecinos[1] != null){
           return entornosVecinos[0].agregarPuerta(entornosVecinos[1], nombreId);
        }
        return false;
    }
    @Override
    public Boolean agregarA(String entornoDestino, Entorno entornoNuevo) {
        boolean seAgrego = false;
        if(entornoNuevo != null){
            if(nombreId == entornoDestino){
                entornos.add(entornoNuevo);
                if(!sonDelMismoTipo(entornos)){
                    entornos.remove(entornos.size()-1);
                }else{
                    seAgrego = true;
                }
            }else{
                Entorno escenario = buscarEntorno(entornoDestino);
                if(escenario != null){
                     seAgrego = escenario. agregarA(entornoDestino, entornoNuevo);
                }
            }
        }else{
            return false;
        }
        return seAgrego;
    }
    
    public Entorno buscarEntorno(String entornoId){
        Entorno entornoBuscado = null;
        entornoBuscado = entornoId == nombreId ? this: null;
        for (int i = 0; i < entornos.size() && entornoBuscado == null; i++) {
            entornoBuscado = entornos.get(i).buscarEntorno(entornoId);
            if( entornoBuscado != null){break;}
        }
        return entornoBuscado;
    }

    public Entorno getPrimerAmbiente(){
        Entorno ambiente = null;
        for (Entorno entorno : entornos) {
            ambiente = entorno.getPrimerAmbiente();
            if (ambiente!=null) {
                break;
            }
            if (entorno instanceof Ambiente) {
                ambiente = entorno;
                break;
            }
        }
        return ambiente;
    }

    protected Entorno [] buscarEntornosEnVecinos(String entornoOrigen, String entornoDestino){
        Entorno [] entornosVecinos = new Entorno[2];
        for (int i = 0; i < entornos.size(); i++) {
            for (int e = 0; e < entornos.size(); e++) {
                if( entornoOrigen == entornos.get(e).nombreId){
                    entornosVecinos[0] = entornos.get(e);
                }
                if( entornoDestino == entornos.get(e).nombreId){
                    entornosVecinos[1] = entornos.get(e);
                }
            }
            if(entornosVecinos[0] == null && entornosVecinos[1] == null){
                entornosVecinos = entornos.get(i).buscarEntornosEnVecinos(entornoOrigen, entornoDestino);
            }else{
                if(entornosVecinos[0] == null || entornosVecinos[1] == null){
                    entornosVecinos = new Entorno[2];
                }else{
                    break; 
                }
                
            }
        }
        return entornosVecinos;
    }

    @Override
    public String getName(){
        return "Escenario: "+nombreId;
    }


}