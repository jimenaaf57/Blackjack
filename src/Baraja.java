import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
	private ArrayList<Carta> cartas;
	
	public Baraja() {
		String[] palos = {"Corazones", "Diamantes", "Picas", "Treboles"};
		String[] valores = {"2","3","4","5","6","7","8","9","10","Q","J","K","A"};
		
		cartas = new ArrayList<>();
		for(String palo : palos) {
			for(String valor : valores) {
				cartas.add(new Carta(palo, valor));
			}
		}
		barajar();
	}
	public void barajar() {
        Collections.shuffle(cartas);
    }
	
	public Carta repartirCarta() {
		if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
	}
	
	
}
