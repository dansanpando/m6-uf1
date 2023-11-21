package model;

public class Prizetype {
	private int prizetypeId;
	private String prizeName;
	private String prizeDescription;
	private double value;

	public Prizetype(int prizetypeId, String prizeName, String prizeDescription, double value) {
		super();
		this.prizetypeId = prizetypeId;
		this.prizeName = prizeName;
		this.prizeDescription = prizeDescription;
		this.value = value;
	}

	public Prizetype() {
		// TODO Auto-generated constructor stub
	}

	public int getPrizetypeId() {
		return prizetypeId;
	}

	public void setPrizetypeId(int prizetypeId) {
		this.prizetypeId = prizetypeId;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public String getPrizeDescription() {
		return prizeDescription;
	}

	public void setPrizeDescription(String prizeDescription) {
		this.prizeDescription = prizeDescription;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Prizetype [prizetypeId=" + prizetypeId + ", prizeName=" + prizeName + ", prizeDescription="
				+ prizeDescription + ", value=" + value + "]";
	}

}
