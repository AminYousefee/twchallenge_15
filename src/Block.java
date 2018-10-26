import java.util.ArrayList;

public class Block {
    public int numOfUnemployed = 0;
    City city;
    int id;
    int level;
    int numOfElems;
    int maxNumOfElems;
    int numToAssign = 1;
    Defense blockDefense;

    ArrayList<Elem> elems;


    static Block addBlock(City city, int idToAssign) {
        if (city.getGills() < 1000) {
            System.out.println("NOT ENOUGH MONEY FOR BUILDING BLOCK");
            return null;
        } else {
            return new Block(city, idToAssign);

        }
    }


    public Block(City city, int id) {
        elems = new ArrayList<Elem>(0);
        this.city = city;
        this.id = id;
        System.out.println(id);
        city.changeGills(-1000);

    }
    /*
    void addElem(Elem t1) {

        if (t1 instanceof Bazar) {
            city.changeGills(-6000);
        } else if (t1 instanceof Home) {
            //todo
        } else if (t1 instanceof Military) {
            city.changeGills(-15000);

        } else if (t1 instanceof Defense) {
            city.changeGills(-10000);
        }
        elems.add(t1);


    }


    */

    void upgradeBlock() {
        if (level == 3) {
            System.out.println("LEVEL 3 Not Possible");
        } else if (city.getGills() >= Math.pow(500, level)) {

            maxNumOfElems += 5;

            city.changeGills((int) -Math.pow(500, level));
            level++;
        }


    }

    void addDefense() {

    }

    void removeDefense() {

    }

    public int getId() {
        return id;
    }

    void die() {
        city.blocks.remove(this);
    }

    int getScore() {
        int sum = 0;
        for (Elem index : elems) {
            sum += index.getScore();
        }
        return sum;
    }


    double getRefah() {
        double res = 1.0d;
        for (Elem index : elems) {

            if (index instanceof Bazar) {
                res *= (1 + 0.2 * (index.level - 1));
            }

        }
        return res;
    }

    Elem findElemById(int id) {
        for (Elem index : elems) {
            if (index.id == id) {
                return index;
            }
        }
        System.out.println("ELEM NOT FOUND");
        return null;
    }


    boolean hasCapasity() {
        if (maxNumOfElems != numOfElems) {
            System.out.println("BLOCK FULL");
        }

        return maxNumOfElems == numOfElems;
    }



    int getNumOfUnemployed() {// is defined minus for Home
        int result = 0;
        for (Elem index : elems) {
            result -= index.getEmployed();
        }
        //System.out.println(result);
        return result;
    }


    int calculateIncome() {
        int res = getNumOfUnemployed() * 100;
        for (Elem index : elems) {
            res += index.CalculateIncome();
        }
        return res;
    }

    public int getNumToAssign() {
        return numToAssign;
    }

    public void addNumToAssign() {
        numToAssign++;
    }

}
