package ispit;

import geometrija.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class DlgModifikacija extends JDialog {
	private JPanel contentPane;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNovaSirina;
	private JTextField txtNovaVisina;
	private JTextField txtPomeriNaX;
	private JTextField txtPomeriNaY;
	private JTextField txtPomeriZaX;
	private JTextField txtPomeriZaY;
	
	public String type=PnlCrtez.selektovan.typeToString();
	public String action;
	public double duzina;
	public int sirina;
	public int visina;
	public Color boja;
	public Color bojaIvice;
	public Color bojaUnutr;
	public String bojaUnutrasnjosti;
	public int pozicijaX;
	public int pozicijaY;
	boolean isNumb=true;
	boolean isNumbSirina=true;
	boolean isNumbVisina=true;
	boolean isNumbZaX=true;
	boolean isNumbZaY=true;
	boolean isNumbNaX=true;
	boolean isNumbNaY=true;
	boolean isIspuni=false;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	DecimalFormat df=new DecimalFormat(("#"));
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifikacija dialog = new DlgModifikacija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifikacija() {
		setModal(true);
		setTitle("Modifikacija");
		setBounds(100, 100, 293, 438);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblSirina = new JLabel("Sirina:");
		lblSirina.setBounds(16, 140, 88, 14);
		lblSirina.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblVisina = new JLabel("Visina:");
		lblVisina.setBounds(16, 186, 88, 14);
		lblVisina.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnBojaIvice = new JButton("Boja ivice");

		btnBojaIvice.setBounds(66, 37, 157, 23);
		
		JButton btnBojaUnutrasnjosti = new JButton("Boja unutrasnjosti");
		btnBojaUnutrasnjosti.setBounds(66, 86, 157, 23);
		
		txtNovaSirina = new JTextField();

		
		txtNovaSirina.setBounds(137, 137, 86, 20);
		txtNovaSirina.setColumns(10);
		
		txtNovaVisina = new JTextField();
		
		txtNovaVisina.setBounds(135, 183, 88, 20);
		txtNovaVisina.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(99, 232, 0, 0);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(135, 235, 27, 14);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(135, 263, 27, 14);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 288, 208, 9);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(15, 212, 208, 9);
		
		JLabel label_1 = new JLabel("X:");
		label_1.setBounds(135, 308, 27, 14);
		
		JLabel label_2 = new JLabel("Y:");
		label_2.setBounds(135, 340, 10, 14);
		
		final JButton okButton = new JButton("OK");
		
		txtPomeriNaX = new JTextField();
		txtPomeriNaX.setBounds(172, 232, 51, 20);
		txtPomeriNaX.setColumns(10);
		txtPomeriNaX.setEnabled(false);
		contentPanel.setLayout(null);
		contentPanel.add(separator);
		contentPanel.add(separator_1);
		contentPanel.add(label_1);
		contentPanel.add(label_2);
		contentPanel.add(txtPomeriNaX);
		contentPanel.add(label);
		contentPanel.add(btnBojaUnutrasnjosti);
		contentPanel.add(btnBojaIvice);
		contentPanel.add(txtNovaSirina);
		contentPanel.add(lblX);
		contentPanel.add(txtNovaVisina);
		contentPanel.add(lblY);
		contentPanel.add(lblVisina);
		contentPanel.add(lblSirina);
		
		txtPomeriNaY = new JTextField();
		txtPomeriNaY.setColumns(10);
		txtPomeriNaY.setBounds(172, 257, 51, 20);
		txtPomeriNaY.setEnabled(false);
		contentPanel.add(txtPomeriNaY);
		
		txtPomeriZaX = new JTextField();
		txtPomeriZaX.setColumns(10);
		txtPomeriZaX.setBounds(172, 305, 51, 20);
		txtPomeriZaX.setEnabled(false);
		contentPanel.add(txtPomeriZaX);
		
		txtPomeriZaY = new JTextField();
		txtPomeriZaY.setColumns(10);
		txtPomeriZaY.setBounds(172, 337, 51, 20);
		txtPomeriZaY.setEnabled(false);
		contentPanel.add(txtPomeriZaY);
		
		JLabel lblNoveVrednosti = new JLabel("Nove vrednosti");
		lblNoveVrednosti.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoveVrednosti.setBounds(50, 11, 183, 14);
		contentPanel.add(lblNoveVrednosti);
		
		txtPomeriNaX.setText("0");
		txtPomeriNaY.setText("0");
		txtPomeriZaX.setText("0");
		txtPomeriZaY.setText("0");
		
		
		boja=PnlCrtez.selektovan.getColor();
		
		if(type=="Tacka"){
			btnBojaUnutrasnjosti.setVisible(false);
			btnBojaIvice.setText("Boja");
			txtNovaSirina.setVisible(false);
			lblSirina.setVisible(false);
			txtNovaVisina.setVisible(false);
			lblVisina.setVisible(false);
			txtPomeriNaX.setText(String.valueOf(((Tacka) PnlCrtez.selektovan).getX()));
			txtPomeriNaY.setText(String.valueOf(((Tacka) PnlCrtez.selektovan).getY()));
			
		}else if(type=="Linija"){
			btnBojaUnutrasnjosti.setVisible(false);
			btnBojaIvice.setText("Boja linije");
			txtNovaSirina.setVisible(true);
			txtNovaSirina.setEnabled(true);
			txtNovaVisina.setVisible(false);
			lblVisina.setVisible(false);
			lblSirina.setText("Duzina:");
			lblSirina.setVisible(true);
			duzina=((Linija)PnlCrtez.selektovan).duzina();
			txtNovaSirina.setText(df.format(duzina));
		}
		if(type=="Kvadrat"|| type=="Pravougaonik"){
			txtNovaSirina.setText(String.valueOf(PnlCrtez.selektovan.getStranica()));
			sirina=PnlCrtez.selektovan.getStranica();
			if(type=="Kvadrat"){
				txtNovaVisina.setVisible(false);
				lblVisina.setVisible(false);
			}else{
				txtNovaVisina.setVisible(true);
				lblVisina.setVisible(true);
				txtNovaVisina.setText(String.valueOf(PnlCrtez.selektovan.getVisina()));
				visina=PnlCrtez.selektovan.getVisina();
			}
				
		}else if(PnlCrtez.selektovan.typeToString()=="Krug"){
			txtNovaSirina.setText(String.valueOf(PnlCrtez.selektovan.getRadius()));
			txtNovaVisina.setVisible(false);
			lblSirina.setText("Radius");
			lblVisina.setVisible(false);
			txtNovaVisina.setVisible(false);
			sirina=PnlCrtez.selektovan.getRadius();
			
		}
		
		
		final JCheckBox chbPomeriNa = new JCheckBox("Pomeri na:");
		buttonGroup.add(chbPomeriNa);
		
		chbPomeriNa.setBounds(15, 228, 97, 23);
		contentPanel.add(chbPomeriNa);
		
		final JCheckBox chbPomeriZa = new JCheckBox("Pomeri za:");
		
		buttonGroup.add(chbPomeriZa);
		chbPomeriZa.setBounds(15, 304, 97, 23);
		contentPanel.add(chbPomeriZa);
		
		
		////EVENTS////
		//proveravaju se sva polja na focus out da li su brojevi
		txtNovaSirina.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				/*isNumb=true;
				isNumb=isNumb & isNumber(txtNovaSirina.getText());
				if(txtNovaSirina.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Vrednost ce ostati nepromenjena", "Potrda", JOptionPane.INFORMATION_MESSAGE);
					txtNovaSirina.setText(String.valueOf(sirina));
				}
				if(!isNumb)
					okButton.setEnabled(false);
				else
					okButton.setEnabled(true);*/
				isNumbSirina=true & isNumber(txtNovaSirina.getText());
				isNumb=isNumbSirina & isNumbVisina & isNumbNaX & isNumbNaY & isNumbZaX & isNumbZaY;

					if(!isNumb){
						if(isDouble(txtNovaSirina.getText())){
							JOptionPane.showMessageDialog(null, "Ova verzija ne podrzava decimalne vrednosti", "Greska", JOptionPane.INFORMATION_MESSAGE);
						}
						okButton.setEnabled(false);
					}
						
					else{
						if(txtNovaSirina.getText().length()==0){
							JOptionPane.showMessageDialog(null, "Vrednost ce ostati nepromenjena", "Potrda", JOptionPane.INFORMATION_MESSAGE);
							txtNovaSirina.setText(String.valueOf(sirina));
						}
						okButton.setEnabled(true);
					}
			}
		});
		txtNovaVisina.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				/*isNumb=isNumb & isNumber(txtNovaVisina.getText());
				if(txtNovaVisina.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Visina ce ostati nepromenjena", "Potrda", JOptionPane.INFORMATION_MESSAGE);
					txtNovaVisina.setText(String.valueOf(visina));
				}
				if(!isNumb)
					okButton.setEnabled(false);
				else
					okButton.setEnabled(true);*/
				isNumbVisina=true & isNumber(txtNovaVisina.getText());
				isNumb=isNumbSirina & isNumbVisina & isNumbNaX & isNumbNaY & isNumbZaX & isNumbZaY;
				
				if(!isNumb){
					if(isDouble(txtNovaVisina.getText())){
						JOptionPane.showMessageDialog(null, "Ova verzija ne podrzava decimalne vrednosti", "Greska", JOptionPane.INFORMATION_MESSAGE);
					}
					okButton.setEnabled(false);
				}else{
					if(txtNovaVisina.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Visina ce ostati nepromenjena", "Potrda", JOptionPane.INFORMATION_MESSAGE);
						txtNovaVisina.setText(String.valueOf(visina));
					}
					okButton.setEnabled(true);
				}
			}
		});
		
		txtPomeriNaX.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				/*isNumb=isNumb & isNumber(txtPomeriNaX.getText());
				if(txtPomeriNaX.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Postavljam X=0", "Potrda", JOptionPane.INFORMATION_MESSAGE);
					txtPomeriNaX.setText("0");
				}
				if(!isNumb)
					okButton.setEnabled(false);
				else
					okButton.setEnabled(true);*/
				isNumbNaX=true & isNumber(txtPomeriNaX.getText());
				isNumb=isNumbSirina & isNumbVisina & isNumbNaX & isNumbNaY & isNumbZaX & isNumbZaY;
				if(!isNumb){
					if(isDouble(txtPomeriNaX.getText())){
						JOptionPane.showMessageDialog(null, "Ova verzija ne podrzava decimalne vrednosti", "Greska", JOptionPane.INFORMATION_MESSAGE);
					}
					okButton.setEnabled(false);
				}
					
				else{
					if(txtPomeriNaX.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Postavljam X=0", "Potrda", JOptionPane.INFORMATION_MESSAGE);
						txtPomeriNaX.setText("0");
					}
					okButton.setEnabled(true);
				}
			}
		});
		
		txtPomeriNaY.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				/*isNumb=isNumb & isNumber(txtPomeriNaX.getText());
				if(txtPomeriNaY.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Postavljam Y=0", "Potrda", JOptionPane.INFORMATION_MESSAGE);
					txtPomeriNaY.setText("0");
				}
				if(!isNumb)
					okButton.setEnabled(false);
				else
					okButton.setEnabled(true);*/
				isNumbNaY=true & isNumber(txtPomeriNaY.getText());
				isNumb=isNumbSirina & isNumbVisina & isNumbNaX & isNumbNaY & isNumbZaX & isNumbZaY;
				if(!isNumb){
					if(isDouble(txtPomeriNaY.getText())){
						JOptionPane.showMessageDialog(null, "Ova verzija ne podrzava decimalne vrednosti", "Greska", JOptionPane.INFORMATION_MESSAGE);
					}
					okButton.setEnabled(false);
				}
				
				else{
					if(txtPomeriNaY.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Postavljam Y=0", "Potrda", JOptionPane.INFORMATION_MESSAGE);
						txtPomeriNaY.setText("0");
					}
					okButton.setEnabled(true);
				}
			}
		});
		
		txtPomeriZaX.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				/*isNumb=isNumb & isNumber(txtPomeriZaX.getText());
				if(txtPomeriZaX.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Postavljam X=0", "Potrda", JOptionPane.INFORMATION_MESSAGE);
					txtPomeriZaX.setText("0");
				}
				if(!isNumb)
					okButton.setEnabled(false);
				else
					okButton.setEnabled(true);*/
				isNumbZaX=true & isNumber(txtPomeriZaX.getText());
				isNumb=isNumbSirina & isNumbVisina & isNumbNaX & isNumbNaY & isNumbZaX & isNumbZaY;
				if(!isNumb){
					if(isDouble(txtPomeriZaX.getText())){
						JOptionPane.showMessageDialog(null, "Ova verzija ne podrzava decimalne vrednosti", "Greska", JOptionPane.INFORMATION_MESSAGE);
					}
					okButton.setEnabled(false);
				}
					
				else{
					if(txtPomeriZaX.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Postavljam X=0", "Potrda", JOptionPane.INFORMATION_MESSAGE);
						txtPomeriZaX.setText("0");
					}
					okButton.setEnabled(true);
				}
			}
		});
		
		txtPomeriZaY.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				/*isNumb=isNumb & isNumber(txtPomeriZaY.getText());
				if(txtPomeriZaY.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Postavljam Y=0", "Potrda", JOptionPane.INFORMATION_MESSAGE);
					txtPomeriZaY.setText("0");
				}
				if(!isNumb)
					okButton.setEnabled(false);
				else
					okButton.setEnabled(true);*/
				isNumbZaY=true & isNumber(txtPomeriZaY.getText());
				isNumb=isNumbSirina & isNumbVisina & isNumbNaX & isNumbNaY & isNumbZaX & isNumbZaY;
				if(!isNumb){
					if(isDouble(txtPomeriZaY.getText())){
						JOptionPane.showMessageDialog(null, "Ova verzija ne podrzava decimalne vrednosti", "Greska", JOptionPane.INFORMATION_MESSAGE);
					}
					okButton.setEnabled(false);
				}
					
				else{
					if(txtPomeriZaY.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Postavljam Y=0", "Potrda", JOptionPane.INFORMATION_MESSAGE);
						txtPomeriZaY.setText("0");
					}
					okButton.setEnabled(true);
				}
				
			}
		});
		
		btnBojaIvice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action="btnBojaClicked";
				try{
					bojaIvice=JColorChooser.showDialog(contentPane, "Izaberi boju", Color.WHITE);
					//ColorUtils cUtil=new ColorUtils();
					//FrmPaint.bojaStr=cUtil.getColorNameFromColor(FrmPaint.boja);
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Boja nije izmenjena! Trenutna: " +FrmPaint.bojaStr, "Poruka", JOptionPane.INFORMATION_MESSAGE);
					bojaIvice=boja;
				}
			
				
			}
		});
		
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Color tempBoja=FrmPaint.bojaUnutr;
					bojaUnutr=JColorChooser.showDialog(contentPane, "Izaberi boju", Color.WHITE);
					//ColorUtils cUtil=new ColorUtils();
					//FrmPaint.bojaUnutr=cUtil.getColorNameFromColor(FrmPaint.boja);
					if(tempBoja!=bojaUnutr)
						isIspuni=true;
					else
						isIspuni=false;
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Boja nije izmenjena, oblik se nece popuniti", "Poruka", JOptionPane.INFORMATION_MESSAGE);				
				}
				
			}
		});
		
		chbPomeriNa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chbPomeriNa.isSelected()){
					txtPomeriNaX.setEnabled(true);
					txtPomeriNaY.setEnabled(true);
					txtPomeriZaX.setEnabled(false);
					txtPomeriZaY.setEnabled(false);
				}
			}
		});
		
		chbPomeriZa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chbPomeriZa.isSelected()){
					txtPomeriNaX.setEnabled(false);
					txtPomeriNaY.setEnabled(false);
					txtPomeriZaX.setEnabled(true);
					txtPomeriZaY.setEnabled(true);
				}
			}
		});

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);

				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//sirina ce biti za kvadrat i pravougaonik, za krug ce radius uzeti ovu sirinu, za liniju sirina ce biti duzina
						//za tacku ne treba da postoji ni sirina ni visina
						if(!isNumb){
							JOptionPane.showMessageDialog(null, "Morate uneti brojeve", "Greska", JOptionPane.ERROR_MESSAGE);
						}
						//ako imamo brojeve setujemo vrednosti i prihvatamo ok
						else{
							FrmPaint.actionStr="OK";
							if(type!="Tacka"){
								sirina=Integer.parseInt(txtNovaSirina.getText());
							}
							if(type=="Kvadrat"){
								if(isIspuni){
									((Kvadrat)PnlCrtez.selektovan).setBojaUnutrasnjosti(bojaUnutr);
									
									((Kvadrat)PnlCrtez.selektovan).setPopunjen(true);
								}
							}
							if(type=="Pravougaonik"){
								visina=Integer.parseInt(txtNovaVisina.getText());
								
								if(isIspuni){
									((Pravougaonik)PnlCrtez.selektovan).setBojaUnutrasnjosti(bojaUnutr);
									((Pravougaonik)PnlCrtez.selektovan).setPopunjen(true);
								}
							}
							if(type=="Krug"){
								if(isIspuni){
									((Krug)PnlCrtez.selektovan).setBojaUnutrasnjosti(bojaUnutr);
									((Krug)PnlCrtez.selektovan).setPopunjen(true);
								}
								
							}	
							
							
							if(chbPomeriNa.isSelected()){
								pozicijaX=Integer.parseInt(txtPomeriNaX.getText());
								pozicijaY=Integer.parseInt(txtPomeriNaY.getText());
								if(type=="Tacka")
									((Tacka) PnlCrtez.selektovan).pomeriNa(pozicijaX, pozicijaY);
								if(type=="Linija")
									((Linija) PnlCrtez.selektovan).pomeriNa(pozicijaX, pozicijaY);
								if(type=="Krug")
									((Krug) PnlCrtez.selektovan).pomeriNa(pozicijaX, pozicijaY);
								if(type=="Kvadrat")
									((Kvadrat) PnlCrtez.selektovan).pomeriNa(pozicijaX, pozicijaY);
								if(type=="Pravougaonik")
									((Pravougaonik) PnlCrtez.selektovan).pomeriNa(pozicijaX, pozicijaY);
							}
							if(chbPomeriZa.isSelected()){
								pozicijaX=Integer.parseInt(txtPomeriZaX.getText());
								pozicijaY=Integer.parseInt(txtPomeriZaY.getText());
								if(type=="Tacka")
									((Tacka) PnlCrtez.selektovan).pomeriZa(pozicijaX, pozicijaY);
								if(type=="Linija")
									((Linija) PnlCrtez.selektovan).pomeriZa(pozicijaX, pozicijaY);
								if(type=="Krug")
									((Krug) PnlCrtez.selektovan).pomeriZa(pozicijaX, pozicijaY);
								if(type=="Kvadrat")
									((Kvadrat) PnlCrtez.selektovan).pomeriZa(pozicijaX, pozicijaY);
								if(type=="Pravougaonik")
									((Pravougaonik) PnlCrtez.selektovan).pomeriZa(pozicijaX, pozicijaY);
							
							}
							
							dispose();
						}

							
						
					}
				});

			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FrmPaint.actionStr="Cancel";
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public static boolean isNumber(String s){
		try{
			
			int n=Integer.parseInt(s);
				return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

	public static boolean isDouble(String s){
		try{
			double n=Double.parseDouble(s);
				return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
}
