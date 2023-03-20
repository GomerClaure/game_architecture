import java.util.ArrayList;

public class Escenario extends Entorno {
    ArrayList <Entorno> espacios;
    // ArrayList <Escenario> escenarios;
    public Escenario(String nombreId) {
        super(nombreId);
        espacios = new ArrayList<>();
    }

    @Override
    public Boolean agregarA(String espacioId, Entorno espacioDestino) {
        boolean seAgrego = false;
        if(espacioDestino != null){
            if(nombreId == espacioId){
                espacios.add(espacioDestino);
                seAgrego = true;
            }else{
                Entorno escenario = buscarEscenario(espacioId);
                if(escenario != null){
                     seAgrego = escenario. agregarA(espacioId, espacioDestino);
                }
            }
        }else{
            return false;
        }
        return seAgrego;
    }
    
    @Override
    public Puerta agregarPuertaEntre(String espacioId1, String espacioId2) {
        return null;
    }

    @Override
    public Entorno buscarAmbiente(String espacioId){
        Entorno ambienteBuscado = null;
        for (int i = 0; i < espacios.size(); i++) {
            ambienteBuscado = espacios.get(i).buscarAmbiente(espacioId);
            if( ambienteBuscado != null){break;}
        }
        return ambienteBuscado;
    }

    @Override
    public Entorno buscarEscenario(String espacioId){
        Entorno escenarioBuscado = null;
        if (nombreId == espacioId) {
            escenarioBuscado = this;
        }else{
            for (int i = 0; i < espacios.size(); i++) {
                escenarioBuscado = espacios.get(i).buscarEscenario(espacioId);
                if( escenarioBuscado != null){break;}
            }
        }
        return escenarioBuscado;
    }

}