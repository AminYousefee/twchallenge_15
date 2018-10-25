import java.util.ArrayList;

public class Gildoni extends Elem {
    ArrayList<Floor> floors;
    int numOfUnitsInAFloor;
    public Gildoni(int numOfFloors, int numOfUnits) {
        floors = new ArrayList<Floor>(numOfFloors);
        for (Floor index: floors){
            index = new Floor(numOfUnits);
        }
        sup.sup.changeGills(-700);
    }

    void addFloor(){
        Floor floor = new Floor(numOfUnitsInAFloor,this);
        this.floors.add(floor);
    }

    int calculateIncome() {

    }


    void addUnit() {

        for(Floor f:floors) {
            f.addUnit();
        }
    }



    @Override
    int getScore() {
        int sum=10;
        for (Floor index:floors){
            sum+=index.getScore();
        }
    }
}
