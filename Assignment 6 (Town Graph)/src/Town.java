
public class Town implements Comparable<Town>{
	
	protected String name = "";
	protected java.util.Set<Town> towns = new java.util.HashSet<Town>();
	protected int weight = Integer.MAX_VALUE;
	protected Town previous = null;

	public Town(String n) {

		this.name = n;
	}


	public Town(Town t) {

		this.name = t.name;
		this.weight = t.weight;
		this.towns = t.towns;
		this.previous = t.previous;
	}

	
	public void reset() {
		this.weight = Integer.MAX_VALUE;
		this.previous = null;
	}
	

	public String getName() {
		return this.name;
	}
	

	public int hashCode() {
		return this.name.hashCode();
	}
	

	public String toString() {
		return this.getName();
	}


	public boolean equals(Object t) {
		return t == this || this.name.toLowerCase().equals(((Town) t).name.toLowerCase());
	}
	

	public int compareTo(Town t) {
		return this.name.compareTo(t.name);
	}
}
