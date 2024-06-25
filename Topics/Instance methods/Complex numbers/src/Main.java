class Complex {
    // Fields to store real and imaginary parts
    double real;
    double imaginary;

     // Method to add another complex number to the current instance
    public void add(Complex num) {
        this.real += num.real;
        this.imaginary += num.imaginary;
    }

    // Method to subtract another complex number from the current instance
    public void subtract(Complex num) {
        this.real -= num.real;
        this.imaginary -= num.imaginary;
    }
}

