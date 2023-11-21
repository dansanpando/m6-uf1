package model;

public class Prize {
	private int prizeId;
	private Candidate candidateId;
	private Prizetype prizetypeId;
	private int year;

	public Prize(int prizeId, Candidate candidateId, Prizetype prizetypeId, int year) {
		super();
		this.prizeId = prizeId;
		this.candidateId = candidateId;
		this.prizetypeId = prizetypeId;
		this.year = year;
	}

	public Prize() {
		// TODO Auto-generated constructor stub
	}

	public int getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(int prizeId) {
		this.prizeId = prizeId;
	}

	public Candidate getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Candidate candidateId) {
		this.candidateId = candidateId;
	}

	public Prizetype getPrizetypeId() {
		return prizetypeId;
	}

	public void setPrizetypeId(Prizetype prizetypeId) {
		this.prizetypeId = prizetypeId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Prize [prizeId=" + prizeId + ", candidateId=" + candidateId + ", prizetypeId=" + prizetypeId + ", year="
				+ year + "]";
	}

}
