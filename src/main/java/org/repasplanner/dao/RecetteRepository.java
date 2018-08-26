package org.repasplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.repasplanner.dao.init.TableConnection;
import org.repasplanner.model.Recette;

import com.google.common.collect.Lists;

public class RecetteRepository {

	private static RecetteRepository instance;

	private RecetteRepository() {

	}

	public static RecetteRepository getInstance() {
		if (instance == null) {
			instance = new RecetteRepository();
		}
		return instance;
	}

	public void insert(String nom, String tempsPreparation, String description, int nombrePersonne) {
		String sql = "INSERT INTO Recette (nom, tempsPreparation, description, nombrePersonne) " + "VALUES (?,?,?,?)";
		try (Connection conn = TableConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nom);
			pstmt.setString(2, tempsPreparation);
			pstmt.setString(3, description);
			pstmt.setInt(4, nombrePersonne);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Recette> findAll() {
		String sql = "SELECT * FROM recette";
		try (Connection conn = TableConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getString("nom") + "\t" + rs.getString("tempsPreparation") + "\t"
						+ rs.getString("description") + "\t" + rs.getInt("nombrePersonne"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return Lists.newArrayList();
	}

	public List<Recette> getRecetteByNom(String nom) {
		// TODO
		// String sqlRequest = "select * from recette where nomRecette = ?" ;
		return Lists.newArrayList();
	}

}
