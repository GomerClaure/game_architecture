public class Main {
    public static void main(String[] args) {
        Editor editor= new Editor();
        editor.crearEscenario("escenario1");
        editor.crearEscenario("escenario2");
        editor.crearEscenario("escenario3");
        editor.crearEscenario("escenario4");
        editor.crearAmbiente("691a");
        editor.crearAmbiente("691b");
        editor.crearAmbiente("691c");
        editor.crearAmbiente("descanzo");
        editor.crearAmbiente("patio");
        editor.crearAmbiente("pasillo");
        editor.crearAmbiente("ambiente1");
        editor.crearAmbiente("ambiente2");
        editor.crearAmbiente("ambiente3");
        System.out.println(editor.agregarEntorno("escenario1"));
        System.out.println(editor.agregarEntorno("escenario2"));
        System.out.println(editor.agregarEntorno("escenario1", "691a"));
        System.out.println(editor.agregarEntorno("escenario1", "691b"));
        System.out.println(editor.agregarEntorno("escenario1", "691c"));
        System.out.println(editor.agregarEntorno("escenario1", "descanzo"));
        System.out.println(editor.agregarEntorno("escenario1", "patio"));
        System.out.println(editor.agregarEntorno("escenario1", "pasillo"));
        System.out.println(editor.agregarEntorno("escenario2","escenario3"));

        System.out.println(editor.agregarEntorno("691a", "691b"));// no es posible agregar un ambiente dentro de otro
        System.out.println(editor.agregarEntorno("escenario3","ambiente1"));
        System.out.println(editor.agregarEntorno("escenario3","ambiente2"));
        System.out.println(editor.agregarEntorno("escenario1","ambiente3"));// no es posible agregar un ambiente y un escenario a la vez en un escenario
        System.out.println("AgregarPuertas:");
        System.out.println(editor.crearPuerta("691a", "pasillo","puerta1"));
        System.out.println(editor.crearPuerta("pasillo", "691b", "puerta2"));
        System.out.println(editor.crearPuerta("pasillo", "descanzo", "puerta3"));
        System.out.println(editor.crearPuerta("691b", "691c", "puerta4"));
        System.out.println(editor.crearPuerta("691c", "pasillo", "puerta5"));
        System.out.println(editor.crearPuerta("descanzo", "patio", "puerta6"));
        System.out.println(editor.crearPuerta("patio", "pasillo", "puerta7"));
        
        Escenario escenaP = editor.getEscenarioPrincipal(); 
        Emulador emulador = new Emulador( escenaP);
        System.out.println(emulador.getDatosAmbiente());
        System.out.println(emulador.moverA("puerta1"));
        System.out.println(emulador.getDatosAmbiente());
        System.out.println(emulador.moverA("puerta2"));
        System.out.println(emulador.getDatosAmbiente());
        System.out.println(emulador.moverA("puerta4"));
        System.out.println(emulador.getDatosAmbiente());
        System.out.println(emulador.moverA("puerta5"));
        System.out.println(emulador.getDatosAmbiente());
        System.out.println(emulador.moverA("puerta3"));
        System.out.println(emulador.getDatosAmbiente());
        System.out.println(emulador.moverA("puerta6"));
        System.out.println(emulador.getDatosAmbiente());
        System.out.println(emulador.moverA("puerta7"));

        System.out.println("TodoOK!!!");
    }
}
