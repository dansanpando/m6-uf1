package dao;

public class DAOManager {
	private static PrizetypeDAO prizetypeDAO;
	private static PrizesDAO prizesDAO;
	private static CandidatesDAO candidatesDAO;

	public static PrizetypeDAO getPrizetypeDAO() {
		if (prizetypeDAO == null) {
			prizetypeDAO = new PrizetypeDAOJDBC();
		}
		return prizetypeDAO;
	}

	public static PrizesDAO getPrizesDAO() {
		if (prizesDAO == null) {
			prizesDAO = new PrizesDAOJDBC();
		}
		return prizesDAO;
	}

	public static CandidatesDAO getCandidatesDAO() {
		if (candidatesDAO == null) {
			candidatesDAO = new CandidatesDAOJDBC();
		}
		return candidatesDAO;
	}

}
