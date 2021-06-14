package ltda.corporation.hugo.health.service;

public class laudoNuloException extends Exception {
	private String message;

	public laudoNuloException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
	
	
}
