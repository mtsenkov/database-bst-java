// Matthew Tsenkov
// COSC 311
// Project 3

public class DataBaseRecord {
	
	private String ID;
	private String first;
	private String last;

	DataBaseRecord(String a, String b, String c) {
		ID = new String(a);
		first = new String(b);
		last = new String(c);
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void getLast(String last) {
		this.last = last;
	}

	public String toString() {
		return ID + "\t\t" + first + "\t\t" + last;
	}
}