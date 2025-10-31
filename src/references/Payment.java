package references;

public class Payment {
    int toPay;

    public static void main(String[] args) {
        Payment pay1 = new Payment();
        Payment pay2 = new Payment();
        pay1.toPay = 20;
        pay2.toPay = 0;
        pay2.toPay += 15;
        pay1.toPay = pay2.toPay;
        pay2 = pay1;
        pay2.toPay += 17;
        pay1.toPay += 10;
        System.out.println(pay1.toPay);
        System.out.println(pay2.toPay);
    }
}
