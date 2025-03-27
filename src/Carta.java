
public class Carta {
	private String palo;
	private String valor;
	
	public Carta(String palo, String valor) {
		this.palo = palo;
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
	
	public String getPalo() {
		return palo;
	}
	
	public int obtenerValor() {
		if(valor.equals("A")) {
			return 11;
		}
		if(valor.equals("Q") || valor.equals("J") || valor.equals("K")) {
			return 10;
		}
		return Integer.parseInt(valor);
	}
	
	@Override
	public String toString() {
		return valor + "de" + palo;
	}
}
