package simulador;
import java.util.Scanner;

import editor.Entorno;
import editor.Escenario;

public class Simulador {
   Entorno escenarioEmulado;
   Entorno ambienteActualEmulado;
   Personaje personaje;
   public Simulador(Entorno esenarioPrincipal){
      escenarioEmulado = esenarioPrincipal;
      ubicarEnAmbiente();
      personaje = new Personaje();
   }

   private void ubicarEnAmbiente(){
      ambienteActualEmulado = escenarioEmulado.getPrimerAmbiente();
   }

   public boolean mover(String puertaId){
      Entorno ambienteDestino = personaje.mover(puertaId, ambienteActualEmulado);
      if (ambienteDestino != null) {
         ambienteActualEmulado = ambienteDestino;
      }
      return ambienteDestino != null;
   }

   public String getDatosAmbiente(){
      return"Estas en el "+ ambienteActualEmulado.getName()+"\n"+ambienteActualEmulado.getPuertas()+"\n";
   }

   public void run(){
      Scanner scanner = new Scanner(System.in);
      String entrada = "1";
      System.out.println(getDatosAmbiente());
      while (!entrada.equals("0")) {
         System.out.print("Ingrese el nombre de la puerta por la que quiere salir: ");
         entrada = scanner.next();
         mover(entrada);
         System.out.println("\n"+"\n"+"\n"+getDatosAmbiente());
      }
      System.out.println("Corriendo el simulador");
   }

}
