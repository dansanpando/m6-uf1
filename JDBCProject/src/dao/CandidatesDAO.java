package dao;

import java.util.ArrayList;

import model.Candidate;

public interface CandidatesDAO {

	public int addCandidates(Candidate c);

	public Candidate getCandidatesbyId(Integer Id, boolean ambPremis);

	public int updateCandidates(Candidate p);

	public int deleteCandidates(Candidate p);

	public ArrayList<Candidate> listCandidates(boolean ambPremis);

}
