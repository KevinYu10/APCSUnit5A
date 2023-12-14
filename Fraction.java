package APCSUnit5;
import java.util.*;
public class Fraction {
        private Double numerator;
        private Double denominator;
        public Fraction() {
            numerator = Math.random()*10;
            denominator = (Math.random()*9)+1;
        }
        public Fraction(Double num, Double den) {
            if(den != 0) {
                denominator = den;
                numerator = num;
            } else {
                System.out.println("Math error");
            }
        }
        public Fraction(String str) {
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) == '/') {
                    numerator = Double.parseDouble(str.substring(0,i));
                    if(Double.parseDouble(str.substring(i+1, str.length())) != 0.0) {
                        denominator = Double.parseDouble(str.substring(i+1, str.length()));
                    } else {
                        System.out.println("Math error");
                    }
                    break;
                }
            }
        }
        
        public Fraction(Fraction f) {
            denominator = f.getDemon();
            numerator = f.getNum();
        }
        public Double getNum() {
            return numerator;
        } 
        public Double getDemon() {
            return denominator;
        }
        public String toString() {
            String x = numerator + "/" + denominator;
            return x;
        }
        public Double toDouble() {
            Double x = numerator/denominator;
            return x;
        }
        public void reduce() {
            denominator = denominator/GCF(denominator, numerator);
            numerator = numerator/GCF(denominator, numerator);
        }
        public void setNum(Double newNum) {
            numerator = newNum;
        }
        public void setDenom(Double newDenom) {
            denominator = newDenom;
        }
        public static Fraction multiply(Fraction x, Fraction y) {
            Fraction a = new Fraction(x.getNum()*y.getNum(), x.getDemon()*y.getDemon());
            a.reduce();
            return a;
        }
        public static Fraction divide(Fraction x, Fraction y) {
            Fraction a = new Fraction(x.getNum()*y.getDemon(), x.getDemon()*y.getNum());
            a.reduce();
            return a;
        }
        public static Fraction add(Fraction x, Fraction y) {
            double num = x.getNum()*y.getDemon() + y.getNum()*x.getDemon();
            double denom = x.getDemon()*y.getDemon();
            Fraction a = new Fraction(num, denom);
            a.reduce();
            return a;
        }
        public static Fraction substract(Fraction x, Fraction y) {
            double num = x.getNum()*y.getDemon() - y.getNum()*x.getDemon();
            double denom = x.getDemon()*y.getDemon();
            Fraction a = new Fraction(num, denom);
            a.reduce();
            return a;
        }
        private double GCF(double a, double b)   {
            if (a == 0) return b;
            return GCF(b % a, a);
        }
        
        public static void main(String[] args) {
            Fraction MiLu = new Fraction(355.0, 113.0);
            final Double EPSILON = Math.abs(Math.PI-MiLu.toDouble());
            Scanner sc = new Scanner(System.in);
            double x = sc.nextInt();
            double y = sc.nextInt();
            sc.close();
            Fraction input = new Fraction(x,y);
            while(Math.abs(Math.PI - input.toDouble()) >= EPSILON) {
                if(input.toDouble() > Math.PI) {
                    input.setDenom(input.getDemon()+1);
                } else {
                    input.setNum(input.getNum()+1);
                }
            }
            System.out.println(input.getNum() + "/" + input.getDemon());
    }
} 

