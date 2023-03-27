package editor;
public class Puerta {
    private Entorno entornoOrigen;
    private Entorno entornoDestino;
    private String nombreId;
    private int puertaX; 
    private int puertaY;

    public Puerta(Entorno entornoOrigen,Entorno entornoDestino, String nombreId){
        this.entornoDestino = entornoDestino;
        this.entornoOrigen = entornoOrigen;
        this.nombreId = nombreId;
        
    }
    
    // public Puerta(Entorno entornoOrigen,Entorno entornoDestino, int posx, int posy){
    //     this.entornoDestino = entornoDestino;
    //     this.entornoOrigen = entornoOrigen;
    //     puertaX = posx;
    //     puertaY = posy;
    // }

    @Override
    public String toString(){
        return "    |Puerta: "+nombreId+" Con salida a: "+entornoDestino.nombreId;
    }

    public Entorno salirSinRetorno(){
        return entornoDestino;
    }

    public boolean estaEnLaPuerta(String nombrePuerta){
        return nombrePuerta == nombreId;
    }

    // public boolean estaEnLaPuerta(int posx, int posy){
    //     return posx == puertaX && posy == puertaY;
    // }

    // public int getPosX(){
    //     return puertaX;
    // }
    // public int getPosY(){
    //     return puertaY;
    // }
}
