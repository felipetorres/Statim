package optimizer;

public class Gene {

	private int info;
	private boolean special;
	
	public Gene(int info, boolean special) {
		this.info = info;
		this.special = special;
	}	
	
	public int getInfo() {
		return info;
	}
	
	public boolean isSpecial() {
		return special;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gene other = (Gene) obj;
		if (info != other.info)
			return false;
		if (special != other.special)
			return false;
		return true;
	}
}
