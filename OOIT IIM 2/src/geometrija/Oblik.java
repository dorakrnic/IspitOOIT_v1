package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Pomerljiv {
	
	protected String boja;
	private boolean selektovan;
	protected Color color;
	public abstract boolean sadrzi(int x, int y) ;
	private int stranica;
	private int visina;
	private int radius;
	private String type;
	private double duzina;
	
	public abstract void crtajSe(Graphics g);
	
	public static Color pronadjiBoju(String boja){
		if(boja.equalsIgnoreCase("bela")|| boja.toLowerCase().contains("white"))
			return Color.white;
		else if(boja.equalsIgnoreCase("zuta")||boja.equalsIgnoreCase("yellow"))
			return Color.yellow;
		else if(boja.equalsIgnoreCase("zelena")||boja.toLowerCase().contains("green") || boja.equalsIgnoreCase("Gainsboro")){
			if(boja.equalsIgnoreCase("YellowGreen")||boja.equalsIgnoreCase("Lime")|| boja.equalsIgnoreCase("SpringGreen") )
				return Color.green.brighter();
			else
				return Color.green;
		}
		else if(boja.equalsIgnoreCase("crvena")||boja.equalsIgnoreCase("red"))
			return Color.red;
		else if(boja.toLowerCase().contains("salmon"))
			return Color.red.brighter().brighter();
		else if(boja.equalsIgnoreCase("plava")||boja.equalsIgnoreCase("blue"))
			return Color.blue;
		else if(boja.toLowerCase().contains("purple") || boja.toLowerCase().contains("lavender"))
			return Color.blue.brighter();
		else if(boja.equalsIgnoreCase("roza")||boja.toLowerCase().contains("magenta") || boja.toLowerCase().contains("pink"))
			return Color.magenta;
		else if(boja.equalsIgnoreCase("ljubicasta")|| boja.toLowerCase().contains("violet") || boja.equalsIgnoreCase("Fuchsia"))
			return Color.magenta.darker();
		else if(boja.toLowerCase().contains("turquoise"))
			return Color.cyan;
		else if(boja.equalsIgnoreCase("DarkCyan") || boja.equalsIgnoreCase("Teal"))
			return Color.cyan.darker();
		else if(boja.toLowerCase().contains("marine"))
			return Color.cyan.brighter();
		else if(boja.toLowerCase().contains("gray"))
			return Color.gray;
		else if(boja.equalsIgnoreCase("Silver"))
			return Color.gray.brighter();
		else if(boja.toLowerCase().contains("olive"))
			return Color.green.darker();
		else if(boja.toLowerCase().contains("orange")|| boja.equalsIgnoreCase("narandzasta"))
			return Color.orange;
		else
			return Color.black;
	}

	public String getBoja() {
		return boja;
	}
	
	public void setBoja(String boja) {
		this.boja = boja;
	}
	
	public Color getColor(){
		return color;
	}

	public void setCol(Color boja){
		this.color=boja;
	}
	

	public boolean isSelektovan() {
		return selektovan;
	}

	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
	
	public int getStranica(){
		return stranica;
	}
	public void setStranica(int stranica){
		this.stranica=stranica;
	}
	public int getRadius(){
		return stranica;
	}
	public void setRadius(int stranica){
		this.radius=stranica;
	}
	public int getVisina(){
		return visina;
	}
	public void setVisina(int visina){
		this.visina=visina;
	}
	
	public String typeToString(){
		return type;
	}
	
	public double duzina(){
		return duzina;
	}
	public void setDuzina(int duzina){
		this.duzina=duzina;
	}

}
