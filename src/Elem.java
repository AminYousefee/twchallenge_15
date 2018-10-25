public abstract class Elem {
    int startingDay;
    int level;
    int id;
    Block Sup;
    public Elem(Block Sup) {
        this.Sup=Sup;
        startingDay =World.world.day;
    }

    void upgradeElem(){

    }
    int getScore(){

    }


}
