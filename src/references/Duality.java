package references;

class      Duality {
    int number;

    void work1() {
        this.number = 5;
        System.out.println(this.number);
    }
    void work2() {
        this.number += 37;
        System.out.println(this.number);
    }
    public static void main(String[] args) {
        Duality[] a1 = new Duality[1];
        Duality[] a2 = new Duality[1];
        a1[0] = new Duality();
        a2[0] = a1[0];
        a1[0].work1();
        a2[0].work1();
        a1[0].work2();
        a2[0].work2();
        System.out.println(a1[0].number);
        System.out.println(a2[0].number);
    }
}