public class Puerta {
    private Entorno entornoOrigen;
    private Entorno entornoDestino;
    private int puertaX; 
    private int puertaY;
    public Puerta(Entorno entornoOrigen,Entorno entornoDestino, int posx, int posy){
        this.entornoDestino = entornoDestino;
        this.entornoOrigen = entornoOrigen;
        puertaX = posx;
        puertaY = posy;
    }

    // public Entorno salirConRetorno(){
    //     // if(true){
    //     if(entornoDestino.agregarPuerta(entornoOrigen)){
    //         return entornoDestino;
    //     }else{
    //         System.out.println("Error al cambiar de puerta");
    //         return null;
    //     }
        
    // }

    public Entorno salirSinRetorno(){
        return entornoDestino;
    }

    public boolean estaEnLaPuerta(int posx, int posy){
        return posx == puertaX && posy == puertaY;
    }

    public int getPosX(){
        return puertaX;
    }
    public int getPosY(){
        return puertaY;
    }
}
