package editor;
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

    public Entorno getEntorno(){//metodo del inge
        crearEscenario("escenario1");
        crearEscenario("escenario2");
        crearEscenario("escenario3");
        crearEscenario("escenario4");
        crearAmbiente("691a");
        crearAmbiente("691b");
        crearAmbiente("691c");
        crearAmbiente("descanzo");
        crearAmbiente("patio");
        crearAmbiente("pasillo");
        crearAmbiente("ambiente1");
        crearAmbiente("ambiente2");
        crearAmbiente("ambiente3");
        System.out.println(agregarEntorno("escenario1"));
        System.out.println(agregarEntorno("escenario2"));
        System.out.println(agregarEntorno("escenario1", "691a"));
        System.out.println(agregarEntorno("escenario1", "691b"));
        System.out.println(agregarEntorno("escenario1", "691c"));
        System.out.println(agregarEntorno("escenario1", "descanzo"));
        System.out.println(agregarEntorno("escenario1", "patio"));
        System.out.println(agregarEntorno("escenario1", "pasillo"));
        System.out.println(agregarEntorno("escenario2","escenario3"));

        System.out.println(agregarEntorno("691a", "691b"));// no es posible agregar un ambiente dentro de otro
        System.out.println(agregarEntorno("escenario3","ambiente1"));
        System.out.println(agregarEntorno("escenario3","ambiente2"));
        System.out.println(agregarEntorno("escenario1","ambiente3"));// no es posible agregar un ambiente y un escenario a la vez en un escenario
        System.out.println("AgregarPuertas:");
        System.out.println(crearPuerta("691a", "pasillo","puerta1"));
        System.out.println(crearPuerta("pasillo", "691b", "puerta2"));
        System.out.println(crearPuerta("pasillo", "descanzo", "puerta3"));
        System.out.println(crearPuerta("691b", "691c", "puerta4"));
        System.out.println(crearPuerta("691c", "pasillo", "puerta5"));
        System.out.println(crearPuerta("descanzo", "patio", "puerta6"));
        System.out.println(crearPuerta("patio", "pasillo", "puerta7"));
        return escenarioPrincipal;
    }

    // public  Set<String> getEscenariosLibres(){
    //     return almacenTemporal.keySet();
    // } 

    // public  Set<String> getAmbientesLibres(){
    //     return almacenTemporal.keySet();
    // }
}
