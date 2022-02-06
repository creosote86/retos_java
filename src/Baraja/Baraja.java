package Baraja;


/**
 * @author Lucas Morandeira      
 */
public class Baraja {
    
    private static final int DEFAULT_NAIPES = 40;
    private static final int NAIPES = 48;
    
    private int extraccionesDeNaipes;
    private int numeroDeNaipes;
    
    private String[] numero48 = {"UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE", "SOTA", "CABALLO", "REY"};
    private String[] numero40 = {"UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "SOTA", "CABALLO", "REY"};
    private String[] palo = {"OROS", "ESPADAS", "COPAS", "BASTOS"};
    
    public Baraja(int numeroDeNaipes) throws IllegalArgumentException{
        this.extraccionesDeNaipes = 0;
        
        if (numeroDeNaipes != DEFAULT_NAIPES && numeroDeNaipes != NAIPES){
            throw new IllegalArgumentException ("El número de Naipes es incorrecto");
        }else {
            this.numeroDeNaipes = numeroDeNaipes;   
        }
    }
    
    public Baraja() {
        this(DEFAULT_NAIPES);
    }

    public int getNumeroDeNaipes() {
        return numeroDeNaipes;
    }

    public int getExtraccionesDeNaipes() {
        return extraccionesDeNaipes;
    }
    
    public String extraerNaipeRandom(){
        
        this.extraccionesDeNaipes ++;
        int valorNumero;
        int valorPalo;

        if (this.numeroDeNaipes == 48){
            valorNumero = (int) (Math.random()* numero48.length);
            valorPalo = (int) (Math.random()* palo.length);
            
            return String.format("%s de %s ", numero48[valorNumero], palo[valorPalo]);
        
        }else {
            valorNumero = (int) (Math.random()* numero40.length);
            valorPalo = (int) (Math.random()* palo.length);
            
            return String.format("%s de %s ", numero40[valorNumero], palo[valorPalo]);
        }       
    }
    
    public String toString(){
        return String.format("Baraja de %d naipes. Extracciones %d%n", this.numeroDeNaipes, this.extraccionesDeNaipes);
    }
    
    
}
