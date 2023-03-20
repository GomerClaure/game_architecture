import java.util.HashMap;
import java.util.Set;

public class Editor {
    private Escenario escenarioPrincipal;
    private HashMap<String,Entorno> almacenTemporal;
    private String nombreEscenarioPrincipal;

    public Editor(){
        nombreEscenarioPrincipal = "escenarioPrincipal";
        escenarioPrincipal = new Escenario(nombreEscenarioPrincipal);
        almacenTemporal = new HashMap<>();
    }
    public boolean crearEscenario(String name) {
        try {
            almacenTemporal.put(name, new Escenario(name));
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        
        return true;
    }

    public boolean crearAmbiente(String name) {
        try {
            almacenTemporal.put(name, new Ambiente(name));
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    public boolean crearPuerta(String entornoOrigen, String entornoDestino) {
        return escenarioPrincipal.agregarPuerta(entornoOrigen,entornoDestino, 1, 2);
        // return false;
    }

    public boolean agregarEntorno(String escenarioDestino, String entornoOrigen){
        Entorno escenario = almacenTemporal.get(entornoOrigen);
        boolean estaAgregado = escenarioPrincipal.agregarA(escenarioDestino, escenario);
        if(estaAgregado){almacenTemporal.remove(entornoOrigen);}
        return estaAgregado;
    }

    public Escenario getEscenarioPrincipal(){
        return escenarioPrincipal;
    }

    public boolean agregarEntorno(String entornoOrigen){
        Entorno escenario = almacenTemporal.get(entornoOrigen);
        boolean estaAgregado = escenarioPrincipal.agregarA(nombreEscenarioPrincipal, escenario);
        if(estaAgregado){almacenTemporal.remove(entornoOrigen);}
        return estaAgregado;
    }

    public  Set<String> getEscenariosLibres(){
        return almacenTemporal.keySet();
    } 

    public  Set<String> getAmbientesLibres(){
        return almacenTemporal.keySet();
    }
}
