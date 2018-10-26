import java.util.ArrayList;

public class Home extends Elem {
    ArrayList<Floor> floors;
    int numOfUnitsInAFloor;

    public Home(Block sup, int idToAssign, int numOfFloors, int numOfUnits) {
        super(sup, idToAssign);
        sup.city.changeGills(-(700 + 300 * numOfFloors + 100 * numOfFloors * numOfUnits));
        floors = new ArrayList<Floor>(numOfFloors);
        for (int index = 0; index < numOfFloors; index++) {
            floors.add(new Floor(numOfUnits, this));
        }
        numOfUnitsInAFloor = numOfUnits;
    }


    public static Home addHome(Block sup, int idToAssign, int numOfFloors, int numOfUnits) {
        if (sup.city.getGills() < (700 + 300 * numOfFloors + 100 * numOfFloors * numOfUnits)) {
            System.out.println("NOT ENOUGH MONEY");
            return null;
        } else if (sup.numOfUnemployed < 0) {
            System.out.println("NOT ENOUGH PEOPLE");
            return null;
        } else if (((numOfFloors <= 6) && (numOfFloors >= 3)) && ((numOfUnits >= 1) && (numOfUnits <= 4))) {
            return new Home(sup, idToAssign, numOfFloors, numOfUnits);
        } else {
            System.out.println("INVALID HOUSE");
            return null;
        }
    }


    void addFloor() {
        if (floors.size() == 6) {
            System.out.println("6 FLOOR ALREADY");
        } else if (block.city.getGills() > 300 + 50 * numOfUnitsInAFloor) {
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
        if (numOfUnitsInAFloor == 4) {
            System.out.println("4 UNIT ALREADY");
        } else if (block.city.getGills() > (this.floors.size() * 50)) {
            for (Floor f : floors) {
                f.addUnit();
            }
            block.city.changeGills(-this.floors.size() * 50);
        } else {
            System.out.println("NOT ENOUGH MONEY");
        }
    }

    @Override
//todo some hard job
    void removeElem(boolean status) {
        if (status) {
            System.out.println("HOME DOESN'T REMOVE");
            //As not being used it should be empty
        } else {
            //BLOCK IS REMOVED
        }
    }

    void addFloorAndUnit() {
        if (numOfUnitsInAFloor == 4 || floors.size() == 6) {
            System.out.println("THIS UPGRADE NOT ALLOWED");
        } else if (block.city.getGills() > (300 + 50 * (numOfUnitsInAFloor  + this.floors.size()))) {
            Floor floor = new Floor(numOfUnitsInAFloor, this);
            this.floors.add(floor);
            for (Floor f : floors) {
                f.addUnit();
            }


            block.city.changeGills(-(300 + 50 * (numOfUnitsInAFloor  + this.floors.size())));
            numOfUnitsInAFloor++;
        } else {
            System.out.println("NOT ENOUGH MONEY");
        }
    }


    @Override
    double getScore() {

        double sum = 10+floors.size()*sumFloor()+2*floors.size()*numOfUnitsInAFloor*sumUnit()+3*floors.size()*numOfUnitsInAFloor*5*block.getRefah();

        return sum;



    }


    double sumUnit(){
        return 2+5*block.getRefah();

    }
    double sumFloor(){
        return 3+numOfUnitsInAFloor*sumUnit()+numOfUnitsInAFloor*10*block.getRefah();
    }


    @Override
    int getEmployed() {
        return -(this.floors.size()) * (this.numOfUnitsInAFloor) * 5;
    }
}
