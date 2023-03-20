import java.util.ArrayList;

public class Escenario extends Entorno {
    ArrayList <Entorno> entornos;
    // ArrayList <Escenario> escenarios;
    public Escenario(String nombreId) {
        super(nombreId);
        entornos = new ArrayList<>();
    }
    public boolean agregarPuerta(String entornoOrigen,String entornoDestino){
        Entorno [] entornosVecinos =  buscarEntornosEnVecinos(entornoOrigen,entornoDestino);
        if(entornosVecinos[0] != null && entornosVecinos[1] != null){
           return entornosVecinos[0].agregarPuerta(entornosVecinos[1]);
        }
        return false;
    }
    @Override
    public Boolean agregarA(String entornoId, Entorno entornoDestino) {
        boolean seAgrego = false;
        if(entornoDestino != null){
            if(nombreId == entornoId){
                entornos.add(entornoDestino);
                if(!sonDelMismoTipo(entornos)){
                    entornos.remove(entornos.size()-1);
                }
                seAgrego = true;
            }else{
                Entorno escenario = buscarEntorno(entornoId);
                if(escenario != null){
                     seAgrego = escenario. agregarA(entornoId, entornoDestino);
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
    public Entorno [] buscarEntornosEnVecinos(String entornoOrigen, String entornoDestino){
        Entorno entornoBuscadoOrigen = null;
        Entorno entornoBuscadoDestino = null;
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

}