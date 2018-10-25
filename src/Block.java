import java.util.ArrayList;

public class Block {
    City Sup;
    int id;
    int level;
    int numOfElems;
    int maxNumOfElems;
    int numToAssign;
    Defense blockDefense;

    ArrayList<Elem> elems;


    void addElem(Elem t1) {
        if (numOfElems == maxNumOfElems) {
            System.out.println("Not Possible");
        } else {
            if (t1 instanceof Bazar) {
                Sup.changeGills(-6000);
            } else if (t1 instanceof Gildoni) {
                //todo
            } else if (t1 instanceof Military) {
                Sup.changeGills(-15000);

            } else if (t1 instanceof Defense) {
                Sup.changeGills(-10000);
            }
            elems.add(t1);

        }


    }

    void upgradeBlock() {
        if (level == 3) {
            System.out.println("Not Possible");
        } else {
            maxNumOfElems += 5;

            Sup.changeGills((int) -Math.pow(500, level));
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
        Sup.blocks.remove(this);
    }

    int getScore() {
        int sum=0;
        for (Elem index : elems) {
            sum += index.getScore();
        }
        return sum;
    }

}
