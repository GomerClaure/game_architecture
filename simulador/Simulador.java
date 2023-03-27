package simulador;
import editor.Entorno;
import editor.Escenario;

public class Simulador {
   Entorno escenarioEmulado;
   Entorno ambienteActualEmulado;
   public Simulador(Entorno esenarioPrincipal){
      escenarioEmulado = esenarioPrincipal;
      ubicarEnAmbiente();
   }

   private void ubicarEnAmbiente(){
      ambienteActualEmulado = escenarioEmulado.getPrimerAmbiente();
   }

   public boolean moverA(String puertaId){
      Entorno ambienteDestino = ambienteActualEmulado.salirPuerta(puertaId);
      if (ambienteDestino != null) {
         ambienteActualEmulado = ambienteDestino;
      }
      return ambienteDestino != null;
   }

   public String getDatosAmbiente(){
      return"Estas en el Ambiente: "+ ambienteActualEmulado.getName()+"\n"+ambienteActualEmulado.getPuertas();
   }

   public void run(){
      System.out.println("Corriendo el simulador");
   }

}
