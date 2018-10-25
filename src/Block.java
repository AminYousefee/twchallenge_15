import java.util.ArrayList;

public class Block {
    City Sup;
    int id;
    int level;
    int numOfElems;
    Defense blockDefense;

    ArrayList<Elem> elems;





    void addElem(){

    }
    void upgradeBlock(){

    }
    void addDefense(){

    }
    void removeDefense(){

    }

    public int getId() {
        return id;
    }
    void defend(Sup){

    }
    void die(){
        Sup.blocks.remove(this);
    }
}
