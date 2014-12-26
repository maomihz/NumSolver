
public class Combination {
	private byte[] numbers = new byte[4]; //the number combination are held by a byte array
	//The use of number array ensures comparison handy.
	
	
	// You can use String or numbers to construct the object. 
	// Wrong format will result in IllegalArgumentException thrown. 
	// Combination is four digit number, no repetitive digits. 
	public Combination() {
		this(1357); //Default combination is "1357"
	}
	public Combination(int number) {
		if (number >= 1000 && number <= 9999) {
			numbers[0] = (byte)(number / 1000);
			numbers[1] = (byte)((number % 1000) / 100);
			numbers[2] = (byte)((number % 100) / 10);
			numbers[3] = (byte)((number % 10));
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public Combination(String number) {
		if (number.length() != 4) throw new IllegalArgumentException();
		else
			try {
				for (int i=0;i<4;i++) {
					numbers[i] = (byte)Integer.parseInt(number.substring(i, i+1)); //Convert each character into string
				}
			}catch(NumberFormatException e) {
				throw new IllegalArgumentException();
			}
	}
	
	private boolean checkValid() {
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				if (i != j && getDigit(i) == getDigit(j)) {
					return false;
				}
			}
			if (getDigit(i) == 0) return false;
		}
		return true;
	}
	
	public int getDigit(int index) {
		return (int)numbers[index];
	}
	
	public Pattern matches(Combination correctAnswer) {		
		int crt = 0;
		int mch = 0;
		
		for (int i=0;i<4;i++) {
			if (correctAnswer.getDigit(i) == numbers[i]) crt++;
		}

		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				if (i != j && correctAnswer.getDigit(j) == numbers[i]){
					mch++;
					break;
				}
			}
		}
		return new Pattern(crt,mch,4-crt-mch);

	}
	
	
	public String toString() {
		return String.format("%d %d %d %d", numbers[0], numbers[1], numbers[2], numbers[3]);
	}
	
	public static Combination randComb() {
		Combination cb;
		do {
			cb = new Combination((int)(Math.random() * 9000) + 1000);
		} while(!cb.checkValid()); //loop until is valid
		return cb;
	}
}
