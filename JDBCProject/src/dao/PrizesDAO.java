package dao;

import model.Prize;

public interface PrizesDAO {

	public int addPrizes(Prize p);

	public Prize getPrizesbyId(Integer Id);

	public int updatePrizes(Prize p);

	public int deletePrizes(Prize p);

}
