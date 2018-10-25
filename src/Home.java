import java.util.ArrayList;

public class Home extends Elem {
    ArrayList<Floor> floors;
    int numOfUnitsInAFloor;

    public Home(Block sup, int idToAssign, int numOfFloors, int numOfUnits) {
        super(sup, idToAssign);
        sup.sup.changeGills(-(700 + 300 * numOfFloors + 100 * numOfUnits));
        floors = new ArrayList<Floor>(numOfFloors);
        for (Floor index : floors) {
            index = new Floor(numOfUnits, this);
        }
        sup.sup.changeGills(-700);
    }


    public static Home addHome(Block sup, int idToAssign, int numOfFloors, int numOfUnits) {
        if (sup.sup.getGills() < 700 + 300 * numOfFloors + 100 * numOfUnits) {
            System.out.println("NOT ENOUGH MONEY");
        } else if (sup.numOfUnemployed < 0) {
            System.out.println("NOT ENOUGH PEOPLE");

        } else {
            return new Home(sup, idToAssign, numOfFloors, numOfUnits);
        }
    }


    void addFloor() {
        if (sup.sup.getGills() > 300 + 100 * numOfUnitsInAFloor) {
            Floor floor = new Floor(numOfUnitsInAFloor, this);
            this.floors.add(floor);
            sup.sup.changeGills(-300 - 100 * numOfUnitsInAFloor);
        } else {
            System.out.println("NOT ENOUGH MONEY");
        }
    }

    int calculateIncome() {

    }


    void addUnit() {
        if (sup.sup.getGills() > (this.floors.size() * 300) ) {
            for (Floor f : floors) {
                f.addUnit();
            }
            sup.sup.changeGills(-this.floors.size() * 300);
        }else {
            System.out.println("NOT ENOUGH MONEY");
        }
    }
    void addFloorAndUnit(){
        if (sup.sup.getGills()>(300+100*(numOfUnitsInAFloor+1+this.floors.size()))){
            Floor floor = new Floor(numOfUnitsInAFloor, this);
            this.floors.add(floor);
            for (Floor f : floors) {
                f.addUnit();
            }


            sup.sup.changeGills(-(300+100*(numOfUnitsInAFloor+1+this.floors.size())));
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
    }


    @Override
    int getEmployed() {
        return -(this.floors.size()) * (this.numOfUnitsInAFloor);
    }
}
