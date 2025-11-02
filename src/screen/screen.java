package screen;

import java.awt.EventQueue;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Point;
import javax.swing.UIManager;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class screen {

	private JFrame lloguerParquingProfe;
	private JTextField textEntryEdat;
	private JTextField textEntryMatricula;
	private JTextField textEntryLlargadaCotxe;
	private JTextField textDisplayBase;
	private JTextField textDisplayDescompte;
	private JTextField textDisplayTotalPreu;
	private JTextField textDisplayBaseDte;
	private JTextField textDisplayIva;
	private JTextField textDisplayAlertes;
	private JComboBox<String> comboBoxLloguer;  
    private JComboBox<String> comboBoxPadro; 
    private JButton btnEsborrarDadesCotxe;
    private JButton btnCalcularDadesCotxe;
    private JButton btnValidarDades;
	private Border originalBorderTextEntryEdat;
	private Border originalBorderComboBoxLloguer;
	private Border originalBorderComboBoxPadro;
	private Border originalBorderTextEntryMatricula;
	private Border originalBorderTextEntryLlargadaCotxe;
	private int caseError;
	private User user;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					screen window = new screen();
					window.lloguerParquingProfe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		lloguerParquingProfe = new JFrame();
		lloguerParquingProfe.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		lloguerParquingProfe.setIgnoreRepaint(true);
		
		lloguerParquingProfe.setTitle("Lloguer PARQUING Profes                                                                     ");
		lloguerParquingProfe.getContentPane().setEnabled(false);
		
		lloguerParquingProfe.setSize(new Dimension(500, 580));
		lloguerParquingProfe.setLocationRelativeTo(null);
		lloguerParquingProfe.setVisible(true);
		lloguerParquingProfe.setResizable(false);
		lloguerParquingProfe.getContentPane().setLayout(null);
		user= new User();
		
		
		JPanel panelDadesClients = new JPanel();
		panelDadesClients.setBorder(new TitledBorder(null, "Dades Clients", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDadesClients.setBounds(12, 12, 476, 145);
		lloguerParquingProfe.getContentPane().add(panelDadesClients);
		panelDadesClients.setLayout(null);
		
		JLabel labelEdat = new JLabel("Edat");
		labelEdat.setFont(new Font("Dialog", Font.PLAIN, 12));
		labelEdat.setBounds(12, 24, 36, 17);
		panelDadesClients.add(labelEdat);
		
		JLabel lblLloguer = new JLabel("Tipus de Lloguer");
		lblLloguer.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblLloguer.setBounds(12, 64, 105, 17);
		panelDadesClients.add(lblLloguer);
		
		JLabel lblPadr = new JLabel("Padrò");
		lblPadr.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblPadr.setBounds(12, 104, 66, 17);
		panelDadesClients.add(lblPadr);
		
		textEntryEdat = new JTextField();
		textEntryEdat.setBounds(58, 22, 72, 21);
		textEntryEdat.setToolTipText(constants.INFO_EDAT_FIELD);
		panelDadesClients.add(textEntryEdat);
		originalBorderTextEntryEdat=textEntryEdat.getBorder();
		
		
		
		JLabel lblAnys = new JLabel("anys");
		lblAnys.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblAnys.setBounds(143, 24, 36, 17);
		panelDadesClients.add(lblAnys);
		
		comboBoxLloguer = new JComboBox<>();
		comboBoxLloguer.setModel(new DefaultComboBoxModel<>(new String[] {"Matí", "Tarda", "Nit", "24 hores"}));
		comboBoxLloguer.setBounds(124, 59, 179, 26);
		comboBoxLloguer.setSelectedIndex(-1);
		comboBoxLloguer.setToolTipText(constants.INFO_COMBO_LLOGUER);
		panelDadesClients.add(comboBoxLloguer);
		originalBorderComboBoxLloguer=comboBoxLloguer.getBorder();
		
		comboBoxPadro = new JComboBox<>();
		comboBoxPadro.setModel(new DefaultComboBoxModel<>(new String[] {"SI", "NO"}));
		comboBoxPadro.setBounds(124, 99, 179, 26);
		comboBoxPadro.setSelectedIndex(-1);
		comboBoxPadro.setToolTipText(constants.INFO_COMBO_PADRO);
		panelDadesClients.add(comboBoxPadro);
		originalBorderComboBoxPadro=comboBoxPadro.getBorder();

		
		
		btnValidarDades = new JButton("VALIDAR");
		btnValidarDades.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					int edat=Integer.parseInt(textEntryEdat.getText());
					String lloguer=(String) comboBoxLloguer.getSelectedItem();
					
					String tePadro=(String) comboBoxPadro.getSelectedItem();
					
					
					if(edat<18 || edat>100) {
						caseError=1;
						throw new IllegalArgumentException(constants.ERROR_RANGO_EDAT);
					}
					if(comboBoxLloguer.getSelectedIndex()==-1) {
						caseError=2;
						throw new IllegalArgumentException(constants.ERROR_LLOGUER_NO_SELECCIONAT);
						
					}
					if(comboBoxPadro.getSelectedIndex()==-1) {
						caseError=3;
						throw new IllegalArgumentException(constants.ERROR_PADRO_NO_SELECCIONAT);
						
					}
					user.setEdat(edat);
					user.setLloguer(lloguer);
					user.setPadro(tePadro);
					noHiHaErrors();
					
					habilitarDadesCotxe(true);
					habilitarDadesClient(false);
				}
				catch(NumberFormatException ex) {
					textDisplayAlertes.setText(constants.ERROR_NOMBRE_ENTER);
					mostraTextFieldError(textEntryEdat);
				}
				catch(IllegalArgumentException ex) {
					noHiHaErrors();
					textDisplayAlertes.setText(ex.getMessage());
					switchErrorCase(caseError);
					
				}
			}
		});
		btnValidarDades.setBounds(333, 59, 105, 27);
		panelDadesClients.add(btnValidarDades);
		
		JPanel panelDadesCotxe = new JPanel();
		panelDadesCotxe.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Dades Cotxe", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDadesCotxe.setBounds(12, 162, 476, 105);
		lloguerParquingProfe.getContentPane().add(panelDadesCotxe);
		panelDadesCotxe.setLayout(null);
		
		JLabel lblMatrcula = new JLabel("Matrícula");
		lblMatrcula.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMatrcula.setBounds(12, 23, 64, 17);
		panelDadesCotxe.add(lblMatrcula);
		
		JLabel lblLlargada = new JLabel("Llargada");
		lblLlargada.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblLlargada.setBounds(204, 23, 64, 17);
		panelDadesCotxe.add(lblLlargada);
		
		JLabel lblMetres = new JLabel("metres");
		lblMetres.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMetres.setBounds(366, 23, 64, 17);
		panelDadesCotxe.add(lblMetres);
		
		btnEsborrarDadesCotxe = new JButton("ESBORRAR TOT");
		btnEsborrarDadesCotxe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textEntryMatricula.setText("");
				textEntryLlargadaCotxe.setText("");
				textDisplayBase.setText("");
				textDisplayDescompte.setText("");
				textDisplayTotalPreu.setText("");
				textDisplayBaseDte.setText("");
				textDisplayIva.setText("");
				textEntryEdat.setText("");
				comboBoxLloguer.setSelectedIndex(-1);
				comboBoxPadro.setSelectedIndex(-1);
				
				habilitarDadesCotxe(false);
				habilitarDadesClient(true);
				textEntryEdat.requestFocusInWindow();
			}
			
		});
		btnEsborrarDadesCotxe.setEnabled(false);
		btnEsborrarDadesCotxe.setBounds(56, 66, 144, 27);
		panelDadesCotxe.add(btnEsborrarDadesCotxe);
		
		btnCalcularDadesCotxe = new JButton("CALCULAR");
		btnCalcularDadesCotxe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String matricula=textEntryMatricula.getText();
					double llargadaCotxe=Double.parseDouble(textEntryLlargadaCotxe.getText());
					
					
					if(matricula.isEmpty() || !matricula.matches("^[0-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}$")) {
						caseError=4;
						throw new IllegalArgumentException(constants.ERROR_MATRICULA);
					}
					if(llargadaCotxe<2.5 || llargadaCotxe > 6) {
						caseError=5;
						throw new IllegalArgumentException(constants.ERROR_NOMBRE_DOUBLE);
					}
					
					user.setMatricula(matricula);
					user.setLlargadaCotxe(llargadaCotxe);
					
					double preuBase=preuLloguer(user.getLloguer());
					double descompteBase=Math.round(descompte(user.getPadro(),user.getLlargadaCotxe(),preuBase)*100.0)/100.0;
					double preuBaseAmbDescompte=preuBase-descompteBase;
					double incrementIVA=Math.round(preuBaseAmbDescompte*constants.IVA*100.0)/100.0;
					double preuTotal=Math.round((preuBaseAmbDescompte+incrementIVA)*100.0)/100.0;
					
					textDisplayBase.setText(String.valueOf(preuBase));
					textDisplayDescompte.setText(String.valueOf(descompteBase));
					textDisplayBaseDte.setText(String.valueOf(preuBaseAmbDescompte));
					textDisplayIva.setText(String.valueOf(incrementIVA));
					textDisplayTotalPreu.setText(String.valueOf(preuTotal));
					
					noHiHaErrors();
				}
				catch(NumberFormatException ex) {
					textDisplayAlertes.setText(constants.ERROR_NOMBRE_DOUBLE);
					mostraTextFieldError(textEntryLlargadaCotxe);
				}
				catch(IllegalArgumentException ex) {
					noHiHaErrors();
					textDisplayAlertes.setText(ex.getMessage());
					switchErrorCase(caseError);
					
				}
			}
		});
		btnCalcularDadesCotxe.setEnabled(false);
		btnCalcularDadesCotxe.setBounds(247, 66, 144, 27);
		panelDadesCotxe.add(btnCalcularDadesCotxe);
		
		textEntryMatricula = new JTextField();
		textEntryMatricula.setEnabled(false);
		textEntryMatricula.setBounds(83, 21, 103, 21);
		textEntryMatricula.setToolTipText(constants.INFO_MATRICULA);
		originalBorderTextEntryMatricula=textEntryMatricula.getBorder();
		panelDadesCotxe.add(textEntryMatricula);
		
		textEntryLlargadaCotxe = new JTextField();
		textEntryLlargadaCotxe.setEnabled(false);
		textEntryLlargadaCotxe.setBounds(272, 21, 76, 21);
		textEntryLlargadaCotxe.setToolTipText(constants.INFO_LLARGADA_COTXE);
		originalBorderTextEntryLlargadaCotxe=textEntryLlargadaCotxe.getBorder();
		panelDadesCotxe.add(textEntryLlargadaCotxe);
		
		
		JPanel panelPreus = new JPanel();
		panelPreus.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "PREUS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPreus.setBounds(12, 279, 476, 159);
		lloguerParquingProfe.getContentPane().add(panelPreus);
		panelPreus.setLayout(null);
		
		JLabel lblBase = new JLabel("Base");
		lblBase.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblBase.setBounds(12, 29, 64, 17);
		panelPreus.add(lblBase);
		
		JLabel lblDescompte = new JLabel("Descompte");
		lblDescompte.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDescompte.setBounds(184, 29, 64, 17);
		panelPreus.add(lblDescompte);
		
		textDisplayBase = new JTextField();
		textDisplayBase.setEditable(false);
		textDisplayBase.setBounds(12, 58, 103, 21);
		panelPreus.add(textDisplayBase);
		
		textDisplayDescompte = new JTextField();
		textDisplayDescompte.setEditable(false);
		textDisplayDescompte.setBounds(180, 58, 103, 21);
		panelPreus.add(textDisplayDescompte);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTotal.setBounds(353, 60, 64, 17);
		panelPreus.add(lblTotal);
		
		JLabel lblBaseDescompte = new JLabel("Base amb Dte.");
		lblBaseDescompte.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblBaseDescompte.setBounds(12, 91, 103, 17);
		panelPreus.add(lblBaseDescompte);
		
		JLabel lblIva = new JLabel("IVA");
		lblIva.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblIva.setBounds(184, 91, 64, 17);
		panelPreus.add(lblIva);
		
		textDisplayTotalPreu = new JTextField();
		textDisplayTotalPreu.setEditable(false);
		textDisplayTotalPreu.setBounds(325, 89, 103, 21);
		panelPreus.add(textDisplayTotalPreu);
		
		textDisplayBaseDte = new JTextField();
		textDisplayBaseDte.setEditable(false);
		textDisplayBaseDte.setBounds(12, 120, 103, 21);
		panelPreus.add(textDisplayBaseDte);
		
		textDisplayIva = new JTextField();
		textDisplayIva.setEditable(false);
		textDisplayIva.setBounds(180, 120, 103, 21);
		panelPreus.add(textDisplayIva);
		
		JLabel lblNewLabel = new JLabel("€");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setBounds(120, 60, 21, 17);
		panelPreus.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("€");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(120, 122, 21, 17);
		panelPreus.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("€");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(290, 60, 21, 17);
		panelPreus.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("€");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(290, 122, 21, 17);
		panelPreus.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("€");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(431, 91, 21, 17);
		panelPreus.add(lblNewLabel_4);
		
		JPanel panelAlertes = new JPanel();
		panelAlertes.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Errors i Alertes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAlertes.setBounds(12, 450, 476, 70);
		lloguerParquingProfe.getContentPane().add(panelAlertes);
		panelAlertes.setLayout(null);
		
		textDisplayAlertes = new JTextField();
		textDisplayAlertes.setEditable(false);
		textDisplayAlertes.setBounds(12, 23, 452, 21);
		panelAlertes.add(textDisplayAlertes);
		
		
	}
	private void mostraTextFieldError(JTextField field) {
		field.selectAll();
	    field.requestFocusInWindow();
	    field.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	    field.setBackground(new Color(255, 230, 230));
	}
	private void mostraComboBoxError(JComboBox<?> comboBox) {
		comboBox.requestFocusInWindow();
		comboBox.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	}
	private void noHiHaErrors() {
		textEntryEdat.setBorder(originalBorderTextEntryEdat);
		comboBoxLloguer.setBorder(originalBorderComboBoxLloguer);
		comboBoxPadro.setBorder(originalBorderComboBoxPadro);
		textEntryMatricula.setBorder(originalBorderTextEntryMatricula);
		textEntryLlargadaCotxe.setBorder(originalBorderTextEntryLlargadaCotxe);
		textDisplayAlertes.setText("");
	}
	private void switchErrorCase(int caseError) {
		switch(caseError) {
		case 1:
			
			mostraTextFieldError(textEntryEdat);
			break;
		case 2:
			mostraComboBoxError(comboBoxLloguer);
			break;
		case 3:
			mostraComboBoxError(comboBoxPadro);
			break;
		case 4:
			mostraTextFieldError(textEntryMatricula);
			break;
		case 5:
			mostraTextFieldError(textEntryLlargadaCotxe);
			break;
		default:
			break;
			
	}
	}
	private void habilitarDadesCotxe(boolean habilitar) {
		if(habilitar) {
			textEntryMatricula.setEnabled(true);
			textEntryLlargadaCotxe.setEnabled(true);
			btnCalcularDadesCotxe.setEnabled(true);
			btnEsborrarDadesCotxe.setEnabled(true);
		}
		else {
			textEntryMatricula.setEnabled(false);
			textEntryLlargadaCotxe.setEnabled(false);
			btnCalcularDadesCotxe.setEnabled(false);
			btnEsborrarDadesCotxe.setEnabled(false);
		}
		
	}
	private void habilitarDadesClient(boolean habilitar) {
		if(habilitar) {
			textEntryEdat.setEnabled(true);
			comboBoxLloguer.setEnabled(true);
			comboBoxPadro.setEnabled(true);
			btnValidarDades.setEnabled(true);
			
		}
		else {
			textEntryEdat.setEnabled(false);
			comboBoxLloguer.setEnabled(false);
			comboBoxPadro.setEnabled(false);
			btnValidarDades.setEnabled(false);
		}
	}
	
	private double preuLloguer(String tipusLloguer) {
		double preu=0;
		if (tipusLloguer.equals(constants.TIPUS_LLOGUER[0])) {
	        preu = constants.PREU_LLOGUER[0];
	    } 
		else if (tipusLloguer.equals(constants.TIPUS_LLOGUER[1])) {
	        preu = constants.PREU_LLOGUER[1];
	    } 
		else if (tipusLloguer.equals(constants.TIPUS_LLOGUER[2])) {
	        preu = constants.PREU_LLOGUER[2];
	    } 
		else if (tipusLloguer.equals(constants.TIPUS_LLOGUER[3])) {
	        preu = constants.PREU_LLOGUER[3];
	    }
		return preu;
	}
	private double descompte(String padro, double llargadaCotxe, double base) {
		double descompte=0;
		
		if(padro.equals(constants.TE_PADRO[0])) {
			descompte+=base*constants.DESCOMPTE_PADRO;
		}
		if(llargadaCotxe<constants.MIDA_PETITA) {
			descompte+=base*constants.DESCOMPTE_MIDA_PETITA;
		}
		
		return descompte;
	}
}
