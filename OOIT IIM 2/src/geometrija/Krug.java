package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Krug extends PovrsinskiOblik implements Comparable{
	private Tacka centar;
	private int radius;


	public Krug(){

	}

	public Krug(Tacka centar, int radius){
		this.centar = centar;
		this.radius = radius;
	}

	public Krug(Tacka centar, int radius, Color boja){
		this.centar = centar;
		this.radius = radius;
		this.color = boja;
	}
	
	public Krug(Tacka centar, int radius, String boja, Color bojaUnutrasnjosti){
		this.centar = centar;
		this.radius = radius;
		this.boja = boja;
		this.setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}
	
	public int compareTo(Object o) {
		Krug drugi = (Krug)o;
		return this.radius - drugi.radius;
	}



	public void selektovan(Graphics g)	{
		new Linija(new Tacka(centar.getX(), centar.getY()-radius), new Tacka(centar.getX(), centar.getY() + radius)).selektovan(g);
		new Linija(new Tacka(centar.getX()-radius, centar.getY()), new Tacka(centar.getX()+radius, centar.getY())).selektovan(g);
	}
	
	public void popuni(Graphics g) {
		//g.setColor(pronadjiBoju(getBojaUnutrasnjosti()));
		g.setColor(getBojaUnutrasnjosti());
		g.fillOval(getCentar().getX()-radius+1, getCentar().getY() - radius+1, radius*2-2, 2*radius-2 );
		
	}


	public boolean sadrzi(int x, int y) {

		Tacka nova = new Tacka(x, y);


		if(nova.udaljenost(getCentar()) <= radius)
			return true;
		else
			return false;
	}

	public void crtajSe(Graphics g){
		//g.setColor(pronadjiBoju(getBoja()));
		g.setColor(getColor());
		g.drawOval(getCentar().getX()-radius, getCentar().getY() - radius, radius*2, 2*radius );
		//g.fillOval(getCentar().getX()-radius, getCentar().getY() - radius, radius*2, 2*radius );
		
		if(isSelektovan())
			selektovan(g);
		if(isPopunjen()){
			popuni(g);
		}
	}


	public boolean equals (Object obj){
		if (obj instanceof Object){
			Krug pomocni = (Krug) obj;
			if(this.centar.equals(pomocni.centar) && this.radius == pomocni.radius)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public String toString(){
		return "Krug: Centar = (" + getCentar().getX() + "," + getCentar().getY() +"), poluprecnik = " +  radius +", boja= " +this.boja;
	}


	public void pomeriNa(int x,int y){
		centar.pomeriNa(x, y);
	}

	public void pomeriZa(int x,int y){
		centar.pomeriZa(x, y);
	}

	public double povrsina(){
		return radius * radius * Math.PI;
	}

	public double obim(){
		return 2 * radius * Math.PI;
	}

	public Tacka getCentar() {
		return centar;
	}

	public int getRadius() {
		return radius;
	}

	public void setCentar(Tacka centar) {
		this.centar = centar;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String typeToString(){
		return "Krug";
	}
	


}
