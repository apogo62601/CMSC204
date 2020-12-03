public class CourseDBElement implements Comparable{
	private String courseID, roomNum, instructor;
	private int crn, credits;
	

	public CourseDBElement() {
		courseID = null;
		roomNum = null;
		instructor = null;
		crn = 0;
		credits = 0;
	}
	

	public CourseDBElement(String ID, int CRN, int numOfCred, String room, String prof) {
		courseID = ID;
		crn = CRN;
		credits = numOfCred;
		roomNum = room;
		instructor = prof;
	}

	
	public int getCRN() {
		return crn;
	}
	

	public void setCRN(int input) {
		crn = input;
	}
	

	public int hashCode() {
		String code = Integer.toString(crn);
		return code.hashCode();
	}
	

	public int compareTo(CourseDBElement element) {
		return this.compareTo(element);
	}

	public String toString() {
		return "\nCourse: " + courseID + " CRN: " + crn + " Credits: " + credits + " Instructor: " + instructor + " Room: " + roomNum;
	}

}