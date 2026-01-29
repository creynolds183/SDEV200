// Look for WRITE YOUR CODE to write your code
import java.math.*;
import java.util.Scanner;

public class RationalUsingBigIntegerTest {
  public static void main(String[] args) {
    // Prompt the user to enter two Rational numbers
    Scanner input = new Scanner(System.in);
    System.out.print("Enter rational r1 with numerator and denominator seperated by a space: ");
    String n1 = input.next();
    String d1 = input.next();

    System.out.print("Enter rational r2 with numerator and denominator seperated by a space: ");
    String n2 = input.next();
    String d2 = input.next();

    RationalUsingBigInteger r1 = new RationalUsingBigInteger(
      new BigInteger(n1), new BigInteger(d1));
    RationalUsingBigInteger r2 = new RationalUsingBigInteger(
      new BigInteger(n2), new BigInteger(d2));

    // Display results
    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    System.out.println(r2 + " is " + r2.doubleValue());
  }
}

// Name the revised Rational class RationalUsingBigInteger 
class RationalUsingBigInteger extends Number 
    implements Comparable<RationalUsingBigInteger> {
  // Data fields for numerator and denominator
  private BigInteger numerator = BigInteger.ZERO;
  private BigInteger denominator = BigInteger.ONE;

  // WRITE YOUR CODE
  public RationalUsingBigInteger(){
  
  }

  public RationalUsingBigInteger(BigInteger numerator, BigInteger denominator) {
    long gcd = gcd(numerator, denominator);
    this.numerator = numerator;
    this.denominator = denominator;
  }

  private static long gcd(BigInteger n, BigInteger d){
    BigInteger n1 = n.abs();
    BigInteger n2 = d.abs();
    int gcd = 1;

    for (BigInteger k = BigInteger.valueOf(1); n1.compareTo(k) <= 0 && n2.compareTo(k) <= 0; k.add(BigInteger.valueOf(1))) {
      if (n1.divideAndRemainder(k)[1] == BigInteger.valueOf(0) && n2.divideAndRemainder(k)[1] == BigInteger.valueOf(0)){
        gcd = k.intValue();
      }
    }
    return gcd;
  }

  public BigInteger getNumerator() {
    return numerator;
  }

  public BigInteger getDenominator() {
    return denominator;
  }

  public RationalUsingBigInteger add(RationalUsingBigInteger secondRational){
    BigInteger n = secondRational.getDenominator().multiply(numerator)
      .add(secondRational.getNumerator().multiply(denominator));
    BigInteger d = secondRational.getDenominator().multiply(denominator);
    return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger subtract(RationalUsingBigInteger secondRational) {
    BigInteger n = secondRational.getDenominator().multiply(numerator)
      .subtract(secondRational.getNumerator().multiply(denominator));
      BigInteger d = secondRational.getDenominator().multiply(denominator);
      return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger multiply(RationalUsingBigInteger secondRational){
    BigInteger n = secondRational.getNumerator().multiply(numerator);
    BigInteger d = secondRational.getDenominator().multiply(denominator);
    return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger divide(RationalUsingBigInteger secondRational){
    BigInteger n = secondRational.getDenominator().multiply(numerator);
    BigInteger d = secondRational.getNumerator().multiply(denominator);
    return new RationalUsingBigInteger(n, d);
  }

  @Override
  public String toString() {
    if (denominator == BigInteger.valueOf(1))
      return numerator + "";
    else
      return numerator + "/" + denominator;
  }

  @Override
  public int intValue(){
    return (int)doubleValue();
  }

  @Override
  public float floatValue(){
    return (float)doubleValue();
  }

  @Override
  public double doubleValue(){
    return (denominator.divide(numerator.multiply(BigInteger.valueOf(1)))).doubleValue();
  }

  @Override
  public long longValue(){
    return (long)doubleValue();
  }

  @Override
  public int compareTo(RationalUsingBigInteger rational){
    if (this.subtract(rational).getNumerator().compareTo(BigInteger.valueOf(0)) > 0)
      return 1;
    else if (this.subtract(rational).getNumerator().compareTo(BigInteger.valueOf(0)) < 0)
      return -1;
    else
      return 0;
  }

}