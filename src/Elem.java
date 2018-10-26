public abstract class Elem {
    static int startNeededValue;
    static int startNeededPeople;
    int startingDay;
    int level = 1;
    int id;
    Block block;
    /*
    public static Elem addElem(Block block,int idToAssign) {
        if (block.block.getGills() < startNeededValue) {
            System.out.println("NOT ENOUGH MONEY");
        } else if (block.numOfUnemployed < startNeededPeople) {
            System.out.println("NOT ENOUGH PEOPLE");

        }else {
            return new Military(block,idToAssign);
        }
    }
    */


    public Elem(Block block, int idToAssign) {
        this.block = block;
        startingDay = block.city.world.day;
        this.id = idToAssign;
        System.out.println(id);
    }


    void upgradeElem() {
        level++;

    }

    abstract int getScore();

    abstract int getEmployed();

    abstract void removeElem();

    //todo add income when the day is added
    abstract int CalculateIncome();


}
