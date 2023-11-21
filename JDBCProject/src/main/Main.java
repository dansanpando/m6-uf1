package main;

import dao.CandidatesDAO;
import dao.DAOManager;
import dao.PrizesDAO;
import dao.PrizetypeDAO;
import model.Candidate;
import model.Prize;
import model.Prizetype;

public class Main {

	public static void main(String[] args) {
		CandidatesDAO canDAO = DAOManager.getCandidatesDAO();
		PrizetypeDAO priDAO = DAOManager.getPrizetypeDAO();
		PrizesDAO prizesDAO = DAOManager.getPrizesDAO();
		int resultat;

		Prizetype pr1 = new Prizetype(1, "Prize 1", "This is the Prize 1", 1000);
		System.out.println("Afegir un Candidat:");
		Candidate c1 = new Candidate(21, "Raul", "Monmany", "987654321", "quieroquememetanunapesaporelculo@gmail.com");
		Prize p1 = new Prize(11, c1, pr1, 2020);
		// resultat = canDAO.addCandidates(c1);
		// System.out.println("S'han afegit " + resultat + " candidats");
		System.out.println(prizesDAO.getPrizesbyId(1));
		// System.out.println(canDAO.getCandidatesbyId(33, false));

	}

}
