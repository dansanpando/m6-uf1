package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Candidate;
import model.Prize;
import model.Prizetype;

public class PrizesDAOJDBC implements PrizesDAO {

	@Override
	public int addPrizes(Prize p) {
		Boolean isConnectionOpen = false;
		String sql = "INSERT INTO prizes VALUES (?,?,?,?)";

		try {
			isConnectionOpen = GestorConnexions.isConnected();
			Connection conexio = GestorConnexions.obtenirConnexio();
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			sentencia.setInt(1, p.getPrizeId());
			sentencia.setInt(2, p.getCandidateId().getCandidateId());
			sentencia.setInt(3, p.getPrizetypeId().getPrizetypeId());
			sentencia.setInt(4, p.getYear());
			int resultat = sentencia.executeUpdate();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (!isConnectionOpen) {
				GestorConnexions.tancarConnexio();
			}
		}
	}

	@Override
	public Prize getPrizesbyId(Integer id) {
		CandidatesDAO canDAO = DAOManager.getCandidatesDAO();
		PrizetypeDAO priDAO = DAOManager.getPrizetypeDAO();
		Boolean isConnectionOpen = false;
		String sql = "Select * from prizes where candidateId = ?";
		Prize p1 = new Prize();
		Candidate c1 = new Candidate();
		Prizetype pt1 = new Prizetype();

		try {
			isConnectionOpen = GestorConnexions.isConnected();
			Connection conexio = GestorConnexions.obtenirConnexio();
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			sentencia.setInt(1, id);
			ResultSet resultat = sentencia.executeQuery();
			if (resultat.next()) {
				c1 = canDAO.getCandidatesbyId(resultat.getInt(2), false);
				pt1 = priDAO.getPricetypeById(resultat.getInt(2));
				p1 = new Prize(resultat.getInt(1), c1, pt1, resultat.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p1;
	}

	@Override
	public int updatePrizes(Prize p) {
		Boolean isConnectionOpen = false;
		String sql = "UPDATE prizes SET candidateId = ?, prizeTypeId = ?, Year = ? WHERE prizeId = ?";
		try {
			isConnectionOpen = GestorConnexions.isConnected();
			Connection conexio = GestorConnexions.obtenirConnexio();
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			sentencia.setInt(1, p.getCandidateId().getCandidateId());
			sentencia.setInt(2, p.getPrizetypeId().getPrizetypeId());
			sentencia.setInt(3, p.getYear());
			sentencia.setInt(4, p.getPrizeId());
			int resultat = sentencia.executeUpdate();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (!isConnectionOpen) {
				GestorConnexions.tancarConnexio();
			}
		}
	}

	@Override
	public int deletePrizes(Prize p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
