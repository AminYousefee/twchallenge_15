import java.util.ArrayList;

public class Unit {
    ArrayList<Person> people;
    Floor Sup;

    public Unit(Floor t) {
        Sup = t;
        for (Person index : people) {
            index = new Person();
        }
    }

    int calculateIncome() {

    }

    double getScore() {
        return 5 * this.Sup.Sup.Sup.getRefah();
    }
}
