package editor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Editor {
    private Escenario escenarioPrincipal;
    private Map<String,Entorno> almacenTemporal;
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

    public Entorno getEntorno(){//metodo del inge
        crearEscenario("plantaBaja");
        crearEscenario("primer piso");
        // crearEscenario("escenario2");
        // crearEscenario("escenario3");
        // crearEscenario("escenario4");
        crearAmbiente("690a");
        crearAmbiente("690b");
        crearAmbiente("690c");
        crearAmbiente("690d");
        crearAmbiente("691a");
        crearAmbiente("691b");
        crearAmbiente("691c");
        crearAmbiente("691d");
        // crearAmbiente("descanzo");
        // crearAmbiente("patio");
        crearAmbiente("pasillo");
        // crearAmbiente("ambiente1");
        // crearAmbiente("ambiente2");
        // crearAmbiente("ambiente3");
        // agregarEntorno("escenario2"));
        agregarEntorno("plantaBaja");
        agregarEntorno("plantaBaja", "pasillo");
        agregarEntorno("plantaBaja", "690a");
        agregarEntorno("plantaBaja", "690b");
        agregarEntorno("plantaBaja", "690c");
        agregarEntorno("plantaBaja", "690d");
        agregarEntorno("escenario2","escenario3");

        crearPuerta("690a", "pasillo","p1");
        crearPuerta("690b", "pasillo","p2");
        crearPuerta("690c", "pasillo","p3");
        crearPuerta("690d", "pasillo","p4");
        crearPuerta( "pasillo","690a","p5");
        crearPuerta( "pasillo","690b","p6");
        crearPuerta( "pasillo","690c","p7");
        crearPuerta( "pasillo","690d","p8");
        // crearPuerta("690e", "pasillo","puerta1");
        return escenarioPrincipal;
    }

    // public  Set<String> getEscenariosLibres(){
    //     return almacenTemporal.keySet();
    // } 

    // public  Set<String> getAmbientesLibres(){
    //     return almacenTemporal.keySet();
    // }
}
