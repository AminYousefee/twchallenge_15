public abstract class Elem {
    static int startNeededValue;
    static int startNeededPeople;
    int startingDay;
    int level;
    int id;
    Block sup;
    /*
    public static Elem addElem(Block sup,int idToAssign) {
        if (sup.sup.getGills() < startNeededValue) {
            System.out.println("NOT ENOUGH MONEY");
        } else if (sup.numOfUnemployed < startNeededPeople) {
            System.out.println("NOT ENOUGH PEOPLE");

        }else {
            return new Military(sup,idToAssign);
        }
    }
    */




    public Elem(Block Sup,int idToAssign) {
        this.sup =Sup;
        startingDay =World.world.day;
        this.id = idToAssign;
    }


    void upgradeElem(){
        level++;

    }
    int getScore(){

    }
    int getEmployed(){
    }


}
