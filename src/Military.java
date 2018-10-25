public class Military extends Army {

    void attack(Block enemyBlock){
        if(this.MilPoewr>enemyBlock.blockDefense.MilPoewr){
            enemyBlock.die();
        }


    }
    void upgradeElem(){

    }
    @Override
    int getScore() {
        return (int)Math.pow(10,World.world.day-startingDay);
    }
}
