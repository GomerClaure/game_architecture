public class Main {
    public static void main(String[] args) {
        Editor editor= new Editor();
        editor.crearEscenario("escenario1");
        editor.crearEscenario("escenario2");
        editor.crearEscenario("escenario3");
        editor.crearAmbiente("ambiente1");
        editor.crearAmbiente("ambiente2");
        editor.crearAmbiente("ambiente3");
        editor.crearAmbiente("ambiente4");
        editor.crearAmbiente("ambiente5");
        editor.crearAmbiente("ambiente6");
        System.out.println(editor.agregarEntorno("escenario1"));
        System.out.println(editor.agregarEntorno("escenario2"));
        System.out.println(editor.agregarEntorno("escenario1","escenario3"));
        System.out.println(editor.agregarEntorno("escenario2", "ambiente1"));
        System.out.println(editor.agregarEntorno("escenario2", "ambiente2"));
        System.out.println(editor.agregarEntorno("ambiente3", "ambiente4"));
        System.out.println(editor.agregarEntorno("escenario3","ambiente3"));
        
        System.out.println("TodoOK!!!");
    }
}
