package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private final Scanner sc = new Scanner(System.in);
    private int cups;
    private int water = 400;
    private int coffeeBeans = 120;
    private int milk = 540;
    private int money = 550;
    private int disposableCups = 9;

    public static void main(String[] args) {
       CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (true) {
           coffeeMachine.menu();
       }
    }

    public void addIngredient() {
        System.out.println("Write how many ml of water you want to add:");
        water += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many ml of milk you want to add:");
        milk += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many disposable cups you want to add:");
        disposableCups += Integer.parseInt(sc.nextLine());
    }

    public String changeInventory(int cups, int coffeePerCup, int milkPerCup, int waterPerCup, int price) {
        String prompt = "";
        if(coffeeBeans - coffeePerCup < 0) {
            prompt = "Sorry, not enough coffee!";

        } else if (milk - milkPerCup < 0)  {
            prompt = "Sorry, not enough milk!";
        } else if (water - waterPerCup < 0) {
            prompt = "Sorry, not enough water!";
        } else if (disposableCups - cups < 0) {
            prompt = "Sorry, not enough cups!";
        } else {
            coffeeBeans -= coffeePerCup * cups;
            milk -= milkPerCup * cups;
            water -= waterPerCup * cups;
            disposableCups -= cups;
            money += price * cups;
           prompt = "I have enough resources, making you a coffee!";
        }
         return prompt;
        }


    public void getCups() {
        System.out.println("Write how many cups of coffee you will need:");
        cups = sc.nextInt();
    }
    public void menu(){
        System.out.println("write action (buy, fill, take, remaining, exit)");
        String input = sc.nextLine();
        switch (input) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                addIngredient();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                inventory();
                break;
            case "exit":
                System.exit(0);
        }

    }
    public void inventory() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");

    }
    public void takeMoney() {
        System.out.println("I gave you $" + money);
        money -= money;

    }
    public void buyCoffee() {
        StringBuilder choices = new StringBuilder();
        for( Coffee coffees : Coffee.values()) {
            choices.append(coffees.ordinal()).append(". ").append( coffees.name()).append(" ");
        }
        String output = choices.toString();

        System.out.println(output);
        String input = sc.nextLine();
        if (input.equals("back")){
            input = "0";
        }
        String action = (Coffee.values()[Integer.parseInt(input)].name());
        switch (Coffee.valueOf(action)) {
            case ESPRESSO:
                System.out.println(changeInventory(1, 16, 0, 250, 4));
                break;
            case LATTE:
                System.out.println(changeInventory(1, 20, 75, 350, 7));
                break;
            case CAPPUCCINO:
                System.out.println(changeInventory(1, 12, 100, 200, 6));
                break;
            case BACK:
                break;
        }
    }
}
