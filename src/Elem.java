public abstract class Elem {
    int startingDay;
    int level;
    int id;
    Block sup;
    public Elem(Block Sup) {
        this.sup =Sup;
        startingDay =World.world.day;
    }

    void upgradeElem(){
        level++;

    }
    int getScore(){

    }


}
