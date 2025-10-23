package exams.inheritance;

public class QuantumPc extends ModernPc{

    final static int EXPERIMENTAL_BONUS = 50_000;

    public QuantumPc(String name, int money) {
        super(name, money);
        money += EXPERIMENTAL_BONUS;
    }

    @Override
    public void mine() {
        System.out.println("Mining very very fast");
        money += 10_000;
    }

    public void mineQuantumCoin(){
        System.out.println("Mining quantum coin");
        money += 100_000;
    }
}
