import java.util.ArrayList;

public class Floor {
    Home home;
    ArrayList<Unit> units;


    public Floor(int numOfUnits, Home t) {
        home = t;
        units = new ArrayList<Unit>(numOfUnits);
        for (Unit index : units) {
            index = new Unit(this);
        }
    }

    double getScore() {
        double sum = 3d;
        for (Unit index : units) {
            sum += index.getScore();
        }
        return sum;
    }
    void addUnit(){
        units.add(new Unit(this));

    }





}
