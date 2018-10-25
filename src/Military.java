public class Military extends Army {

    void attack(Block enemyBlock){
        if (sup.sup.getGills()>5000){
            if(this.MilPoewr>enemyBlock.blockDefense.MilPoewr){
                enemyBlock.die();
                System.out.println("Attacked and Won");
            }else {
                System.out.println("Attacked but lost");
            }
        }else {
            System.out.println("Attack needs more money");
        }



    }

    @Override
    int getScore() {
        return (int)Math.pow(10,World.world.day-startingDay);
    }
}
