package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;
import javafx.scene.control.TextField;

public class Model {
	CorsoDAO daoc = new CorsoDAO();
	StudenteDAO daos= new StudenteDAO();
	
	public List<Corso> getTuttiCorsi(){
		
		return daoc.getTuttiICorsi();
	}
	
	public Corso getCorso (Corso c) {
		//return dao.getCorso(nomeCorso);
		daoc.getCorso(c);
		return c;
	}
	public Studente getStudente(Studente s) {
		daos.getStudente(s);
		return s;
		}
	public List<Studente> getStudentiIscritti(Corso c){
		return daoc.getStudentiIscrittiAlCorso(c);
	}

	public List<Corso> cercaCorsiStudente(int m) {
		// TODO Auto-generated method stub
		Studente s = new Studente (m);
		return daos.cercaCorsi(s);
	}
}
