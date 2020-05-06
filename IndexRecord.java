// Matthew Tsenkov
// COSC 311
// Project 3

public class IndexRecord {
	private String key;
	private int pos;
	private IndexRecord left;
	private IndexRecord right;

	public IndexRecord(String key) {
		this.key = key;
		left = null;
		right = null;
	}

	public IndexRecord(String key, int pos) {
		this.key = key;
		this.pos = pos;
		left = null;
		right = null;
	}


	public void setLeft(IndexRecord otherNode) {
		left = otherNode;
	}

	public IndexRecord getLeft() {
		return left;
	}

	public void setRight(IndexRecord otherNode) {
		right = otherNode;
	}

	public IndexRecord getRight() {
		return right;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int compareTo(IndexRecord other) {
		return key.compareTo(other.key);
	}

	public String toString() {
		return "key: " + key + "\t\tpos: " + pos;
	}

}
