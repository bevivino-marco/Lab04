package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		Corso c = model.getCorso("Ingegneria della qualit�");
		System.out.println(c.getNome());

	}

}
