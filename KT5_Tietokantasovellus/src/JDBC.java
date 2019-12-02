import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JDBC {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7313943";
	static final String USER ="sql7313943";
	static final String PASS ="epas1PTZyg";
	
	

	public static void tallennaEl‰in(El‰in elukka) {

		String el‰inNimi = elukka.getEl‰inNimi();
		String el‰inRotu = elukka.getEl‰inRotu();
		String el‰inIk‰ = elukka.getEl‰inIk‰();

		Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to database...");

			// Luodaan yhteys tietokantaan
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// SQL Lausekkeen esittely, k‰ytet‰‰n ? muuttuvien tietojen kohdalla
			String sql = "INSERT INTO El‰in (El‰inID, Nimi, Rotu, Ik‰) values (?,?,?,?)";

			// T‰ydennet‰‰n SQL-lauseisiin puuttuvat muuttujat
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, null);
			preparedStmt.setString(2, el‰inNimi);
			preparedStmt.setString(3, el‰inRotu);
			preparedStmt.setString(4, el‰inIk‰);

			// Suorittaa SQL lauseen

			preparedStmt.execute();

			System.out.println("Saving data...");

		} catch (SQLException se) {
			// K‰sitell‰n tietokantavirheet
			se.printStackTrace();
		} catch (Exception e) {
			// Muut virheet
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}// end main

	public static void lataaEl‰imet() {

		Connection conn = null;
		Statement stmt = null;
		try {

			// Luodaan yhteys
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Haetaan dataa...");

			// Suoritetaan SQL kysely
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM El‰in");
			
			
			DefaultTableModel model = new DefaultTableModel(new String[]{"El‰inID", "Nimi", "Rotu", "Ik‰"}, 0);

			// K‰yd‰‰n l‰pi tulosjoukko silmukassa
			while (rs.next()){
				 System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
				 model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
				 
				 kenneli.table.setModel(model);
				    

			}
			// Otetaan mahdolliset virheet kiinni
		} catch (SQLException se) {
			 
			se.printStackTrace();
		} catch (Exception e) {
			 
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	 
	}// end main
	
	public static void poistaEl‰imet() {
		//Katsoo mik‰ on valittu ja mik‰ sen el‰imen id on
	   DefaultTableModel model = (DefaultTableModel) kenneli.table.getModel();
	   int row = kenneli.table.getSelectedRow();
	   String value = model.getValueAt(row, 0).toString();
	   
	   Connection conn = null;
		Statement stmt = null;
		try {

			// Luodaan yhteys
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Haetaan dataa...");

			// Suoritetaan SQL kysely
			stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM El‰in WHERE El‰inID =" +value);					
					while (rs.next()){
						JOptionPane.showMessageDialog(kenneli.contentPane, "Poistettu seuraava rivi: " + rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
						 System.out.println("Poistettu seuraava rivi: " + rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
				 
					}
			stmt.executeUpdate("DELETE FROM El‰in WHERE El‰inID = "+value);
									    						   					     														
			
			// Otetaan mahdolliset virheet kiinni
		} catch (SQLException se) {
			 
			se.printStackTrace();
		} catch (Exception e) {
			 
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	 
	}// end main		
}




