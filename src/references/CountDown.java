package references;

class CountDown {
    int x;

    public static void main(String[] args) {
        CountDown mc1 = new CountDown();
		CountDown mc2 = new CountDown();
		mc1.x = 1;
		mc2.x = 2;
		CountDown mc3 = mc2;
		mc1.x += 3;
		mc2.x += 4;
		mc3.x += 5;
		mc3.x = mc1.x;
		mc3 = mc2;
		mc2 = mc2;
		mc1.x += 6;
		mc2.x += 7;
		mc3.x += 8;
		System.out.println(mc1.x);
		System.out.println(mc2.x);
		System.out.println(mc3.x);
    }
}