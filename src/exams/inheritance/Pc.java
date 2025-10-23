package exams.inheritance;

// dětské počítadlo
public class Pc {
    String name;
    int money;

    final int PENALTY = 10_000;

    public Pc(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void mine(){
        System.out.println("Mining memecoin by hand...");
        money += 100;
    }

    public void penalty(){
        System.out.println("complicated calculations...silicon brain hurts... have to pay for surgery");
        money -= PENALTY;
    }

    // TODO: vytvořte toString metodu, který vrátí název počítače a peníze, které se na pc "nacházejí"
}
