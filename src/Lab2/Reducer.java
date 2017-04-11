package Lab2;
public class Reducer {

	public static void main(String args[]) {
		new Reducer();
	}

	public Reducer() {

		Kattio io = new Kattio(System.in, System.out);

		int v = io.getInt();
		int e = io.getInt();
		int m = io.getInt();

		int n = v + 3;
		int s = e + 2;
		int k = m + 2;

		if (k < 3) // minimum 3 actors alltid
			k = 3;

		io.println(n + " " + s + " " + k);

		io.println("1 1");
		io.println("1 2");
		io.println("1 3");

		for (int i = 4; i <= n; ++i) {
			String line = Integer.toString(k - 2);

			for (int j = 3; j <= k; ++j)
				line = line.concat(" " + Integer.toString(j));

			io.println(line);
		}

		io.println("2 1 3");
		io.println("2 2 3");

		for (int i = 3; i <= s; ++i) {

			int a = io.getInt();
			int b = io.getInt();
			io.println("2 " + (a + 3) + " " + (b + 3));
		}

		io.close();

	}
}