package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.UtileConnexion;
import entities.Customer;
import entities.Announcement;

public class LeMauvaisCoinServices {
	
	public List<Announcement> getAllAnnouncement()throws SQLException{
		List<Announcement> listAll = new ArrayList<Announcement>();
		Connection con = UtileConnexion.toConnect();				//lance 'se connecter'	
		String query = "	SELECT * FROM Announcements;		";			//description de la query à lancer sur la database
		ResultSet rs = con.createStatement().executeQuery(query);	//exécute la query
		
		while(rs.next() ) {											//récupère les infos de la database
			int id = rs.getInt("id");
			String title = rs.getString("title");
			float price = rs.getFloat("price");
			String type = rs.getString("type");
			String description = rs.getString("description");
			int idCustomer = rs.getInt("id_customer");
			
			listAll.add( new Announcement(id, title, price, type, description, idCustomer) );
		}
		return listAll;
	}
	
	
	public List<Announcement> getAllAnnoucementByType(String typeIn)throws SQLException{
		List<Announcement> listAll = new ArrayList<Announcement>();
		Connection con = UtileConnexion.toConnect();				//lance 'se connecter'	
		String query = "	SELECT * FROM Announcements WHERE type=?;	";			//description de la query à lancer sur la database
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, typeIn);
		ResultSet rs = con.createStatement().executeQuery(query);	//exécute la query
		
		while(rs.next() ) {											//récupère les infos de la database
			int id = rs.getInt("id");
			String title = rs.getString("title");
			float price = rs.getFloat("price");
			String type = rs.getString("type");
			String description = rs.getString("description");
			int idCustomer = rs.getInt("id_customer");
			preparedStatement.close();
			listAll.add( new Announcement(id, title, price, type, description, idCustomer) );
		}
		return listAll;
	}
	
	
	public List<Announcement> getAllAnnoucementByIdCustomer(int idIn)throws SQLException{
		List<Announcement> listAll = new ArrayList<Announcement>();
		Connection con = UtileConnexion.toConnect();				//lance 'se connecter'	
		String query = "	SELECT * FROM Announcements WHERE id_customer=?;	";			//description de la query à lancer sur la database
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, idIn);
		ResultSet rs = con.createStatement().executeQuery(query);	//exécute la query
		while(rs.next() ) {											//récupère les infos de la database
			int id = rs.getInt("id");
			String title = rs.getString("title");
			float price = rs.getFloat("price");
			String type = rs.getString("type");
			String description = rs.getString("description");
			int idCustomer = rs.getInt("id_customer");
			preparedStatement.close();
			listAll.add( new Announcement(id, title, price, type, description, idCustomer) );
		}
		return listAll;
	}
	
	
	public Announcement getAnnouncementById(int idIn) throws SQLException{
		Connection con = UtileConnexion.toConnect();
		String query = "	SELECT * FROM Announcements WHERE id=?;		";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, idIn);	
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next() ) {
			String title = rs.getString("title");
			float price = rs.getFloat("price");
			String type = rs.getString("type");
			String description = rs.getString("description");
			int idCustomer = rs.getInt("idCustomer");
			preparedStatement.close();
			con.close();
			//System.out.println("connection close");
			return new Announcement(idIn, title, price, type, description, idCustomer); //on a déjà l'ID dans la requête
		}
		return null;
	}
	
	
	public void addAnnouncement(Announcement ann)throws SQLException {
		Connection con = UtileConnexion.toConnect();
		String query = "	INSERT INTO Announcements (title, price, type, description, idCustomer) VALUES (?, ?, ?, ?, ?)	";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, ann.getTitle());
		preparedStatement.setFloat(2, ann.getPrice());
		preparedStatement.setString(3, ann.getType());
		preparedStatement.setString(4, ann.getDescription());
		preparedStatement.setInt(5, ann.getIdCustomer());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		con.close();
		//System.out.println("connection close");
	}
	
	
	public void updateAnnouncement(Announcement ann)throws SQLException {
		Connection con = UtileConnexion.toConnect();
		String query = "	UPDATE Announcements SET title= ?, price=?, type=?, description=? WHERE id=?;	";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, ann.getTitle());
		preparedStatement.setFloat(2, ann.getPrice());
		preparedStatement.setString(3, ann.getType());
		preparedStatement.setString(4, ann.getDescription());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		con.close();
		//System.out.println("connection close");
	}
	
	
	public void deleteAnnouncement(int idIn)throws SQLException {
		Connection con = UtileConnexion.toConnect();
		String query = "	DELETE FROM Announcements WHERE id=?;	";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, idIn);	
		preparedStatement.executeUpdate();
		preparedStatement.close();
		con.close();
		System.out.println("connection close");
	}
	
	
	
	
	
	public void addCustomer(Customer cust)throws SQLException {
		Connection con = UtileConnexion.toConnect();
		String query = "	INSERT INTO Customers (pseudonyme, first_name, last_name, email, password) VALUES (?, ?, ?, ?, ?)	";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, cust.getPseudonyme());
		preparedStatement.setString(2, cust.getFirstName());
		preparedStatement.setString(3, cust.getLastName());
		preparedStatement.setString(4, cust.getEmail());
		preparedStatement.setString(5, cust.getPassword());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		con.close();
		//System.out.println("connection close");
	}
	
	public String getCustomerPseudonymeById(int idIn) throws SQLException{
		Connection con = UtileConnexion.toConnect();
		String query = "	SELECT * FROM Customers WHERE id=?;		";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, idIn);	
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next() ) {
			String pseudonyme = rs.getString("pseudonyme");
			preparedStatement.close();
			con.close();
			//System.out.println("connection close");
			return pseudonyme;
		}
		return null;
	}
	
	public boolean IsCustomerInfoValid(String emailIn, String passwordIn) throws SQLException{
		Connection con = UtileConnexion.toConnect();
		String query = "	SELECT * FROM Customers WHERE email=? and password=?;		";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, emailIn);	
		preparedStatement.setString(2, passwordIn);	
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()) {
			preparedStatement.close();
			con.close();
			return true;
		}else {
			preparedStatement.close();
			con.close();
			return false;
		}
	}
	
	
	public String getCustomerPseudonymeByEmail(String emailIn) throws SQLException{
		Connection con = UtileConnexion.toConnect();
		String query = "	SELECT * FROM Customers WHERE email=?;		";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, emailIn);	
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next() ) {
			String pseudonyme = rs.getString("pseudonyme");
			preparedStatement.close();
			con.close();
			//System.out.println("connection close");
			return pseudonyme;
		}
		return null;
	}
	
	
	public int getCustomerIdByEmail(String emailIn) throws SQLException{
		Connection con = UtileConnexion.toConnect();
		String query = "	SELECT * FROM Customers WHERE email=?;		";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, emailIn);	
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next() ) {
			int id = rs.getInt("id");
			preparedStatement.close();
			con.close();
			//System.out.println("connection close");
			return id;
		}
		return -1;
	}
	
	
	
}
