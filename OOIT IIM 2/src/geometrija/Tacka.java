package geometrija;

import java.awt.Color;
import java.awt.Graphics;
/**
@author Teodora Lolic
@version 1.0

Klasa Tacka omogucava kreiranje tacaka.
*/
public class Tacka extends Oblik implements Comparable{
	private int x;
	private int y;


	public Tacka(){
		this.boja = "";
	}

	public Tacka(int x, int y){
		this.x = x;
		this.y = y;
	}

	public Tacka(int x, int y, Color boja){
		this.x = x;
		this.y = y;
		this.color = boja;
	}

	public int compareTo(Object o) {
		Tacka nula = new Tacka(0,0);
		Tacka nova  = (Tacka) o;
		return (int) (this.udaljenost(nula) - nova.udaljenost(nula));
	}

	public void selektovan(Graphics g){
		g.setColor(pronadjiBoju("plava"));
		g.drawRect(x-3, y-3, 6, 6);
	}
	/**
	 Ova metoda omogucuje iscrtavanje objekata
	 @return ne vraca nista
	 * */
	public void crtajSe(Graphics g){
		//g.setColor(pronadjiBoju(this.getBoja()));
		g.setColor(getColor());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);		

		if(isSelektovan()){
			selektovan(g);
		}
	}

	public boolean equals(Object obj){
		if (obj instanceof Tacka){
			Tacka pomocna = (Tacka) obj;
			if (this.x == pomocna.x && this.y == pomocna.y )
				return true;
			else
				return false;

		}
		else
			return false;
	}

	public String toString(){
		return "("+getX()+","+getY()+")";

	}

	public void pomeriNa(int naX, int naY){
		this.x = naX;
		this.y = naY;

	}

	public void pomeriZa(int zaX,int zaY){
		x = x + zaX;
		y = y + zaY;
	}

	public double udaljenost(Tacka t){
		int dx = x - t.getX();
		int dy = y - t.y;
		double d = Math.sqrt(dx*dx+dy*dy);
		return d;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public void setX(int novoX){
		x = novoX;
	}

	public void setY(int novoY){
		y = novoY;
	}

	@Override
	public boolean sadrzi(int x, int y) {
		if(x >= this.x-3 && x <= this.x+3 && y >= this.y-3 && y <= this.y+3 )
			return true;
		else
			return false;
	}

	public String typeToString(){
		return "Tacka";
	}




}
