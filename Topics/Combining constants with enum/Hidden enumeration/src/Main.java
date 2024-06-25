public class Main {

    public static void main(String[] args) {
        int counter = 0;

        for (Secret secrets : Secret.values()){
            String input = secrets.toString();
            if (input.startsWith("STAR")) {
                counter++;
            }
        }


        System.out.println(counter);
    }
}

/* sample enum for inspiration
enum Secret {
    STAR, CRASH, START, // ...
}
*/