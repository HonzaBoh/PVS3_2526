package references;

public class Recursion {
	public static void main(String[] args) {
		System.out.println(recursive(2));
	}

	static int recursive(int p) {
  		System.out.println(p);
		if (p<=0)
			return 1;
		int r1 = recursive(p-1);
		int r2 = recursive(p-3);
		return r1 + 2 * r2;
	}
}