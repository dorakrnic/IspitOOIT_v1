package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Kvadrat {
	private int visina;


	public Pravougaonik(){

	}

	public Pravougaonik(Tacka goreLevo, int sirina, int visina){
		super(goreLevo, sirina);
		this.visina = visina;

	}
	
	public void selektovan(Graphics g){
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+getStranica(), getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+visina)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+getStranica(), getGoreLevo().getY()), dijagonala().getKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+visina), dijagonala().getKrajnja()).selektovan(g);
	}

	public Pravougaonik(Tacka goreLevo, int sirina, int visina, Color boja){
		this(goreLevo, sirina, visina);
		//setCol(boja);
		this.color=boja;
	}

	public int compareTo(Object o) {
		Pravougaonik novi = (Pravougaonik) o;
		return (int)(this.povrsina() - novi.povrsina());
	}
	
	public void popuni(Graphics g) {
		//g.setColor(pronadjiBoju(getBojaUnutrasnjosti()));
		g.setColor(getBojaUnutrasnjosti());
		g.fillRect(getGoreLevo().getX()+1, getGoreLevo().getY()+1, getStranica()-1, visina-1);
		
	}
	
	public void crtajSe (Graphics g){
		//g.setColor(pronadjiBoju(this.getBoja()));
		g.setColor(getColor());
		g.drawRect(getGoreLevo().getX(), getGoreLevo().getY(), getStranica(), visina);
		
		if(isSelektovan())
			selektovan(g);
		if(isPopunjen()){
			popuni(g);
		}
	}
	
	
	public boolean equals (Object obj){
		if (obj instanceof Pravougaonik) {
			Pravougaonik pocetni = (Pravougaonik) obj;
			if (this.getGoreLevo().equals(pocetni.getGoreLevo()) && this.visina == pocetni.visina && this.getStranica() == pocetni.getStranica())
				return true;
				else
					return false;
		}else
			return false;
	}
	
	public String toString(){
		return "Gornji levi ugao = "+this.getGoreLevo()+", sirina = "+getStranica()+". visina = "+getVisina();
	}

	public Linija dijagonala(){
		int xDoleDesno=getGoreLevo().getX() + getStranica();
		int yDoleDesno=getGoreLevo().getY() + visina;
		Tacka doleDesno= new Tacka(xDoleDesno,yDoleDesno);
		Linija d = new Linija(getGoreLevo(), doleDesno);
		return d;
		// moze i ovako:
		// return new Linija(goreLevo, new Tacka(goreLevo.getX() + sirina,goreLevo.getY() + visina));
	}

	public Tacka centarPravougaonika(){
		return dijagonala().sredinaLinije();
	}

	public double povrsina(){
		int p = getStranica() * visina;
		return p;
	}

	public double obim(){
		int o = 2*getStranica() + 2*visina;
		return o;
	}

	public void pomeriNa(int x,int y){
		getGoreLevo().pomeriNa(x, y);
	}

	public void pomeriZa(int x,int y){
		getGoreLevo().pomeriZa(x, y);
	}


	
	public int getVisina(){
		return visina;
	}


	public void setVisina(int novaVisina){
		visina = novaVisina;

	}
	
	public String typeToString(){
		return "Pravougaonik";
	}



}
