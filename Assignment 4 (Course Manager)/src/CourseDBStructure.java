import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	protected LinkedList<CourseDBElement>[] hashTable;
	

	public CourseDBStructure(int size) {
		hashTable = new LinkedList[size];
	}
	

	public CourseDBStructure(String testing, int size) {
		hashTable = new LinkedList[size];
	}
	
	public void add(CourseDBElement element) {
		int index = element.hashCode()%hashTable.length;
		if (hashTable[index] == null) {
			LinkedList<CourseDBElement> input = new LinkedList<CourseDBElement>();
			input.add(element);
			hashTable[index] = input;
		}else {
			hashTable[index].add(element);
		}
	}

	
	public CourseDBElement get(int crn) throws IOException {
		String code = Integer.toString(crn);
		int index = code.hashCode()%hashTable.length;
		if (hashTable[index]==null) {
			throw new IOException();
		}else {
			for (int i = 0; i < hashTable[index].size(); i++) {
				if (hashTable[index].get(i).getCRN()==crn) {
					return hashTable[index].get(i);
				}
			}
			throw new IOException();
		}
	}

	
	public int getTableSize() {
		return hashTable.length;
	}

}