package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik{
	protected Color bojaUnutrasnjosti = Color.green;
	
	public abstract void popuni(Graphics g);
	private boolean popunjen;
	public abstract boolean sadrzi(int x, int y);
	public abstract double obim();
	public abstract double povrsina();

	public Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	
	public boolean isPopunjen(){
		return popunjen;
	}
	
	public void setPopunjen(boolean popunjen){
		this.popunjen=popunjen;
	}
	
}
