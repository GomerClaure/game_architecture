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

    public boolean crearPuerta(String entornoOrigen, String entornoDestino, String nombreId) {
        return escenarioPrincipal.agregarPuerta(entornoOrigen,entornoDestino, nombreId);
        // return false;
    }

    public boolean agregarEntorno(String escenarioDestino, String entornoNuevo){
        Entorno escenario = almacenTemporal.get(entornoNuevo);
        boolean estaAgregado = escenarioPrincipal.agregarA(escenarioDestino, escenario);
        if(estaAgregado){almacenTemporal.remove(entornoNuevo);}
        return estaAgregado;
    }

    public Escenario getEscenarioPrincipal(){
        return escenarioPrincipal;
    }

    public boolean agregarEntorno(String entornoNuevo){
        Entorno escenario = almacenTemporal.get(entornoNuevo);
        boolean estaAgregado = escenarioPrincipal.agregarA(nombreEscenarioPrincipal, escenario);
        if(estaAgregado){almacenTemporal.remove(entornoNuevo);}
        return estaAgregado;
    }

    // public  Set<String> getEscenariosLibres(){
    //     return almacenTemporal.keySet();
    // } 

    // public  Set<String> getAmbientesLibres(){
    //     return almacenTemporal.keySet();
    // }
}
