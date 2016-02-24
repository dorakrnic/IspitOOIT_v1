package ispit;

import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Oblik;
import geometrija.PovrsinskiOblik;
import geometrija.Pravougaonik;
import geometrija.Tacka;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class PnlCrtez extends JPanel {
	
	ArrayList<Oblik> oblici = new ArrayList();
	FrmPaint frmP;
	private int clickCounter=0;
	/**
	 * Create the panel.
	 */
	public PnlCrtez(FrmPaint frmP) {
		
		
		addMouseListener(new MouseAdapter() {
			private Tacka t1;
			private Tacka t2;
			private Pravougaonik p;
			
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
						Krug k=new Krug(t3,radius, FrmPaint.bojaStr, FrmPaint.bojaUnutr);
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
						p=new Pravougaonik(t5, dlg.radius, dlg.visina, FrmPaint.bojaStr);
						oblici.add(p);
					}
				}
				
				//na radi !!!! ?????
				if(FrmPaint.actionStr=="POPUNI"){
					Iterator it = oblici.iterator();
					while(it.hasNext()){
						PovrsinskiOblik o=(PovrsinskiOblik)it.next();
						
						if(o.sadrzi(e.getX(), e.getY())){
							o.setBojaUnutrasnjosti(FrmPaint.bojaUnutr);
							oblici.add((Oblik)o);
						}
						
					}	
				}
				
				if(FrmPaint.actionStr=="SELEKCIJA"){
					//proci kroz sve oblike , proveriti sa metodom 'sadrzi' da li je unutar oblika i taj oblik setovati na selektovan
					Iterator it = oblici.iterator();
					while(it.hasNext()){
						Oblik o=(Oblik)it.next();
						System.out.println(o.getClass().getName());
						if(o.sadrzi(e.getX(), e.getY())){
							if(o.isSelektovan())
								o.setSelektovan(false);
							else
								o.setSelektovan(true);
						}
					}
				}
				///obraditi exception...u listi se nalaze i objekti koji nisu tipa Oblik
				if(FrmPaint.actionStr=="IZBRISI"){
					Iterator it = oblici.iterator();
					
						while(it.hasNext()){
							Oblik o=(Oblik)it.next();
							
							if(o.sadrzi(e.getX(),e.getY())){
								DlgPoruka dlg=new DlgPoruka();
								dlg.setVisible(true);
								if(dlg.btnStr=="OK")
									oblici.remove((Oblik)o);	
							}
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
