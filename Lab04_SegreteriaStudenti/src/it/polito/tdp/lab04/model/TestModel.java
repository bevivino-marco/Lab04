package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		Corso c = new Corso ("01NBAPG");
		System.out.println(model.getCorso(c).getNome());
		Studente s = new Studente (154817);
		System.out.println(model.getStudente(s).toString());
//01KSUPG
	}
	

}
