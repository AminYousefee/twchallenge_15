import java.util.ArrayList;

public class Unit {
    ArrayList<Person> people;
    Floor floor;

    public Unit(Floor t) {
        people =new ArrayList<Person>(0);
        floor = t;
        for (int i=0;i<5;i++) {
            people.add(new Person());
        }
    }


    double getScore() {
        return 2 + 5 * this.floor.home.block.getRefah();
    }
}
