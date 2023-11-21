package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Prizetype;

public class PrizetypeDAOJDBC implements PrizetypeDAO {

	@Override
	public int addPrizetype(Prizetype p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Prizetype getPricetypeById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePrizetype(Prizetype p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePrizetype(Prizetype p) {
		Boolean isConnectionOpen = false;
		String sql = "delete from prizetype where prizeTypeId = ?";
		String deletePrizes = "delete from prizetype where prizeTypeId = ?";
		try {
			isConnectionOpen = GestorConnexions.isConnected();
			Connection conexio = GestorConnexions.obtenirConnexio();
			PreparedStatement sentencia = conexio.prepareStatement(sql);
			PreparedStatement delete = conexio.prepareStatement(deletePrizes);
			sentencia.setInt(1, p.getPrizetypeId());
			delete.setInt(1, p.getPrizetypeId());
			delete.executeUpdate();
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

}
