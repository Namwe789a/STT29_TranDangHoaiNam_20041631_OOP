package tuan3.bai5_Rational_Module_2;

public class TestRational {

    public static void main(String[] args) {
        // Tạo các đối tượng Rational
        Rational r1 = new Rational(3, 4); // 3/4
        Rational r2 = new Rational(2, 3); // 2/3

        // Gọi các phương thức kiểm tra
        testAddition(r1, r2);
        testSubtraction(r1, r2);
        testMultiplication(r1, r2);
        testDivision(r1, r2);
        testReciprocal(r1);
        testEquality(r1);
    }

    // Hàm kiểm tra cộng phân số
    public static void testAddition(Rational r1, Rational r2) {
        Rational result = r1.add(r2);
        System.out.println("r1 + r2 = " + result); // Kết quả mong đợi: 17/12
    }

    // Hàm kiểm tra trừ phân số
    public static void testSubtraction(Rational r1, Rational r2) {
        Rational result = r1.subtract(r2);
        System.out.println("r1 - r2 = " + result); // Kết quả mong đợi: 1/12
    }

    // Hàm kiểm tra nhân phân số
    public static void testMultiplication(Rational r1, Rational r2) {
        Rational result = r1.multiply(r2);
        System.out.println("r1 * r2 = " + result); // Kết quả mong đợi: 1/2
    }

    // Hàm kiểm tra chia phân số
    public static void testDivision(Rational r1, Rational r2) {
        Rational result = r1.divide(r2);
        System.out.println("r1 / r2 = " + result); // Kết quả mong đợi: 9/8
    }

    // Hàm kiểm tra nghịch đảo phân số
    public static void testReciprocal(Rational r1) {
        Rational result = r1.reciprocal();
        System.out.println("Nghịch đảo của r1: " + result); // Kết quả mong đợi: 4/3
    }

    // Hàm kiểm tra so sánh hai phân số
    public static void testEquality(Rational r1) {
        double tolerance = 0.0001;
        Rational r8 = new Rational(6, 8); // 6/8 = 3/4
        boolean isEqual = r1.equals(r8, tolerance);
        System.out.println("r1 có bằng r8 không? " + isEqual); // Kết quả mong đợi: true
    }
}
