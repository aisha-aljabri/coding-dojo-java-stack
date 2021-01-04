import java.lang.*;

public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double squareLegC = (legA * legA) + (legB * legB);
        double legC = Math.sqrt(squareLegC);
        return (legC);
    }
}