import java.util.ArrayList;

public class Jugador {
	private String nombre;
	private ArrayList<Carta> mano;
	private int puntuacion;
	private boolean plantar;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.mano = mano;
		this.puntuacion = 0;
		this.plantar = false;
	}
	
	public void recibirCarta(Carta carta) {
		mano.add(carta);
		calcularPuntuacion();
	}
	
	public void calcularPuntuacion() {
		int total = 0;
		int ases = 0;
		
		for(Carta carta : mano) {
			total+=carta.obtenerValor();
			if(carta.getValor().equals("A")) {
				ases++;
			}
		}
		
		while(total >21 && ases == 0) {
			total -=10;
			ases --;
		}
		
		this.puntuacion=total;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public boolean estaPlantado() {
		return plantar;
	}
	
	public void plantarse() {
        this.plantar = true;
    }

    public void mostrarMano() {
        System.out.println(nombre + " tiene: " + mano + " (Puntos: " + puntuacion + ")");
    }
	
	
}
