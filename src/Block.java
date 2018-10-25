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
        if(numOfElems==maxNumOfElems){
            System.out.println("Not Possible");
        }else {
            elems.add(t1);
        }

    }

    void upgradeBlock() {
        if (level == 3) {
            System.out.println("Not Possible");
        } else {
            maxNumOfElems += 5;

            Sup.changeGills((int)-Math.pow(500,level));
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


}
