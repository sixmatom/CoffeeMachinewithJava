import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rectangle rectangle1 = new Rectangle(scanner.nextInt(),scanner.nextInt());
        Rectangle rectangle2 = new Rectangle(scanner.nextInt(),scanner.nextInt());
        areaCalculator(rectangle1);
        areaCalculator(rectangle2);
    }
    public static void areaCalculator(Rectangle rectangle) {
        System.out.println(rectangle.width * rectangle.height);
    }
}

class Rectangle {
    int width;
    int height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

}
