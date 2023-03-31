package editor;

import simulador.Personaje;

public abstract class Elemento {
    protected String nombreElemento;
    
    public abstract void interactuar(Personaje p);
    
}
