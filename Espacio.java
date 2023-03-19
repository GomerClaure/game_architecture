import java.util.ArrayList;

public abstract class Espacio {
    ArrayList <Ambiente> ambientes;
    ArrayList <Escenario> escenarios;
    ArrayList <Puerta> puertas;
    public abstract Espacio crear();
    public abstract Puerta agregarPuertaEntre(Escenario espacio1, Espacio espacio2);
    public abstract Espacio agregarA(String espacioId, Espacio espacioDestino);

}
