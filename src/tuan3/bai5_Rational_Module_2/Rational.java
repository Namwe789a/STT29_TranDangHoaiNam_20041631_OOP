package tuan3.bai5_Rational_Module_2;

public class Rational {
	 private int numerator;
	 private int denominator;
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		if (denominator == 0) {
	        throw new IllegalArgumentException("Denominator cannot be zero.");
	    }else {
	    	this.numerator = numerator;
	    }
	
	}
	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	public Rational(int numerator, int denominator) {
		if (denominator == 0) {
	        throw new IllegalArgumentException("Denominator cannot be zero.");
	    }
		this.numerator = numerator;
		this.denominator = denominator;
	}
	 

    // Tối giản phân số
    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Nghịch đảo phân số
    public Rational reciprocal() {
        return new Rational(denominator, numerator);
    }

    // Cộng 2 phân số
    public Rational add(Rational other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;  //Ví dụ: (a/b) + (c/d) sẽ có tử số là (a*d + c*b).
        int newDenominator = this.denominator * other.denominator;   //Ví dụ: (a/b) + (c/d) sẽ có mẫu số là b*d.
        return new Rational(newNumerator, newDenominator);
    }

    // Trừ 2 phân số
    public Rational subtract(Rational other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator; //Ví dụ: (a/b) - (c/d) sẽ có tử số là (a*d - c*b).
        int newDenominator = this.denominator * other.denominator; //Ví dụ: (a/b) - (c/d) sẽ có mẫu số là b*d.
        return new Rational(newNumerator, newDenominator);
    }

    // Nhân 2 phân số
    public Rational multiply(Rational other) {
        int newNumerator = this.numerator * other.numerator; //Ví dụ: (a/b) * (c/d) sẽ có tử số là a*c.
        int newDenominator = this.denominator * other.denominator;//Ví dụ: (a/b) * (c/d) sẽ có mẫu số là b*d.
        return new Rational(newNumerator, newDenominator);
    }

    // Chia 2 phân số
    // đéo hiểu !!!!!!!!
    public Rational divide(Rational other) {
        return this.multiply(other.reciprocal());
    }

    // So sánh 2 phân số
    public boolean equals(Rational other, double tolerance) {
        double thisValue = (double) this.numerator / this.denominator; //Tính giá trị của phân số hiện tại dưới dạng số thực (floating-point).	
        double otherValue = (double) other.numerator / other.denominator; //ính giá trị của phân số khác dưới dạng số thực.
        return Math.abs(thisValue - otherValue) < tolerance; // Kiểm tra xem giá trị tuyệt đối của hiệu giữa hai phân số có nhỏ hơn sai số cho phép không. Nếu có, hai phân số được coi là bằng nhau.
    }
	@Override
	public String toString() {
		return "Rational [numerator=" + numerator + ", denominator=" + denominator + "]";
	}
    
    

}
