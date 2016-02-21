package ispit;

import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Oblik;
import geometrija.PaintAgain;
import geometrija.Pravougaonik;
import geometrija.Tacka;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class PnlCrtez extends JPanel {
	
	ArrayList oblici = new ArrayList();
	FrmPaint frmP;
	private int clickCounter=0;
	/**
	 * Create the panel.
	 */
	public PnlCrtez(FrmPaint frmP) {
		
		
		addMouseListener(new MouseAdapter() {
			private Tacka t1;
			private Tacka t2;
			
			public void mouseClicked(MouseEvent e) {
				//System.out.println(e.getX());
				
				if(FrmPaint.actionStr=="TACKA"){
					int x = e.getX();
					int y = e.getY();
					Tacka t = new Tacka(x, y, FrmPaint.bojaStr);
					oblici.add(t);
				}
				else if(FrmPaint.actionStr=="LINIJA"){
					clickCounter++;
					System.out.println("kliknuto na btn linija");
					int x=e.getX();
					int y=e.getY();
					System.out.println(clickCounter);
					if(clickCounter%2!=0){
						t1=new Tacka(x, y, FrmPaint.bojaStr);
						oblici.add(t1);
					}else{
						t2=new Tacka(x,y,FrmPaint.bojaStr);
						Linija l=new Linija(t1 , t2, FrmPaint.bojaStr);
						oblici.add(t2);
						oblici.add(l);
						clickCounter=0;
					}
				}
				else if(FrmPaint.actionStr=="KRUG"){
					Tacka t3=new Tacka(e.getX(),e.getY(), FrmPaint.bojaStr);
					DlgUpit dlg=new DlgUpit("KRUG");
					dlg.setVisible(true);
					if(DlgUpit.btnStr=="OK"){
						int radius=dlg.radius;
						Krug k=new Krug(t3,radius, FrmPaint.bojaStr);
						oblici.add(k);
					}	
				}
				else if(FrmPaint.actionStr=="KVADRAT"){
					Tacka t4=new Tacka(e.getX(),e.getY(), FrmPaint.bojaStr);
					DlgUpit dlg=new DlgUpit("KVADRAT");
					dlg.setVisible(true);
					if(DlgUpit.btnStr=="OK"){
						Kvadrat kv=new Kvadrat(t4,dlg.radius, FrmPaint.bojaStr);
						oblici.add(kv);
					}
				}
				else if(FrmPaint.actionStr=="PRAVOUGAONIK"){
					Tacka t5=new Tacka(e.getX(),e.getY(), FrmPaint.bojaStr);
					DlgUpit dlg=new DlgUpit(FrmPaint.actionStr);
					dlg.setVisible(true);
					if(DlgUpit.btnStr=="OK"){
						Pravougaonik p=new Pravougaonik(t5, dlg.radius, dlg.visina, FrmPaint.bojaStr);
						oblici.add(p);
					}
				}
			}
		});

	}
	
	public void paint (Graphics g){
		super.paint(g);
		Iterator it = oblici.iterator();
		while(it.hasNext()){
			Oblik o = (Oblik) it.next();
			o.crtajSe(g);
			
		}
		repaint();
	}
}