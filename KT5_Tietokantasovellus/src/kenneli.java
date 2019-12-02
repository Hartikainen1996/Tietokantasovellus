import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class kenneli extends JFrame {

	static JPanel contentPane;
	static JTable table;
	El�imenSy�tt� sy�tt� = new El�imenSy�tt�();
	Tiedot tiedot = new Tiedot();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kenneli frame = new kenneli();					
					frame.setVisible(true);
					JDBC.lataaEl�imet();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

	/**
	 * Create the frame.
	 */
	public kenneli() {
		setTitle("Kenneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		JMenuItem mntmEl�imenSyttohjelma = new JMenuItem("El�imen sy\u00F6tt\u00F6ohjelma");
		mntmEl�imenSyttohjelma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sy�tt�.setVisible(true);
			}
		});
		mnTiedosto.add(mntmEl�imenSyttohjelma);
		
		JMenu mnTietoja = new JMenu("Tietoja");
		menuBar.add(mnTietoja);
		
		JMenuItem mntmTietojaOhjelmasta = new JMenuItem("Tietoja ohjelmasta");
		mntmTietojaOhjelmasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiedot.setVisible(true);
			}
		});
		mnTietoja.add(mntmTietojaOhjelmasta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLisAuto = new JButton("Lis\u00E4\u00E4 uusi el�in tietokantaan");
		btnLisAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Uusi Jdialog avautuu (sy�tt�ohjelma)
				sy�tt�.setVisible(true);
				}
		});
		
		btnLisAuto.setBounds(10, 241, 412, 23);
		contentPane.add(btnLisAuto);
		//P�ivit� taulukko
		JButton btnPivitTaulukko = new JButton("P\u00E4ivit\u00E4 taulukko");
		btnPivitTaulukko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//p�ivitt�� tietokantaa
				JDBC.lataaEl�imet();
			}
		});
		btnPivitTaulukko.setBounds(10, 206, 412, 23);
		contentPane.add(btnPivitTaulukko);
		//Poista valittu rivi
		JButton btnPoistaValittu = new JButton("Poista valittu rivi tietokannasta");
		btnPoistaValittu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDBC.poistaEl�imet();
				   DefaultTableModel model = (DefaultTableModel) table.getModel();
				   int[] rows = table.getSelectedRows();
				   											   
				   for(int i=0;i<rows.length;i++){						   
				     model.removeRow(rows[i]-i);						     
				   }
			}
		});
		btnPoistaValittu.setBounds(10, 276, 412, 23);
		contentPane.add(btnPoistaValittu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 183);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		DefaultTableModel model = new DefaultTableModel(new String[]{"El�in id", "Nimi", "Rotu", "Ik�"}, 0);
		table.setModel(model);
		scrollPane.setViewportView(table);
			
	}
	
}
	