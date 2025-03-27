
public class Crupier extends Jugador{

	public Crupier( ) {
		super("Croupier");
	}
	
	public boolean pedirCarta() {
		return getPuntuacion() < 17 ;
	}

}
