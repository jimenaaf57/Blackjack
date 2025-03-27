import java.util.Scanner;

public class Juego {
	
	private Baraja baraja;
    private Jugador jugador;
    private Crupier crupier;
    private Scanner scanner;
    
    public Juego() {
    	baraja=new Baraja();
    	scanner = new Scanner(System.in);
    }
    
    public void jugar() {
    	System.out.println("¡Bienvenido al Blackjack!");
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        jugador = new Jugador(nombre);
        crupier = new Crupier();
        
        jugador.recibirCarta(baraja.repartirCarta());
        crupier.recibirCarta(baraja.repartirCarta());
        jugador.recibirCarta(baraja.repartirCarta());
        crupier.recibirCarta(baraja.repartirCarta());
        
        jugador.mostrarMano();
        System.out.println("Crupier muestra: " + crupier.getPuntuacion() + " (una carta oculta)");
        
        while (!jugador.estaPlantado() && jugador.getPuntuacion() < 21) {
            System.out.print("¿Quieres otra carta? (s/n): ");
            String decision = scanner.nextLine();
            if (decision.equalsIgnoreCase("s")) {
                jugador.recibirCarta(baraja.repartirCarta());
                jugador.mostrarMano();
            } else {
                jugador.plantarse();
            }
        }
        
        System.out.println("Turno del crupier...");
        while (crupier.pedirCarta()) {
            crupier.recibirCarta(baraja.repartirCarta());
        }
        crupier.mostrarMano();

        // Determinar ganador
        determinarGanador();
        
        
    }
    private void determinarGanador() {
        int puntosJugador = jugador.getPuntuacion();
        int puntosCrupier = crupier.getPuntuacion();

        if (puntosJugador > 21) {
            System.out.println("Te pasaste de 21. ¡Has perdido!");
        } else if (puntosCrupier > 21) {
            System.out.println("El crupier se pasó de 21. ¡Has ganado!");
        } else if (puntosJugador > puntosCrupier) {
            System.out.println("¡Ganaste con " + puntosJugador + " puntos!");
        } else if (puntosJugador < puntosCrupier) {
            System.out.println("El crupier gana con " + puntosCrupier + " puntos.");
        } else {
            System.out.println("Empate.");
        }
    }
    
	public static void main(String[] args) {
		Juego juego = new Juego();
	    	juego.jugar();
	    
	}

}
