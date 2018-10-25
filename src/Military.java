public class Military extends Army {

    void attack(Block enemyBlock){
        if(this.MilPoewr>enemyBlock.blockDefense.MilPoewr){
            enemyBlock.die();
        }

    }
}
