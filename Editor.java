import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Editor {
    HashMap<String,Escenario> almacenTemporalEscenario;
    HashMap<String,Ambiente> almacenTemporalAmbiente;
    ArrayList<Escenario> escenarios;

    public boolean crearEscenario(String name) {
        almacenTemporalEscenario.put(name, new Escenario());
        return true;
    }

    public boolean crearAmbiente(String name) {
        almacenTemporalAmbiente.put(name, new Ambiente());
        return true;
    }

    public boolean crearPuerta(Ambiente ambiente1, Ambiente ambiente2) {
        
        return true;
    }

    public boolean agregarEscenario(String escenarioDestino, String escenario){
        return true;
    }

    public boolean agregarEscenario(String escenario){
        try {
            escenarios.add(almacenTemporalEscenario.get(escenario));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public  Set<String> getEscenariosLibres(){
        return almacenTemporalEscenario.keySet();
    } 
    public  Set<String> getAmbientesLibres(){
        return almacenTemporalEscenario.keySet();
    }
}
