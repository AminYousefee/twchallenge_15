public class Defense extends Army{






    public static Elem addDefense(Block sup,int idToAssign) {
        if (sup.sup.getGills() < 10000) {
            System.out.println("NOT ENOUGH MONEY");
        } else if (sup.numOfUnemployed < 30) {
            System.out.println("NOT ENOUGH PEOPLE");

        }else {
            return new Defense(sup,idToAssign);
        }
    }

    public Defense(Block sup,int idToAssign) {
        super(sup,idToAssign);
    }

    @Override
    int getScore() {
        return (int)Math.pow(15,World.world.day-startingDay);
    }


    @Override
    void upgradeElem() {


    }

    int getEmployed(){
        return 30;
    }30
}
