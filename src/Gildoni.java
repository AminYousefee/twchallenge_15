import java.util.ArrayList;

public class Gildoni extends Elem {
    ArrayList<Floor> floors;

    public Gildoni(int numOfFloors, int numOfUnits) {
        floors = new ArrayList<Floor>(numOfFloors);
        for (Floor index: floors){
            index = new Floor(numOfUnits);
        }
    }

    void addFloor() {

    }

    int calculateIncome() {

    }

    void addUnit() {

    }

    @Override
    int getScore() {
        int sum=10;
        for (Floor index:floors){
            sum+=index.getScore();
        }
    }
}
