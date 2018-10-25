import java.util.ArrayList;

public class Gildoni extends Elem {
    ArrayList<Floor> floors;

    public Gildoni(int numOfFloors, int numOfUnits) {
        floors = new ArrayList<Floor>(numOfFloors);
        for (Floor index: floors){
            index = new Floor(numOfUnits);
        }
    }

    void addFloor(int numToAdd) {

    }

    int calculateIncome() {

    }

    void addUnit(int numToAdd) {

    }

    @Override
    int getScore() {
        int sum=;
        for (Floor index:floors){
            sum+=index.getScore();
        }
    }
}
