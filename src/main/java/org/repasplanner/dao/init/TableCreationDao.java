/**
 * 
 */
package org.repasplanner.dao.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.repasplanner.dao.DaoProperties;

/**
 * @author Ameni
 *
 */
public class TableCreationDao {

	private final static Logger LOGGER = Logger.getLogger(TableCreationDao.class);

	private TableCreationDao() {
	}

	public static void createAllTables() {
		createRecetteTable();
		createIngredientTable();
	}

	private static void createIngredientTable() {
		String sql = "CREATE TABLE IF NOT EXISTS ingredient ( nomIngredient varchar(255) not null,"
				+ "  type varchar(255) not null," + " quantite double not null," + " unite varchar(255) not null,"
				+ "idRecette integer not null);";
		createTable(sql, "Ingredient");
	}

	public static void createRecetteTable() {
		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS recette "
				+ "( id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nom varchar(255) not null, "
				+ "tempsPreparation varchar(255) , "
				+ "description varchar(2048) , "
				+ "nombrePersonne integer not null);";
		createTable(sql,"Recette");
	}

	private static void createTable(String sql, String tableName) {
		try (Connection conn = DriverManager.getConnection(DaoProperties.DB_URL);
				Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			LOGGER.info(tableName +" table is created");
		} catch (SQLException e) {
			LOGGER.error("Cannot create table " + tableName, e);
		}
	}

	/*
	 * create table recette ( id integer not null AUTO_INCREMENT, nom
	 * varchar(255) not null, tempsPreparation varchar(255) , description
	 * varchar(2048) , nombrePersonne integer not null, primary key(id)
	 * 
	 * );
	 * 
	 * create table ingredient ( nomIngredient varchar(255) not null, type
	 * varchar(255) not null, quantite double not null, unite varchar(255) not
	 * null, idRecette integer not null );
	 */
}
