public class Defense extends Army{

    @Override
    int getScore() {
        return (int)Math.pow(15,World.world.day-startingDay);
    }


    @Override
    void upgradeElem() {
        upgradeElem();


    }
}
