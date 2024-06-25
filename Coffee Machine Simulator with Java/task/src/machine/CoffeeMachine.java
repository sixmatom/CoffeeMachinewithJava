package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner sc = new Scanner(System.in);
    private static int cups;
    private static int water = 400;
    private static int coffeeBeans = 120;
    private static int milk = 540;
    private static int money = 550;
    private static int disposableCups = 9;

    public static void main(String[] args) {
       while (true) {
           menu();
       }
    }

    public static void addIngredient() {
        System.out.println("Write how many ml of water you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        disposableCups += sc.nextInt();
    }

    public static String changeInventory(int cups, int coffeePerCup, int milkPerCup, int waterPerCup, int price) {
        String prompt = "";
        if(coffeeBeans - coffeePerCup < 0) {
            prompt = "Sorry, not enough coffee!";

        } else if (milk - milkPerCup < 0)  {
            prompt = "Sorry, not enough milk!";
        } else if (water - waterPerCup < 0) {
            prompt = "Sorry, not enough water!";
        } else if (cups - cups < 0) {
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


    public static void getCups() {
        System.out.println("Write how many cups of coffee you will need:");
        cups = sc.nextInt();
    }
    public static void menu(){
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
    public static void inventory() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");

    }
    public static void takeMoney() {
        System.out.println("I gave you $" + money);
        money -= money;

    }
    public static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino back - to main menu:");
        String action = sc.nextLine();
        switch (action) {
            case "1":
                System.out.println(changeInventory(1, 16, 0, 250, 4));
                break;
            case "2":
                System.out.println(changeInventory(1, 20, 75, 350, 7));
                break;
            case "3":
                System.out.println(changeInventory(1, 12, 100, 200, 6));
                break;
            case "back":
                break;
        }
    }
}
