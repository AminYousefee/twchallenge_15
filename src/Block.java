import java.util.ArrayList;

public class Block {
    City sup;
    int id;
    int level;
    int numOfElems;
    int maxNumOfElems;
    int numToAssign;
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


    public Block(City sup, int id) {
        this.sup = sup;
        this.id = id;
        sup.changeGills(-1000);

    }

    void addElem(Elem t1) {
        if (numOfElems == maxNumOfElems) {
            System.out.println("Not Possible");
        } else {
            if (t1 instanceof Bazar) {
                sup.changeGills(-6000);
            } else if (t1 instanceof Home) {
                //todo
            } else if (t1 instanceof Military) {
                sup.changeGills(-15000);

            } else if (t1 instanceof Defense) {
                sup.changeGills(-10000);
            }
            elems.add(t1);

        }


    }

    void upgradeBlock() {
        if (level == 3) {
            System.out.println("LEVEL 3 Not Possible");
        } else if (sup.getGills() >= Math.pow(500, level))){

            maxNumOfElems += 5;

            sup.changeGills((int) -Math.pow(500, level));
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
        sup.blocks.remove(this);
    }

    int getScore() {
        int sum = 0;
        for (Elem index : elems) {
            sum += index.getScore();
        }
        return sum;
    }


    double getRefah() {
        for (Elem index : elems) {
            double res = 1.0d;
            if (index instanceof Bazar) {
                res *= (1 + 0.2 * (index.level - 1));
            }

        }
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

}
