public class Puerta {
    private Entorno entornoOrigen;
    private Entorno entornoDestino;
    public Puerta(Entorno entornoOrigen,Entorno entornoDestino){
        this.entornoDestino = entornoDestino;
        this.entornoOrigen = entornoOrigen;
    }

    public Entorno cambiarConRetorno(){
        if(true){
        // if(entornoDestino.agregarPuertaA(entornoDestino, entornoOrigen)){
            return entornoDestino;
        }else{
            System.out.println("Error al cambiar de puerta");
            return null;
        }
        
    }

    public Entorno cambiarSinRetorno(){
        return entornoDestino;
    }

    public Object getPosicion(){
        return null;
    }
}
