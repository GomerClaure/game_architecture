public class Emulador {
    Escenario escenarioEmulado;
    Entorno ambienteActualEmulado;
     public Emulador(Escenario esenarioPrincipal){
        escenarioEmulado = esenarioPrincipal;
        ubicarEnAmbiente();
     }

     private void ubicarEnAmbiente(){
        ambienteActualEmulado = escenarioEmulado.getPrimerAmbiente();
     }

     public boolean moverA(String ambienteId){
        Entorno ambienteDestino = ambienteActualEmulado.salirPuerta(ambienteId);
        if (ambienteDestino != null) {
            ambienteActualEmulado = ambienteDestino;
        }
        return ambienteDestino != null;
     }

     public String getDatosAmbiente(){
        return"Nombre de Ambiente: "+ ambienteActualEmulado.nombreId+"\n"+ambienteActualEmulado.getPuertas();
     }

}
