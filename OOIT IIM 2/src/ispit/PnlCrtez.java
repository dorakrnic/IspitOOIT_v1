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
	
	public static ArrayList<Oblik> oblici = new ArrayList();
	FrmPaint frmP;
	private int clickCounter=0;
	public static Oblik selektovan;
	public static int selPolozajX;
	public static int selPolozajY;
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
					Tacka t = new Tacka(x, y, FrmPaint.boja);
					oblici.add(t);
				}
				else if(FrmPaint.actionStr=="LINIJA"){
					clickCounter++;
					System.out.println("kliknuto na btn linija");
					int x=e.getX();
					int y=e.getY();
					System.out.println(clickCounter);
					if(clickCounter%2!=0){
						t1=new Tacka(x, y, FrmPaint.boja);
						//oblici.add(t1);
					}else{
						t2=new Tacka(x,y,FrmPaint.boja);
						Linija l=new Linija(t1 , t2, FrmPaint.boja);
						//oblici.add(t2);
						oblici.add(l);
						clickCounter=0;
					}
				}
				else if(FrmPaint.actionStr=="KRUG"){
					Tacka t3=new Tacka(e.getX(),e.getY(), FrmPaint.boja);
					DlgUpit dlg=new DlgUpit("KRUG");
					dlg.setVisible(true);
					if(DlgUpit.btnStr=="OK"){
						int radius=dlg.radius;
						Krug k=new Krug(t3,radius, FrmPaint.boja);
						oblici.add(k);
					}	
				}
				else if(FrmPaint.actionStr=="KVADRAT"){
					Tacka t4=new Tacka(e.getX(),e.getY(), FrmPaint.boja);
					DlgUpit dlg=new DlgUpit("KVADRAT");
					dlg.setVisible(true);
					if(DlgUpit.btnStr=="OK"){
						Kvadrat kv=new Kvadrat(t4,dlg.radius, FrmPaint.boja);
						oblici.add(kv);
					}
				}
				else if(FrmPaint.actionStr=="PRAVOUGAONIK"){
					Tacka t5=new Tacka(e.getX(),e.getY(), FrmPaint.boja);
					DlgUpit dlg=new DlgUpit(FrmPaint.actionStr);
					dlg.setVisible(true);
					if(DlgUpit.btnStr=="OK"){
						p=new Pravougaonik(t5, dlg.radius, dlg.visina, FrmPaint.boja);
						oblici.add(p);
					}
				}
				
				if(FrmPaint.actionStr=="POPUNI"){
					Iterator it = oblici.iterator();
					while(it.hasNext()){
						try{
							PovrsinskiOblik o=(PovrsinskiOblik)it.next();
						
							if(o.sadrzi(e.getX(), e.getY())){
								o.setBojaUnutrasnjosti(FrmPaint.bojaUnutr);
								o.setPopunjen(true);
							}
							
						}catch(Exception ex){
						
						}
					}	
						
						
				}
				
				if(FrmPaint.actionStr=="SELEKCIJA"){
					Iterator it = oblici.iterator();
					while(it.hasNext()){
						Oblik o=(Oblik)it.next();
						
						if(o.sadrzi(e.getX(), e.getY())){
							if(o.isSelektovan()){
								o.setSelektovan(false);
							}else{
								o.setSelektovan(true);
								selektovan=o;
							}
								
						}
						//
						else{
							//deselektuj selektovanog
							if(o.isSelektovan()){
								o.setSelektovan(false);
								//i ako nije prethodno setovan neki drugi na selektovan
								if(o==selektovan)
									selektovan=null;
							}
							//imamo selektovanog, ostale setuj na false
							else{
								o.setSelektovan(false);
							}
							
						}
						
					}
				}
				
				if(FrmPaint.actionStr=="IZBRISI"){
					Iterator it = oblici.iterator();
					
						while(it.hasNext()){
							try{
								Oblik o=(Oblik)it.next();
								
								if(o.sadrzi(e.getX(),e.getY())){
									DlgPoruka dlg=new DlgPoruka();
									dlg.setVisible(true);
									if(dlg.btnStr=="OK"){
										oblici.remove((Oblik)o);
										break;
									}
											
								}
							}catch(Exception ex){
								
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
