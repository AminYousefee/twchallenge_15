import java.util.ArrayList;

public class Floor {
    Home Sup;
    ArrayList<Unit> units;


    public Floor(int numOfUnits, Home t) {
        Sup = t;
        units = new ArrayList<Unit>(numOfUnits);
        for (Unit index : units) {
            index = new Unit(this);
        }
    }

    int getScore() {
        int sum = 3;
        for (Unit index : units) {
            sum += index.getScore();
        }
    }
    void addUnit(){
        units.add(new Unit(this));

    }





}
