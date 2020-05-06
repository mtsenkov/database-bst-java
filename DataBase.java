//Matthew Tsenkov
//COSC 311
//Project 3

public class DataBase {
	private DataBaseRecord[] data;
	private Index idIter, firstIter, lastIter;
	private int next;
	
	//Constructor for Database
	public DataBase() {
		next = 0;
		data = new DataBaseRecord[100];
		idIter = new Index();
		firstIter = new Index();
		lastIter = new Index();
	}

	//insert in database
	public void insert(String id, String firstName, String lastName) {
		idIter.insert(id, next);
		firstIter.insert(firstName, next);
		lastIter.insert(lastName, next);
		data[next++] = new DataBaseRecord(id, firstName, lastName);
	}
	
	//Finds the IndexRecord that we are looking for. If the indexRecord exists we take it's position
	//if the indexRecord doesnt exist, we set pos to -1 and print out Key not found.
	//The reason for the -1 return is so that we can use this data in other methods, such as delete, insert
	public void find(String key) {
		IndexRecord recToDelete = idIter.find(key);
		int pos = 0;
		if (recToDelete == null)
			pos = -1;
		else	
			pos = recToDelete.getPos();
		if (pos != -1)
			System.out.println(data[pos]);
		else
			System.out.println("Key not found.");
	}

	//This is the same find method but without the print statement. I use this method when inserting
	//from the file, to clean the spam of Key not found since 29 of the records have free key and only 2
	//are duplicated.
	public int findIt(String key) {
		IndexRecord recToDelete = idIter.find(key);
		int pos = 0;
		if (recToDelete == null)
			pos = -1;
		else	
			pos = recToDelete.getPos();
		return pos;
	}
	
	//Using addIt method to insert at proper position and check if record exists. If it does exist
	//we print out that the entry id is not allowed.
	public void addIt(String id, String firstName, String lastName) {
		if (next == 0) {
			insert(id, firstName, lastName);
		} else if (findIt(id) == -1) {
			insert(id, firstName, lastName);
		} else
			System.out.println("Entry " + id + " not allowed. You cannot add a non-unique ID.");
	}

	//We find the position at which we want to delete. Then we sever the links from the Binary Search Tree
	//and we print out Successfully deleted record if all 3 links are severed properly.
	//If the record we try to delete is not found we get a print out message.
	
	public void delete(String key) {
		int pos = findIt(key);
		if (pos != -1) {
			String first = data[pos].getFirst();
			String last = data[pos].getLast();
			if (firstIter.delete(first) == true && lastIter.delete(last) == true && idIter.delete(key) == true) {
				System.out.println("Successfully deleted record.");
			} else {
				System.out.println("Record not deleted.");
			}
		} else {
			System.out.println("Record not found in database.");
		}
	}
	
	public void inOrderAscending(IndexRecord x) {
		if (x != null) {
			inOrderAscending(x.getLeft());
			System.out.println(data[x.getPos()]);
			inOrderAscending(x.getRight());
		}
	}
	
	public void inOrderDescending(IndexRecord x) {
		if (x != null) {
			inOrderDescending(x.getRight());
			System.out.println(data[x.getPos()]);
			inOrderDescending(x.getLeft());
		}
	}

	public void printIdAscending() {
		inOrderAscending(idIter.getTop());
	}

	public void printFirstAscending() {
		inOrderAscending(firstIter.getTop());
	}

	public void printLastAscending() {
		inOrderAscending(lastIter.getTop());
	}

	public void printIdDescending() {
		inOrderDescending(idIter.getTop());
	}

	public void printFirstDescending() {
		inOrderDescending(firstIter.getTop());
	}

	public void printLastDescending() {
		inOrderDescending(lastIter.getTop());
	}
}