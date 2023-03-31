package simulador;

import editor.Entorno;

public class Personaje {
    // private Entorno ambiente;

    public Entorno mover(String puertaId, Entorno ambiente) {
        Entorno ambienteDestino = ambiente.salirPuerta(puertaId);
      return ambienteDestino;
    }

}
