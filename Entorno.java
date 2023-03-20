
public abstract class Entorno {
    String nombreId;
    public Entorno(String nombreId) {
        this.nombreId = nombreId;
    }

    // public abstract Espacio crear();

    public abstract Puerta agregarPuertaEntre(String espacioId1, String espacioId2);

    public Boolean agregarA(String espacioIdDestino, Entorno espacio){
        return false;
    }

    public Entorno buscarAmbiente(String espacioId){
        return espacioId == nombreId ? this: null;
    }

    public Entorno buscarEscenario(String espacioId){
        return null;
    }

}
