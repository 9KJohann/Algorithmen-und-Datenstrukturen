public class GGT {
	public static void main(String[] args) {
		GGT ggt = new GGT();

		System.out.println(ggt.ggT(2021, 1978));

		System.out.println(ggt.ggTOhneRestBeiDivsion(2021, 1978));
	}

	private void checkInput(int a, int b) {
		if (!(a >= 0))
			throw new IllegalArgumentException("A muss eine positive Zahl sein!");
		if (!(b >= 0))
			throw new IllegalArgumentException("B muss eine positive Zahl sein!");
		if (!(a >= b))
			throw new IllegalArgumentException("A muss größer als B sein!");
	}

	private int restBeiDivision(int a, int b) {
		checkInput(a, b);

		while (a >= b)
			a = a - b;

		return a;
	}

	public int ggT(int a, int b) {
		checkInput(a, b);

		while (true) {
			int rest = restBeiDivision(a, b);
			a = b;
			b = rest;
			if (rest == 0)
				break;
		}

		return a;
	}

	public int ggTOhneRestBeiDivsion(int a, int b) {
		checkInput(a, b);

		while (true) {
			int rest = a % b;
			a = b;
			b = rest;
			if (rest == 0)
				break;
		}

		return a;
	}
}