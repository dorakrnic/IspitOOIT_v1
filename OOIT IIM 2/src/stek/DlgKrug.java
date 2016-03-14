package stek;


import geometrija.Tacka;
import geometrija.Krug;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
	Krug krug;
	public String action;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgKrug dialog = new DlgKrug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog - Dodaj dugme
	 */
	public DlgKrug() {
		setModal(true);
		setTitle("Dijalog dodaj");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUputstvo = new JLabel("Unesi osobine kruga");
		lblUputstvo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUputstvo.setBounds(57, 11, 308, 14);
		contentPanel.add(lblUputstvo);
		
		JLabel lblCentar = new JLabel("Centar");
		lblCentar.setBounds(39, 51, 46, 14);
		contentPanel.add(lblCentar);
		
		JLabel lblPoluprecnik = new JLabel("Poluprecnik");
		lblPoluprecnik.setBounds(39, 115, 103, 14);
		contentPanel.add(lblPoluprecnik);
		
		JLabel lblBoja = new JLabel("Boja");
		lblBoja.setBounds(39, 163, 46, 14);
		contentPanel.add(lblBoja);
		
		JLabel lblX = new JLabel("x:");
		lblX.setBounds(146, 51, 25, 14);
		contentPanel.add(lblX);
		
		JLabel lblY = new JLabel("y:");
		lblY.setBounds(146, 76, 25, 14);
		contentPanel.add(lblY);
		
		txtX = new JTextField();
		txtX.setBounds(168, 48, 59, 20);
		contentPanel.add(txtX);
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setColumns(10);
		txtY.setBounds(168, 73, 59, 20);
		contentPanel.add(txtY);
		
		txtRadius = new JTextField();
		txtRadius.setColumns(10);
		txtRadius.setBounds(168, 112, 59, 20);
		contentPanel.add(txtRadius);
		
		final JComboBox comboBoja = new JComboBox();
		comboBoja.setModel(new DefaultComboBoxModel(new String[] {"Plava", "Crvena", "Zuta", "Crna", "Bela", "Zelena"}));
		comboBoja.setToolTipText("izaberi boju");
		comboBoja.setBounds(168, 160, 144, 20);
		contentPanel.add(comboBoja);
		
		final JLabel lblMandatory_x = new JLabel("*");
		lblMandatory_x.setForeground(Color.MAGENTA);
		lblMandatory_x.setBounds(237, 51, 46, 14);
		lblMandatory_x.setVisible(false);
		contentPanel.add(lblMandatory_x);
		
		final JLabel lblMandatory_y = new JLabel("*");
		lblMandatory_y.setForeground(Color.MAGENTA);
		lblMandatory_y.setBounds(237, 76, 46, 14);
		lblMandatory_y.setVisible(false);
		contentPanel.add(lblMandatory_y);
		
		final JLabel lblMandatory_r = new JLabel("*");
		lblMandatory_r.setForeground(Color.MAGENTA);
		lblMandatory_r.setBounds(237, 115, 46, 14);
		lblMandatory_r.setVisible(false);
		contentPanel.add(lblMandatory_r);
		
		final JLabel lblMandatory_boja = new JLabel("*");
		lblMandatory_boja.setForeground(Color.MAGENTA);
		lblMandatory_boja.setBounds(322, 163, 46, 14);
		lblMandatory_boja.setVisible(false);
		contentPanel.add(lblMandatory_boja);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lblMandatory_x.setVisible(false);
						lblMandatory_y.setVisible(false);
						lblMandatory_r.setVisible(false);
						//prvo cu proveriti da li su popunjena int polja, 
						//ako neko nije postavim oznaku * za mandatory i poruku
						//i zatim kad su sva popunjena proveravam da li su brojevi i ostavljam poruku ako nisu
						boolean isPopulate=true;
						if(txtX.getText().length()==0){
							lblMandatory_x.setVisible(true);
							isPopulate=false;	
						}
						if(txtY.getText().length()==0){
							lblMandatory_y.setVisible(true);
							isPopulate=false;
						}
						if(txtRadius.getText().length()==0){
							lblMandatory_r.setVisible(true);
							isPopulate=false;
						}
						if(isPopulate){
								try{
									int xKoo=Integer.parseInt(txtX.getText());
									int yKoo=Integer.parseInt(txtY.getText());
									int radius = Integer.parseInt(txtRadius.getText());
									String boja=(String) comboBoja.getSelectedItem();
									if(radius!=0){
										Tacka tacka=new Tacka(xKoo,yKoo);
										krug=new Krug(tacka,radius);
										
										dispose();
									}
									else{
										JOptionPane.showMessageDialog(null, "Radius ne moze biti 0", "Greska", JOptionPane.ERROR_MESSAGE);
									}
								}catch(NumberFormatException ex){
									System.out.println(ex);
									JOptionPane.showMessageDialog(null, "Morate uneti brojeve", "Greska", JOptionPane.ERROR_MESSAGE);
								}	
						}
						else
							JOptionPane.showMessageDialog(null, "Popuniti obavezna polja", "Greska", JOptionPane.WARNING_MESSAGE);							
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}
	/**
	 * Kreira se za oduzimanje sa steka
	 * @param k - prosledjujemo objekat tipa Krug sa nulte pozicije u listi
	 */
	public DlgKrug(final Krug k) {
		setModal(true);
		setTitle("Dijalog ukloni");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUputstvo = new JLabel("Uklanja se krug");
		lblUputstvo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUputstvo.setBounds(57, 11, 308, 14);
		contentPanel.add(lblUputstvo);
		
		JLabel lblCentar = new JLabel("Centar");
		lblCentar.setBounds(39, 51, 46, 14);
		contentPanel.add(lblCentar);
		
		JLabel lblPoluprecnik = new JLabel("Poluprecnik");
		lblPoluprecnik.setBounds(39, 115, 103, 14);
		contentPanel.add(lblPoluprecnik);
		
		JLabel lblBoja = new JLabel("Boja");
		lblBoja.setBounds(39, 163, 46, 14);
		contentPanel.add(lblBoja);
		
		JLabel lblX = new JLabel("x:");
		lblX.setBounds(146, 51, 25, 14);
		contentPanel.add(lblX);
		
		JLabel lblY = new JLabel("y:");
		lblY.setBounds(146, 76, 25, 14);
		contentPanel.add(lblY);
		
		txtX = new JTextField();
		txtX.setText(String.valueOf(k.getCentar().getX()));
		txtX.setEnabled(false);
		txtX.setBounds(168, 48, 59, 20);
		contentPanel.add(txtX);
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setText(String.valueOf(k.getCentar().getY()));
		txtY.setEnabled(false);
		txtY.setColumns(10);
		txtY.setBounds(168, 73, 59, 20);
		contentPanel.add(txtY);
		
		txtRadius = new JTextField();
		txtRadius.setText(String.valueOf(k.getRadius()));
		txtRadius.setEnabled(false);
		txtRadius.setColumns(10);
		txtRadius.setBounds(168, 112, 59, 20);
		contentPanel.add(txtRadius);
		
		final JComboBox comboBoja = new JComboBox();
		comboBoja.setEnabled(false);
		comboBoja.setModel(new DefaultComboBoxModel(new String[] {"Plava", "Crvena", "Zuta", "Crna", "Bela", "Zelena"}));
		comboBoja.setToolTipText("izaberi boju");
		comboBoja.setBounds(168, 160, 144, 20);
		comboBoja.setSelectedItem(String.valueOf(k.getBoja()));
		contentPanel.add(comboBoja);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*
						 * ovde nije vazno da prosledim - samo zbog testiranja
						 */
						getAction(e.getActionCommand());
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*
						 * prosledjujem naziv komande
						 */
						getAction(e.getActionCommand());
						dispose();
					}
				});
				
			}
		}
		
		
	}

	protected void getAction(String s) {		
		action=s;
	}
	/**
	 *@param postavlja vrednost komande u promenljivu da bi JFStek proveravao akciju na osnovu koje oduzima/ne oduzima sa liste
	 */

}
