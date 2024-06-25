class Cat {
    // Instance variables
    String name;
    int age;

    // Static variable to count the number of cats
    static int counter = 0;

    // Constructor
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++; // Increment the counter for each new cat

        // Check if we have too many cats
        if (counter > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        return counter;
    }
}



