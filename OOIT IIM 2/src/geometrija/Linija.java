package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik implements Comparable{
	private Tacka pocetna;
	private Tacka krajnja;



	public Linija(){

	}


	public Linija(Tacka pocetna, Tacka krajnja){
		this.pocetna = pocetna;
		this.krajnja = krajnja;
	}

	public Linija(Tacka pocetna, Tacka krajnja, String boja){
		this.pocetna = pocetna;
		this.krajnja = krajnja;
		this.boja = boja;
	}
	
	public Linija(Tacka pocetna, Tacka krajnja, Color color){
		this.pocetna = pocetna;
		this.krajnja = krajnja;
		this.color = color;
	}

	public int compareTo(Object o) {
		Linija nova = (Linija) o;
		return (int) (this.duzina() - nova.duzina() );
	}
	
	public void selektovan(Graphics g){

		g.setColor(Color.BLUE);
		pocetna.selektovan(g);
		krajnja.selektovan(g);
		sredinaLinije().selektovan(g);

	}

	public void crtajSe(Graphics g){
		//g.setColor(pronadjiBoju(getBoja()));
		g.setColor(getColor());
		g.drawLine(pocetna.getX(), pocetna.getY(), krajnja.getX(), krajnja.getY());
		if(isSelektovan()){
			selektovan(g);
		}
	}

	public boolean equals (Object obj){
		if(obj instanceof Linija){
			Linija pomocna = (Linija) obj;
			if(this.pocetna.equals(pomocna.pocetna) && this.krajnja.equals(pomocna.krajnja))
				return true;
			else
				return false;
		}
		else 
			return false;
	}


	public String toString(){
		return "("+pocetna.getX()+","+pocetna.getY()+")-->("+krajnja.getX()+","+krajnja.getY()+")";
	}

	public Tacka sredinaLinije(){
		int sredinaX = ( getPocetna().getX() + getKrajnja().getX() ) / 2;
		int sredinaY = ( pocetna.getY() + krajnja.getY() ) / 2;
		return new Tacka(sredinaX, sredinaY);

	}

	public void pomeriZa(int zaX, int zaY){
		pocetna.pomeriZa(zaX, zaY);
		krajnja.pomeriZa(zaX, zaY);
	}

	public double duzina(){
		double duzina = pocetna.udaljenost(krajnja);
		return duzina;
	}

	public Tacka getPocetna() {
		return pocetna;
	}
	public Tacka getKrajnja() {
		return krajnja;
	}
	public void setPocetna(Tacka novaPocetna) {
		pocetna = novaPocetna;
	}
	public void setKrajnja(Tacka novaKrajnja) {
		krajnja = novaKrajnja;
	}
	/**
	 * 
	 * @param duzina --nova duzina linije
	 * krajnja tacka se pomera pod istim uglom
	 */
	public void promeniDuzinu(int duzina){
		int d=(int)duzina();
		int xKateta=getKrajnja().getX()-getPocetna().getX();
		int yKateta=getKrajnja().getY()-getPocetna().getY();
		int xNovo=(int)((xKateta*duzina)/d);
		int yNovo=(int)((yKateta*duzina)/d);
		getKrajnja().pomeriNa(getPocetna().getX()+xNovo, getPocetna().getY()+yNovo);
	}

	
	public void pomeriNa(int x, int y) {
		pocetna.pomeriNa(x, y);
		krajnja.setX(krajnja.getX()-(pocetna.getX()-x));
		krajnja.setY(krajnja.getY()-(pocetna.getY()-y));
		
	}


	@Override
	public boolean sadrzi(int x, int y) {
		boolean rez = false;
		if ((pocetna.udaljenost(new Tacka (x, y)) + krajnja.udaljenost(new Tacka(x, y))) <= (this.duzina() + 0.5))
			rez = true;
		return rez;
	}

	public String typeToString(){
		return "Linija";
	}
	
	





}
