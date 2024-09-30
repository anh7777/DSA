package Hw2_22001235_NguyenNgocAnh.Exercise1;

public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    // Phép cộng
    public Fraction add(Fraction c) {
        float newNumerator = this.numerator * c.getDenominator() + c.getNumerator() * this.denominator;
        float newDenominator = this.denominator * c.getDenominator();
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    // Phép trừ
    public Fraction minus(Fraction c) {
        float newNumerator = this.numerator * c.getDenominator() - c.getNumerator() * this.denominator;
        float newDenominator = this.denominator * c.getDenominator();
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    // Phép nhân
    public Fraction multi(Fraction c) {
        float newNumerator = this.numerator * c.getNumerator();
        float newDenominator = this.denominator * c.getDenominator();
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    // Phép chia
    public Fraction divi(Fraction c) {
        float newNumerator = this.numerator * c.getDenominator();
        float newDenominator = this.denominator * c.getNumerator();
        return new Fraction(newNumerator, newDenominator).normalize();
    }

    // Tối giản phân số
    public Fraction normalize() {
        float gcd = findGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        return this;
    }

    // Tìm ước chung lớn nhất (GCD)
    private float findGCD(float a, float b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    // Đề xuất phương thức so sánh hai phân số
    public boolean isGreaterThan(Fraction c) {
        return this.numerator * c.getDenominator() > c.getNumerator() * this.denominator;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }

        if (numerator == 0) {
            return String.valueOf(0);
        }

        if (numerator * denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
            return String.valueOf(- numerator / denominator);
        }
        return (numerator + "/" + denominator);
    }
}


