package geometrija;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import wb.DlgPravougaonik;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.border.BevelBorder;

public class Crtez extends JPanel{
	ArrayList oblici = new ArrayList();
	public Crtez() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.LIGHT_GRAY, null, null));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				Tacka t = new Tacka(x, y, Color.black);
				DlgPravougaonik dlgp = new DlgPravougaonik();
				dlgp.setVisible(true);
				int visina = Integer.parseInt(dlgp.visina);
				int sirina = Integer.parseInt(dlgp.sirina);
			//	Pravougaonik p = new Pravougaonik(t, sirina, visina, dlgp.boja);
				
				//oblici.add(p);
				
			}
		});
	}

	public static void main(String[] args) {
		JFrame prozor = new JFrame();
		prozor.setSize(800, 600);
		prozor.setVisible(true);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prozor.setTitle("Vidi prozor!!!");
		Crtez c = new Crtez();
		prozor.getContentPane().add(c);
		c.setBackground(Color.black);

	}

	public void paint (Graphics g){
		super.paint(g);
		Iterator it = oblici.iterator();
		while(it.hasNext()){
			Oblik o = (Oblik) it.next();
			o.crtajSe(g);
			
		}
		repaint();
		/*
		g.drawString("Neki text na poziciji 150 150", 150, 150);
		Tacka t1 = new Tacka(50, 50);
		t1.crtajSe(g);
		Tacka t2 = new Tacka(75, 75);


		t2.crtajSe(g);
		t2.pomeriNa(10, 10);
		t2.crtajSe(g);
		repaint();
		Linija l1= new Linija(new Tacka(300, 300), new Tacka(350, 350));
		l1.crtajSe(g);
		Pravougaonik p1 = new Pravougaonik(new Tacka(500, 500), 100, 50);
		p1.crtajSe(g);
		Kvadrat k1 = new Kvadrat(new Tacka(250, 100), 100);
		k1.crtajSe(g);
		Krug kr1 = new Krug(new Tacka(400, 100), 50 );
		kr1.crtajSe(g);
		kr1.getCentar().crtajSe(g);
		//p1.dijagonala().crtajSe(g);
		k1.dijagonalaKvadrata().crtajSe(g);
		p1.centarPravougaonika().crtajSe(g);
		p1.getGoreLevo().crtajSe(g);
	 
		Tacka t10 = new Tacka(2, 200, "plava");
		Tacka t11 = new Tacka(200, 400);
		Tacka t12 = new Tacka(400, 800, "ZeleNa");
		Tacka t13 = new Tacka(800, 1000);

		Linija l10  = new Linija(t10,t11, "Crvena");
		Linija l11  = new Linija(t11,t12);
		Linija l12  = new Linija(t10,t13,"roza");

		Kvadrat k1= new Kvadrat(new Tacka(500, 50), 100, "zuta");
		Kvadrat k2 = new Kvadrat(new Tacka(700, 50), 75, "roza");

		Pravougaonik p1=new Pravougaonik(new Tacka(500, 300), 150, 75,  "plava");
		Pravougaonik p2=new Pravougaonik(new Tacka(700, 300), 100, 65,"crvena");

		p1.getGoreLevo().setBoja("ZelenA");
		p1.getGoreLevo().crtajSe(g);
		Krug kr1= new Krug(k1.centarKvadrata(), k1.getStranica()/2 , "crvena");
		kr1.crtajSe(g);
		kr1.getCentar().setBoja("crna");
		kr1.getCentar().crtajSe(g);

		//k2.setBoja("zelena");
		k2.setBojaUnutrasnjosti("zelena");
		k2.popuni(g);

		k1.setBojaUnutrasnjosti("roza");
		k1.popuni(g);


		t10.crtajSe(g);
		t12.crtajSe(g);
		l10.crtajSe(g);
		l12.crtajSe(g);
		k1.crtajSe(g);
		k2.crtajSe(g);
		p1.crtajSe(g);
		p2.crtajSe(g);
		p2.selektovan(g);

		Krug kr5 = new Krug(t11, 66,"PlaVa");
		kr5.crtajSe(g);

		kr5.setBojaUnutrasnjosti("zuta");
		kr5.popuni(g);

		t12.setSelektovan(true);

		Linija l5 = new Linija(k1.getGoreLevo(), p2.getGoreLevo(), "zuta");
		//l5.setSelektovan(true);
		l5.crtajSe(g);

		k2.setSelektovan(true);
		k2.crtajSe(g);

		kr5.setSelektovan(true);
		kr5.crtajSe(g);

		
		Polilinija2 poli = new Polilinija2();

		try {
			poli.dodajSegment(l10);
			poli.dodajSegment(l11);
			poli.dodajSegment(l12);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			poli.ukloniSegment();
			poli.ukloniSegment();
			poli.ukloniSegment();
			poli.ukloniSegment();
		} catch (Exception e) {
			e.printStackTrace();
		}

		poli.crtajSe(g);*/
		
	}

}
