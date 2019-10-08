package LecteursRedacteurs;

public class Test {

	public static void main(String args[]) {
		LectRed LR = new LectRed();
		Lecteur L1 = new Lecteur(LR);
		L1.start();
		Redacteur R1 = new Redacteur(LR);
		R1.start();
	}
}