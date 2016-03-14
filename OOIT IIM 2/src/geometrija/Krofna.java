package geometrija;

import java.awt.Color;

public class Krofna extends Krug {
	private Krug unutrasnji;

	public Krofna(Tacka centarKrofne, int radiusSpoljasnji, int radiusUnutrasnji){
		super(centarKrofne, radiusSpoljasnji);
		unutrasnji = new Krug(centarKrofne, radiusUnutrasnji);
	}

	public Krofna(int x, int y, int radiusSpoljasnji, int radiusUnutrasnji){
		super(new Tacka(x, y), radiusSpoljasnji);
		unutrasnji=new Krug(super.getCentar(), radiusUnutrasnji);
	}
	public Krofna (Tacka centarKrofne, int radiusSpoljasnji, int radiusUnutrasnji, Color boja){
		super(centarKrofne, radiusSpoljasnji, boja);
		unutrasnji=new Krug(centarKrofne, radiusSpoljasnji, Color.white);
	}

	public Krofna(int x, int y, int radiusSpoljasnji, int radiusUnutrasnji, Color boja){
		super(new Tacka(x, y), radiusSpoljasnji, boja);
		unutrasnji= new Krug(super.getCentar(), radiusUnutrasnji, Color.white);
	}

	public void pomeriNa(int x, int y){
		super.getCentar().pomeriNa(x, y);
	}

	public void pomeriZa(int x, int y){
		super.getCentar().pomeriZa(x, y);
	}
	public double obim(){
		double obim = super.obim()+unutrasnji.obim();
		return obim;
	}

	public double povrsina(){
		double povrsina = super.povrsina() - unutrasnji.povrsina();
		return povrsina;
	}
	public String toString(){
		String s = "Centar: " + unutrasnji.getCentar() + ", Spoljasnji poluprecnik: " +  super.getRadius() +
				", unutrasnji poluprecnik: " + this.unutrasnji.getRadius() ;
		return s;
	}
	public boolean equals (Object obj){
		if(obj instanceof Krofna){
			Krofna pomocna = (Krofna) obj;
			if(this.unutrasnji.equals(pomocna.unutrasnji) && super.getRadius() == pomocna.getRadius())
				return true;
			else
				return false;
		}
		else
			return false;
	}


	public Krug getUnutrasnji() {
		return unutrasnji;
	}

	public void setUnutrasnji(Krug unutrasnji) {
		this.unutrasnji = unutrasnji;
	}


}
