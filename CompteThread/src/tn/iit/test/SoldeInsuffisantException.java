package tn.iit.test;

public class SoldeInsuffisantException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SoldeInsuffisantException (String s) {
		super(s);
	}
	
	public SoldeInsuffisantException () {
		super("Solde insuffisant");
	}
	
	
}
