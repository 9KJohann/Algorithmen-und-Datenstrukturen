
// Definition of class Rational

public class Rational {
	private int numerator; // Zaehler
	private int denominator; // Nenner

	// Initialize numerator to 0 and denominator to 1
	public Rational() {
		numerator = 0;
		denominator = 1;
	}

	// Initialize numerator part to n and denominator part to 1
	public Rational(int n) {
		numerator = n;
		denominator = 1;
	}

	// Initialize numerator part to n and denominator part to d
	public Rational(int n, int d) {
		assert (d != 0);

		numerator = n;
		denominator = d;
		reduce();
	}

	// Add two Rational numbers
	public Rational sum(Rational right) {
		return new Rational(this.numerator * right.denominator + right.numerator * this.denominator,
				this.denominator * right.denominator);
	}

	// Subtract two Rational numbers
	// return a Rational result object
	public Rational subtract(Rational right) {
		return new Rational(this.numerator * right.denominator - right.numerator * this.denominator,
				this.denominator * right.denominator);
	}

	// Multiply two Rational numbers
	// return a Rational result object
	public Rational multiply(Rational right) {
		return new Rational(this.numerator * right.numerator, this.denominator * right.denominator);
	}

	// Divide two Rational numbers
	// return a Rational result object
	public Rational divide(Rational right) {
		return new Rational(this.numerator * right.denominator, this.denominator * right.numerator);
	}

	// Reduce the fraction
	private void reduce() {
		assert (denominator != 0);
		GGT ggt = new GGT();
		int absNumerator = abs(numerator);
		int absDenominator = abs(denominator);
		int divider = ggt.ggT(max(absNumerator, absDenominator), min(absNumerator, absDenominator));
		numerator /= divider;
		denominator /= divider;
		assert (denominator != 0);
	}

	private int max(int number1, int number2) {
		return number1 > number2 ? number1 : number2;
	}

	private int min(int number1, int number2) {
		return number1 < number2 ? number1 : number2;
	}

	private int abs(int number) {
		return number >= 0 ? number : number * (-1);
	}

	public void toScreen() {
		System.out.println("Wert " + this.toString());
	}

	// Return String representation of a Rational number
	public String toString() {
		return numerator + "/" + denominator;
	}

}