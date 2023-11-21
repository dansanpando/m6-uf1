package dao;

import model.Prizetype;

public interface PrizetypeDAO {

	public int addPrizetype(Prizetype p);

	public Prizetype getPricetypeById(Integer Id);

	public int updatePrizetype(Prizetype p);

	public int deletePrizetype(Prizetype p);
}
