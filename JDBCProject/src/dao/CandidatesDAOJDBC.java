package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Candidate;

public class CandidatesDAOJDBC implements CandidatesDAO {

	@Override
	public int addCandidates(Candidate c) {
		Boolean isConnectionOpen = false;
		String sql = "INSERT INTO candidates VALUES (?,?,?,?,?)";
		try {
			isConnectionOpen = GestorConnexions.isConnected();
			Connection conexio = GestorConnexions.obtenirConnexio();
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			sentencia.setInt(1, c.getCandidateId());
			sentencia.setString(2, c.getFirstName());
			sentencia.setString(3, c.getLastName());
			sentencia.setString(4, c.getPhoneNumber());
			sentencia.setString(5, c.getEmail());
			int resultat = sentencia.executeUpdate();
			return resultat;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			if (!isConnectionOpen) {
				GestorConnexions.tancarConnexio();
			}
		}
	}

	@Override
	public Candidate getCandidatesbyId(Integer id, boolean ambPremis) {
		Boolean isConnectionOpen = false;
		String sql = "Select * from candidates where candidateId = ?";
		Candidate c1 = new Candidate();

		try {
			isConnectionOpen = GestorConnexions.isConnected();
			Connection conexio = GestorConnexions.obtenirConnexio();
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			sentencia.setInt(1, id);
			ResultSet resultat = sentencia.executeQuery();
			if (resultat.next()) {
				c1 = new Candidate(resultat.getInt(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (!isConnectionOpen) {
				GestorConnexions.tancarConnexio();
			}
		}
		return c1;
	}

	@Override
	public int updateCandidates(Candidate p) {
		return 0;
	}

	@Override
	public int deleteCandidates(Candidate p) {
		Boolean isConnectionOpen = false;
		String sql = "delete from prizetype where prizeTypeId = ?";
		String deletePrizes = "delete from prizetype where prizeTypeId = ?";
		try {
			isConnectionOpen = GestorConnexions.isConnected();
			Connection conexio = GestorConnexions.obtenirConnexio();
			conexio.setAutoCommit(false);
			try {
				PreparedStatement delete = conexio.prepareStatement(deletePrizes);
				delete.setInt(1, p.getCandidateId());
				delete.executeUpdate();
			} catch (SQLException e) {
				conexio.rollback();
				e.printStackTrace();
				return 0;
			}
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			PreparedStatement delete = conexio.prepareStatement(deletePrizes);
			sentencia.setInt(1, p.getCandidateId());
			delete.setInt(1, p.getCandidateId());
			delete.executeUpdate();
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
	public ArrayList<Candidate> listCandidates(boolean ambPremis) {
		Boolean isConnectionOpen = false;
		String sql = "Select * from candidates";
		ArrayList<Candidate> a1 = new ArrayList<Candidate>();
		Candidate c1 = new Candidate();
		try {
			isConnectionOpen = GestorConnexions.isConnected();
			Connection conexio = GestorConnexions.obtenirConnexio();
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			ResultSet resultat = sentencia.executeQuery();
			while (resultat.next()) {
				c1 = new Candidate(resultat.getInt(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(5));
				a1.add(c1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (!isConnectionOpen) {
				GestorConnexions.tancarConnexio();
			}
		}
		return a1;
	}

}
