package level_3;

public class Calculator {
    private double total;
    public Calculator(){
        total = 0;
    }
    public double getTotal() { return total; }
    public void add(double number){
        total += number;
    }
    public void subtract(double number){
        total -= number;
    }
    public void multiply(double number){
        total *= number;
    }
    public void divide(double number){
        if (number == 0){
            throw new ArithmeticException("Divisor can't be ZERO!");
        }
        total /= number;
    }
    public void reset(){
        total = 0;
    }
}
