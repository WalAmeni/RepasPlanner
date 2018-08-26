package org.repasplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.repasplanner.dao.init.TableConnection;
import org.repasplanner.model.Ingredient;
import org.repasplanner.model.TypeIngredient;

public class IngredientRepository {
	private static IngredientRepository instance;

	private IngredientRepository() {

	}

	public static IngredientRepository getInstance() {
		if (instance == null) {
			instance = new IngredientRepository();
		}
		return instance;
	}

	public void insert(String nomIngredient, TypeIngredient type, double quantite, String unite, int idRecette) {

		String sql = "INSERT INTO Ingredient (nomIngredient ,type , quantite, unite,idRecette) " + "VALUES (?,?,?,?,?)";
		try (Connection conn = TableConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nomIngredient);
			pstmt.setString(2, type.name());
			pstmt.setDouble(3, quantite);
			pstmt.setString(4, unite);
			pstmt.setInt(5, idRecette);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Ingredient> findIngredientByIdRecette(int idRecette) {
		String sql = "select * from ingredient where idRecette = ?";
		List<Ingredient> ingredients = new ArrayList<>();

		try (Connection conn = TableConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, idRecette);
			ResultSet rs = pstmt.executeQuery();

			// loop through the result set
			while (rs.next()) {
				Ingredient i = new Ingredient();
				i.setNom(rs.getString("nomIngredient"));
				i.setQuantite(rs.getDouble("quantite"));
				i.setUnite(rs.getString("unite"));
				i.setType(TypeIngredient.getByName(rs.getString("type")));
				ingredients.add(i);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		ingredients.forEach(e -> System.out.println(e));
		return ingredients;
	}

	public List<Ingredient> findIngredientByNomRecette(String nomRecette) {
		// TODO
//		String sqlRequest = "select * from ingredient where nomRecette = ?";
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		// Ingredient i = new Ingredient();
		// i.setNom((String) e.get("nomIngredient"));
		// i.setQuantite((double) e.get("quantite"));
		// i.setUnite((String) e.get("unite"));
		// i.setType(TypeIngredient.getByName((String) e.get("type")));
		// ingredients.add(i);
		return ingredients;
	}
}