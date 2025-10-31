package references;

public class Aus {

    static int doSomething(int choice){
        choice = 3;
        return choice;
    }
    public static void main(String[] args) {
        String safeWord = "";
        int choice = 0;
        choice = doSomething(choice);
        switch (choice){
            case 1:
                safeWord = "Losgehts";
                break;
            case 2:
                safeWord = "Why would you even choose this!?";
                break;
            case 3:
                safeWord = "FLÜGGÅӘNKб€ČHIŒßØLĮÊN";
                break;
        }
        System.out.println(safeWord);
    }
}
