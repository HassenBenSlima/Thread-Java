package pizzapizza2;

import java.util.Random;

public class Student extends Thread {

	StudyGroup studyGroup = new StudyGroup();
	private Random r = new Random();

	public Student(StudyGroup sg) {
		this.studyGroup = sg;
	}

	@Override
	public void run() {
		while (true) {
			try {
				studyGroup.beginStudying();
				sleep(r.nextInt(10000)); // Wait till pizza slice finishes
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}