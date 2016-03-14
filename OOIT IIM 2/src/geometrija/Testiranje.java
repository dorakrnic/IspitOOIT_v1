package geometrija;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Testiranje {

	public static void main(String[] args) {/*
		// TODO Auto-generated method stub
		Tacka t1 = new Tacka();

		System.out.println("X koordinata t1 je: "+t1.getX());
		System.out.println("Y koordinata t1 je: "+t1.getY());

		t1.setX(5);
		t1.setY(15);

		System.out.println("nova X koordinata t1 je: "+t1.getX());
		System.out.println("nova Y koordinata t1 je: "+t1.getY());

		t1.pomeriNa(50, 25);

		System.out.println("nova X koordinata t1 nakon pomeranja NA je: "+t1.getX());
		System.out.println("nova Y koordinata t1 nakon pomeranja NA je: "+t1.getY());

		t1.pomeriZa(10, 7);

		System.out.println("nova X koordinata t1 nakon pomeranja ZA je: "+t1.getX());
		System.out.println("nova Y koordinata t1 nakon pomeranja ZA je: "+t1.getY());

		t1.setX(3);
		t1.setY(3);
		Tacka t2 = new Tacka();
		t2.setX(6);
		t2.setY(4);
		System.out.println("Udaljenost izmedju tacaka t1 i t2 je: "+t2.udaljenost(t1));



		Linija l1 = new Linija();
		l1.setPocetna(t1);
		l1.setKrajnja(t2);

		System.out.println("X koordinata pocetne tacke linije je: "+l1.getPocetna().getX());
		l1.getPocetna().setX(12);
		System.out.println("X koordinata pocetne tacke linije je: "+l1.getPocetna().getX());
		// postaviti X koordinatu krajnje tacke linije na vrednost Y koordinate  pocetne tacke linije
		l1.getKrajnja().setX(l1.getPocetna().getY());

		System.out.println("X koordinata krajnje tacke linije: "+l1.getKrajnja().getX());
		// postaviti Y koordinatu pocetne tacke linije na vrednost Y koordinate  krajnje tacke linije uvecanu za 10
		l1.getPocetna().setY(l1.getKrajnja().getY()+10);
		System.out.println("y koordinata pocetne tacke linije: " + l1.getPocetna().getY());

		// Postaviti X koordinatu pocetne tacke linije na vrednost proizvoda X koordinate tacke t2 i  
		// Y koordinate krajnje tacke linije umanjenog za razliku vrednosti X koordinate pocetne tacke linije i broja 2


		l1.getPocetna().setX(  (t2.getX() * l1.getKrajnja().getY() ) -  (l1.getPocetna().getX() - 2 ) );

		System.out.println("X koordinata pocetne tacke linije je: " +l1.getPocetna().getX() );

		Pravougaonik p1 = new Pravougaonik();
		p1.setVisina(15);
		p1.setSirina(30);
		p1.setGoreLevo(t1);
		System.out.println("Visina pravougaonika je: " +p1.getVisina());
		System.out.println("Sirina pravougaonika je: " +p1.getSirina());
		System.out.println("X koordinata tacke GoreLevo je: " + p1.getGoreLevo().getX());
		System.out.println("Y koordinata tacke GoreLevo je: " + p1.getGoreLevo().getY());


		Kvadrat kv1 = new Kvadrat();
		kv1.setStranica(30);
		kv1.setGoreLevo(t2);
		kv1.getGoreLevo().setX(10);
		kv1.getGoreLevo().setY(17);
		kv1.pomeriNa(10, 17);
		System.out.println("X koordinata tacke GoreLevo kvadrata je: " + kv1.getGoreLevo().getX());
		System.out.println("Y koordinta tacke GoreLevo kvadrata je: " + kv1.getGoreLevo().getY());
		System.out.println("povrsina kvadrata je: " + kv1.povrsina());
		System.out.println("obim kvadrata je: "+ kv1.obim());
		System.out.println("povrsina pravougaonika je: " + p1.povrsina());
		System.out.println("obim pravougaonika je: " + p1.obim());

		Krug k1 = new Krug();
		k1.setRadius(18);
		k1.setCentar(kv1.getGoreLevo());
		System.out.println("Povrsina kruga je: "+k1.povrsina());
		System.out.println("Obim kruga je: "+k1.obim());
		k1.setCentar(l1.getKrajnja());
		System.out.println("x koordinata centra je: " + k1.getCentar().getX());
		System.out.println("y koordinata centra je: " + k1.getCentar().getY());
		k1.pomeriZa(10, 15);
		System.out.println("x koordinata centra je: " + k1.getCentar().getX());
		System.out.println("y koordinata centra je: " + k1.getCentar().getY());

		//postaviti vrednost X koordinate tacke goreLevo pravougaonika na vrednost povrsine kruga

		p1.getGoreLevo().setX((int)k1.povrsina());
		System.out.println("Vrednost X koordinate tacke goreLevo pravougaonika je: "+p1.getGoreLevo().getX());

		Tacka t5 = new Tacka(20, 30);
		System.out.println("X koordinata t5 je: "+t5.getX());
		Tacka t6 = new Tacka(20, 30, "PLAVA");
		System.out.println("Boja t6 je: "+t6.getBoja());

		Linija l5 = new Linija(t6, t5);
		System.out.println("Boja krajnje tacke linije l5 je: "+l5.getKrajnja().getBoja());

		// kreirati liniju l6 sa koordinatama pocetne tacke 5 i 6, krajnja tacka t5 i boja ista kao t6
		Linija l6 = new Linija(t5, t6, t6.getBoja());

		System.out.println("X koordinata pocetne tacke linije je: "+l6.getPocetna().getX());

		// kreirati pravougaonik p5:
		// goreLevo: 10, 12
		// sirina: 15
		// visina: duzina linije l5

		Pravougaonik p5 = new Pravougaonik(new Tacka (10, 12), 15,(int) l5.duzina());
		System.out.println("Visina pravougaonika p5 je: "+p5.getVisina());

		Krug k5 = new Krug(t6, 35, "ZELENA");
		System.out.println("R kruga k5 je: "+k5.getRadius());

		System.out.println("X koordinata sredisne tacke linije l5: "+l5.sredinaLinije().getX());
		System.out.println("Y koordinata sredisne tacke linije l5: "+l5.sredinaLinije().getY());

		System.out.println("Duzina dijagonale p5 je: "+p5.dijagonala().duzina());

		Kvadrat kv5 = new Kvadrat(t5, 19);
		System.out.println("X koordinata centra opisanog kruga kvadrata kv5: "+kv5.centarKvadrata().getX());


		kreirati kvadrat kv 6:
			X goreLevo: zbir X sredisne tacke linije l5 i X pocetne tacke dijagonale p5
			Y gore levo: Y centra kvadrata kv5 uvecan za vrednost stranice kv5
			stranica: Radius k5
			boja: boja t6

		Kvadrat kv6 = new Kvadrat(
				new Tacka (l5.sredinaLinije().getX() + p5.dijagonala().getPocetna().getX(), 
						kv5.centarKvadrata().getY() + kv5.getStranica() ),  
						k5.getRadius(), 
						t6.getBoja());
		Kvadrat kv7 = new Kvadrat(t5, 19);

		System.out.println("X koordinata tacke goreLevo kvadrata kv6 je: " + kv6.getGoreLevo().getX() );
		System.out.println("Y koordinata tacke goreLevo kvadrata kv6 je: " + kv6.getGoreLevo().getY());
		System.out.println(t5);
		System.out.println("Linija l6: "+l6);

		System.out.println("Kvadrat kv6: " + kv6);
		System.out.println("Pravougaonik p5: " + p5);
		System.out.println("Krug k5:" + k5);
		System.out.println("Sredina linije l6: " + l6.sredinaLinije());
		System.out.println("Centar pravougaonika p5 je: " + p5.centarPravougaonika());

		System.out.println("sredisnja tacka dijagonale pravougaonika p5 :  " + p5.dijagonala().sredinaLinije()+"\n\tcentar kruga k5:"+k5.getCentar());

		System.out.println(t5.equals(t6));

		t5.setX(100);
		System.out.println("Linije su iste! " +l5.equals(l6));
		System.out.println("Kvadrati su isti! " + kv7.equals(kv5));

		Pravougaonik p6 = new Pravougaonik(new Tacka (10, 12), 15,(int) l5.duzina());

		System.out.println("Pravougaonici su isti! " + p5.equals(p6));

		Krug k6 = new Krug(t6, 35, "ZELENA");
		Krofna krofna = new Krofna(20, 30, 100, 50, "Crvena");
		System.out.println("Krugovi su isti: "+k5.equals(k6));
		System.out.println("Krofna: " + krofna);

		Krofna krofna1 = new Krofna(20, 30, 80, 50, "Crvena");
		System.out.println("Krofne su iste! "+krofna.equals(krofna1));
        Tacka t7 = new Tacka(2, 2);
        Tacka t8 = new Tacka(4, 2);
        Tacka t9 = new Tacka(2, 4);
        //Tacka t10 = new Tacka(4, 4);

        //System.out.println("da li je kvadrat: " + daLiJeKvadrat(t5, t8, t9));

        Tacka t10 = new Tacka(2, 2);
        Tacka t11 = new Tacka(4, 4);
        Tacka t12 = new Tacka(6, 4);
        Tacka t13 = new Tacka(7, 6);

        Linija l10  = new Linija(t10,t11);
        Linija l11  = new Linija(t11,t12);
        Linija l12  = new Linija(t12,t13);

        Polilinija poli = new Polilinija(3);

        poli.dodajSegment(l10);
        poli.dodajSegment(l11);
        poli.dodajSegment(l12);

        poli.ukloniSegment();
        poli.ukloniSegment();
        poli.ukloniSegment();
        poli.ukloniSegment();

       for(int i = 0; i<poli.getSegmenti().length;i++){
    	   System.out.println(poli.getSegmenti() [ i ] );
       } 
        System.out.println("Zbir duzina linija je: "+(l10.duzina()+l11.duzina()+l12.duzina()));
        System.out.println("Duzina polilinije je: "+ poli.duzina());
	 */
	/*	Tacka t6= new Tacka(2, 2);
		Krug k5 = new Krug(t6, 35, "ZELENA");
		ArrayList<Krug> lista = new ArrayList<Krug>();

		lista.add(k5);
		
		lista.add(k5);
		//System.out.println(lista.get(1));
		lista.add(k5);
		//System.out.println(lista.get(2));
		lista.add(k5);
		//System.out.println(lista.get(0));
		Iterator<Krug> it = lista.iterator();
		while (it.hasNext())
			System.out.println(it.next());*/
		

		Tacka t10 = new Tacka(2, 2);
		Tacka t11 = new Tacka(20, 20);
		Tacka t12 = new Tacka(30, 30);
		Tacka t13 = new Tacka(50,50);

		Linija l10  = new Linija(t10,t11);
		Linija l11  = new Linija(t11,t12);
		Linija l12  = new Linija(t12,t13);

		Polilinija2 poli = new Polilinija2();
/*
		poli.dodajSegment(l10);
		poli.dodajSegment(l11);
		poli.dodajSegment(l12);
	*/
		
		//JOptionPane.showMessageDialog(null, "RADI!!!", "GRESKA!", JOptionPane.ERROR_MESSAGE);
		Kvadrat kv1 = new Kvadrat(t11, 50);
		System.out.println(kv1.sadrzi(kv1.centarKvadrata().getX(), kv1.centarKvadrata().getY()));
		
		Krug kr2 = new Krug(t11, 10);
		System.out.println(kr2.sadrzi(t11.getX(), t11.getY()));
		
		System.out.println("\nSortiranje\n");
		
		Tacka nizTacka[] = new Tacka[4];
		
		nizTacka[0] = t13;
		nizTacka[1] = t11;
		nizTacka[2] = t10;
		nizTacka[3] = t12;
		
		System.out.println("Nesortiran niz: ");
		for(int i = 0; i<nizTacka.length;i++){
			System.out.println(nizTacka[i]);
		}
		
		Arrays.sort(nizTacka);
		
		System.out.println("Sortiran niz: ");
		for(int i = 0; i<nizTacka.length;i++){
			System.out.println(nizTacka[i]);
		}

		Linija nizLinija[] = new Linija[3];
		
		nizLinija[0] = l11;
		nizLinija[1] = l10;
		nizLinija[2] = l12;
		
		System.out.println("Nesortiran niz: ");
		
		for(int i = 0; i<nizLinija.length; i++){
			System.out.println(nizLinija[i]);
		}
		
		Arrays.sort(nizLinija);
		
		System.out.println("Sortiran niz: ");
		for(int i = 0; i<nizLinija.length; i++){
			System.out.println(nizLinija[i]);
		}
		
		Kvadrat nizKvadrata [] = new Kvadrat [3];
		nizKvadrata[0] = new Kvadrat(t13, 10);
		nizKvadrata[1] = new Kvadrat(t11, 8);
		nizKvadrata[2] = new Kvadrat(t12, 16);
		
		System.out.println("nesortiran niz");
		for (int i = 0; i<nizKvadrata.length; i++)
			
			System.out.println(nizKvadrata[i]);
		
		System.out.println("sortiran niz");
		Arrays.sort(nizKvadrata);
		for (int i = 0; i<nizKvadrata.length; i++)
			System.out.println(nizKvadrata[i]);
		
		
		Krug kr1 = new Krug(new Tacka(10, 15), 16);
		Krug kr3 = new Krug(new Tacka(11, 13), 7);
		
		Krug nizKrugova[] = new Krug[3];
		nizKrugova[0] = kr1;
		nizKrugova[1] = kr2;
		nizKrugova[2] = kr3;
		
		System.out.println("Nesortiran niz");
		for(int i = 0; i < nizKrugova.length; i++)
			System.out.println(nizKrugova[i]);
		
		Arrays.sort(nizKrugova);
		System.out.println("Sortiran niz");
		for(int i = 0; i < nizKrugova.length; i++)
			System.out.println(nizKrugova[i]);

		
		Pravougaonik nizPravougaonika[]= new Pravougaonik [3];
		nizPravougaonika[0]=new Pravougaonik(t13, 10, 5);
		nizPravougaonika[1]=new Pravougaonik(t13, 15, 3);
		nizPravougaonika[2]=new Pravougaonik(t13, 20, 4);
		
		System.out.println("Nesortiran niz");
		for(int i = 0; i < nizPravougaonika.length; i++)
			System.out.println(nizPravougaonika[i]);
		
		Arrays.sort(nizPravougaonika);
		System.out.println("Sortiran niz");
		for(int i = 0; i < nizPravougaonika.length; i++)
			System.out.println(nizPravougaonika[i]);
		
			
	}

	public static boolean daLiJeKvadrat (Tacka t1, Tacka t2, Tacka t3, Tacka t4){
		if (t1.getX() == t3.getX() && 
				t2.getX() == t4.getX() &&
				t1.getY() == t2.getY() &&
				t3.getY() == t4.getY() &&
				t1.udaljenost(t2) == t1.udaljenost(t3))
			return true;

		else
			return false;


	}
	
	
	
	

}
