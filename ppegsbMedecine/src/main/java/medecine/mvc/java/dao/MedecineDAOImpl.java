package medecine.mvc.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import medecine.mvc.java.model.Medecine;
import medecine.mvc.java.util.DBConnectionUtil;

public class MedecineDAOImpl implements MedecineDAO  {
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	

	public List<Medecine> get() {
		
		List<Medecine> list = null;
		Medecine medecine = null;
		
		try {
			
			list = new ArrayList<Medecine>();
			String sql = "SELECT * FROM medecin";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				medecine= new Medecine();
				medecine.setId(resultSet.getInt("id"));
				medecine.setNom(resultSet.getString("nom"));
				medecine.setPrenom(resultSet.getString("prenom"));
				medecine.setAdress(resultSet.getString("adresse"));
				medecine.setTel(resultSet.getString("tel"));
				medecine.setSpe(resultSet.getString("specialiteComplementaire"));
				medecine.setDepartement(resultSet.getInt("departement"));
				list.add(medecine);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Medecine get(int id) {
		Medecine medecine = null;
		try {
			medecine = new Medecine();
			String sql = "SELECT * FROM medecin where id="+id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				medecine.setId(resultSet.getInt("id"));
				medecine.setNom(resultSet.getString("nom"));
				medecine.setPrenom(resultSet.getString("prenom"));
				medecine.setAdress(resultSet.getString("adresse"));
				medecine.setTel(resultSet.getString("tel"));
				medecine.setSpe(resultSet.getString("specialiteComplementaire"));
				medecine.setDepartement(resultSet.getInt("departement"));
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return medecine;
	}
	
	@Override
	public boolean save(Medecine m) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO medecin(nom, prenom, adress,tel,spe,departement)VALUES"
					+ "('"+m.getNom()+"', '"+m.getPrenom()+"','"+m.getAdress()+"' ,'"+m.getTel()+"','"+m.getSpe()+"' , '"+m.getDepartement()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	
	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM medecin where id="+id;
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(Medecine medecine) {
		boolean flag = false;
		try {
			String sql = "UPDATE medecin SET nom = '"+medecine.getNom()+"', "
					+ "prenom = '"+medecine.getPrenom()+"', adresse = '"+medecine.getAdress()+"' where id="+medecine.getId();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}


}
