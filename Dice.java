package newcode;

public class Dice {
    private char[] sides;
    private char shownSide;
    public Dice() {
        sides = new char[6];
    }
    public Dice(char[] sides) {
        this.sides = sides;
        this.shownSide = sides[0];
    }
    public void setSides(char[] sides) {
        this.sides = sides;
        this.shownSide = sides[0];
    }
    public char[] getSides() {
        return sides;
    }
    public void setShownSide(char shownSide) {
        this.shownSide = shownSide;
    }
    public void setShownSide(int index) {
        shownSide = sides[index];
    }
    public char getShownSide() {
        return shownSide;
    }
    public void reroll() {
        this.shownSide = sides[(int) (Math.random()*5 + 1)];
    }
}
