import java.util.ArrayList;

public class Ambiente extends Entorno  {
    ArrayList<Puerta> puertas;
    public Ambiente(String nombreId) {
        super(nombreId);
        puertas = new ArrayList<>();
    }

    public Entorno salirPuerta(int posx, int posy){
        return puertas.get(0).salirSinRetorno();
    }
    
    public boolean agregarPuerta(Entorno entornoDestino,int posx, int posy){
        if (entornoDestino != null) {
            puertas.add(new Puerta(this, entornoDestino, posx, posy));
            return true;
        }
        return false;
    }

}
