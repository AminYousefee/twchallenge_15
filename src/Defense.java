public class Defense extends Army{


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
