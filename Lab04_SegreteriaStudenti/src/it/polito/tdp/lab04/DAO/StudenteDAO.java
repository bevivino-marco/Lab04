package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;
//simport javafx.scene.control.TextField;

public class StudenteDAO {

	public void getStudente (Studente s) {
		final String sql = "SELECT * FROM studente WHERE matricola=?";

	

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, s.getMatricola());
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

			s.setNome(rs.getString("nome"));
			s.setCognome(rs.getString("cognome"));
			s.setCds(rs.getString("CDS"));
				
			}
            conn.close();
			
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	public List<Corso> cercaCorsi(Studente s) {
		List <Corso> lc = new LinkedList<Corso>();
		final String sql = "SELECT * FROM iscrizione,corso WHERE iscrizione.codins=corso.codins AND matricola=?";

		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, s.getMatricola());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
             
				lc.add(new Corso (rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd")));
			
				
			}
            conn.close();
			
			return lc;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
	}
}
