package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Corso c = new Corso (rs.getString("codins"), rs.getInt("crediti") ,rs.getString("nome"), rs.getInt("pd"));
				corsi.add(c);
				
			}
            conn.close();
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {

		final String sql = "SELECT * FROM corso WHERE codins=?";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(String.format(sql, corso));
            st.setString(1, corso.getCodins());
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				corso.setCrediti(rs.getInt("crediti"));
				corso.setNome(rs.getString("nome"));
				corso.setPd(rs.getInt("pd"));
			}

			conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
	
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public void getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}
}
