public class Road implements Comparable<Road> {

	protected Town source = null;
	protected Town destination = null;
	protected String name = "";
	protected int weight = 0;
	

	public Road(Town s, Town d, int w, String n) {

		this.source = s;
		this.destination = d;
		this.weight = w;
		this.name = n;
	}


	public Road(Town s, Town d, String n) {

		this.source = s;
		this.destination = d;
		this.weight = 1;
		this.name = n;
	}
	

	public String getName() {
		return this.name;
	}
	

	public Town getSource() {
		return this.source;
	}
	
	
	public void setSource(Town source) {
		this.source = source;
	}

	
	public Town getDestination() {
		return this.destination;
	}
	
	
	public void setDestination(Town destination) {
		this.destination = destination;
	}
	

	public int getWeight() {
		return this.weight;
	}
	
	
	public void setDegrees(int degrees) {
		this.weight = degrees;
	}
	

	public int hashCode() {
		return this.name.hashCode();
	}
	

	public String toString() {
		return this.name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	

	public boolean contains(Town t) {
		return this.source.equals(t) || this.destination.equals(t);
	}

	public boolean equals(Object r) {	
		boolean smatch = this.source.equals(((Road) r).source) || this.source.equals(((Road) r).destination);
		boolean dmatch = this.destination.equals(((Road) r).source) || this.destination.equals(((Road) r).destination);
		boolean result = r == this || (smatch && dmatch);

		return result;
	}
	
	public int compareTo(Road r) {
		return this.getWeight() - r.getWeight();
	}
}