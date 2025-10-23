package exams.inheritance;

public class ModernPc extends Pc {

    public ModernPc(String name, int money) {
        super(name, money);
    }

    @Override
    public void mine() {
        System.out.println("Mining memecoin...but faster");
        money += 1_000;
    }

    public void mineEthereum(){
        System.out.println("Mining ethereum.");
        money += 10_000;
    }
}
