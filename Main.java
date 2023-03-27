import editor.Editor;
import editor.Entorno;
import simulador.Simulador;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Entorno entorno = editor.getEntorno();
        Simulador simulador = new Simulador( entorno);
        simulador.run();
        
        // Escenario escenaP = editor.getEscenarioPrincipal(); 
        // Simulador simulador = new Simulador( escenaP);
        // System.out.println(simulador.getDatosAmbiente());
        // System.out.println(simulador.moverA("puerta1"));
        // System.out.println(simulador.getDatosAmbiente());
        // System.out.println(simulador.moverA("puerta2"));
        // System.out.println(simulador.getDatosAmbiente());
        // System.out.println(simulador.moverA("puerta4"));
        // System.out.println(simulador.getDatosAmbiente());
        // System.out.println(simulador.moverA("puerta5"));
        // System.out.println(simulador.getDatosAmbiente());
        // System.out.println(simulador.moverA("puerta3"));
        // System.out.println(simulador.getDatosAmbiente());
        // System.out.println(simulador.moverA("puerta6"));
        // System.out.println(simulador.getDatosAmbiente());
        // System.out.println(simulador.moverA("puerta7"));
        // System.out.println(simulador.getDatosAmbiente());
        // System.out.println(simulador.moverA("puerta1"));
        // System.out.println(simulador.getDatosAmbiente());

        // System.out.println("TodoOK!!!");
    }
}
