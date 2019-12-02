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
public class El�imenSy�tt� extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			El�imenSy�tt� dialog = new El�imenSy�tt�();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public El�imenSy�tt�() {
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
			JLabel label = new JLabel("El�imen nimi:");
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
			JLabel label = new JLabel("El�imen Rotu:");
			label.setFont(new Font("Tahoma", Font.BOLD, 16));
			label.setBounds(54, 108, 155, 32);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("El�imen Ik�:");
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
				JButton okButton = new JButton("Sy\u00F6t\u00E4 el�in tietokantaan");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Luodaan uusi olio
						El�in uusiEl�in = new El�in();	
						
						String uusiEl�inNimi = textField.getText();
						String uusiEl�inRotu = textField_1.getText();
						String uusiEl�inIk� = textField_2.getText();
												
						uusiEl�in.setEl�inNimi(uusiEl�inNimi);
						uusiEl�in.setEl�inRotu(uusiEl�inRotu);
						uusiEl�in.setEl�inIk�(uusiEl�inIk�);
						
						JDBC.tallennaEl�in(uusiEl�in);
						JOptionPane.showMessageDialog(contentPanel, "Lis�tty tietokantaan: " + uusiEl�inNimi);
						
						//Tyhjennet��n kent�t uutta lis�yst� varten
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
