import java.util.ArrayList;

public class Home extends Elem {
    ArrayList<Floor> floors;
    int numOfUnitsInAFloor;

    public Home(Block sup, int idToAssign, int numOfFloors, int numOfUnits) {
        super(sup, idToAssign);
        sup.city.changeGills(-(700 + 300 * numOfFloors + 100 * numOfUnits));
        floors = new ArrayList<Floor>(numOfFloors);
        for (int index =0;index<numOfFloors;index++) {
            floors.add( new Floor(numOfUnits, this));
        }
        sup.city.changeGills(-700);
        numOfUnitsInAFloor= numOfUnits;
    }


    public static Home addHome(Block sup, int idToAssign, int numOfFloors, int numOfUnits) {
        if (sup.city.getGills() < 700 + 300 * numOfFloors + 100 * numOfUnits) {
            System.out.println("NOT ENOUGH MONEY");
            return null;
        } else if (sup.numOfUnemployed < 0) {
            System.out.println("NOT ENOUGH PEOPLE");
            return null;

        } else {
            return new Home(sup, idToAssign, numOfFloors, numOfUnits);
        }
    }


    void addFloor() {
        if (block.city.getGills() > 300 + 100 * numOfUnitsInAFloor) {
            Floor floor = new Floor(numOfUnitsInAFloor, this);
            this.floors.add(floor);
            block.city.changeGills(-300 - 100 * numOfUnitsInAFloor);
        } else {
            System.out.println("NOT ENOUGH MONEY");
        }
    }

    @Override
    int CalculateIncome() {
        return 0;
    }

    void addUnit() {
        if (block.city.getGills() > (this.floors.size() * 300) ) {
            for (Floor f : floors) {
                f.addUnit();
            }
            block.city.changeGills(-this.floors.size() * 300);
        }else {
            System.out.println("NOT ENOUGH MONEY");
        }
    }

    @Override
    void removeElem() {
        System.out.println("HOME DOESN'T REMOVE");
        //As not being used it should be empty

    }

    void addFloorAndUnit(){
        if (block.city.getGills()>(300+100*(numOfUnitsInAFloor+1+this.floors.size()))){
            Floor floor = new Floor(numOfUnitsInAFloor, this);
            this.floors.add(floor);
            for (Floor f : floors) {
                f.addUnit();
            }


            block.city.changeGills(-(300+100*(numOfUnitsInAFloor+1+this.floors.size())));
            numOfUnitsInAFloor++;
        }else{
            System.out.println("NOT ENOUGH MONEY");
        }
    }


    @Override
    int getScore() {
        int sum = 10;
        for (Floor index : floors) {
            sum += index.getScore();
        }
        return sum;
    }


    @Override
    int getEmployed() {
        return -(this.floors.size()) * (this.numOfUnitsInAFloor)*5;
    }
}
