import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EläimenSyöttö extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EläimenSyöttö dialog = new EläimenSyöttö();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EläimenSyöttö() {
		setTitle("El\u00E4imen sy\u00F6tt\u00F6ikkuna");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSytElimenTiedot = new JLabel("Sy\u00F6t\u00E4 el\u00E4imen tiedot:");
			lblSytElimenTiedot.setHorizontalAlignment(SwingConstants.CENTER);
			lblSytElimenTiedot.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblSytElimenTiedot.setBounds(10, 11, 414, 43);
			contentPanel.add(lblSytElimenTiedot);
		}
		{
			JLabel label = new JLabel("Eläimen nimi:");
			label.setFont(new Font("Tahoma", Font.BOLD, 16));
			label.setBounds(54, 65, 155, 32);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setColumns(10);
			textField.setBounds(219, 65, 120, 32);
			contentPanel.add(textField);
		}
		{
			textField_1 = new JTextField();
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setColumns(10);
			textField_1.setBounds(219, 108, 120, 32);
			contentPanel.add(textField_1);
		}
		{
			JLabel label = new JLabel("Eläimen Rotu:");
			label.setFont(new Font("Tahoma", Font.BOLD, 16));
			label.setBounds(54, 108, 155, 32);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Eläimen Ikä:");
			label.setFont(new Font("Tahoma", Font.BOLD, 16));
			label.setBounds(54, 151, 155, 32);
			contentPanel.add(label);
		}
		{
			textField_2 = new JTextField();
			textField_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_2.setColumns(10);
			textField_2.setBounds(219, 151, 120, 32);
			contentPanel.add(textField_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Sy\u00F6t\u00E4 eläin tietokantaan");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Luodaan uusi olio
						Eläin uusiEläin = new Eläin();	
						
						String uusiEläinNimi = textField.getText();
						String uusiEläinRotu = textField_1.getText();
						String uusiEläinIkä = textField_2.getText();
												
						uusiEläin.setEläinNimi(uusiEläinNimi);
						uusiEläin.setEläinRotu(uusiEläinRotu);
						uusiEläin.setEläinIkä(uusiEläinIkä);
						
						JDBC.tallennaEläin(uusiEläin);
						JOptionPane.showMessageDialog(contentPanel, "Lisätty tietokantaan: " + uusiEläinNimi);
						
						//Tyhjennetään kentät uutta lisäystä varten
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Sulje");
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

}
