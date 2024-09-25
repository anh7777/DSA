package Hw1;

class ComplexNumber {
    double real, imaginary;

    public ComplexNumber(double r, double i) {
        this.real = r;
        this.imaginary = i;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }
}
