public class Military extends Army {


    public Military(Block sup,int idToAssign) {
        super(sup,idToAssign);
    }


    public static Military addMilitary(Block sup,int idToAssign) {
        if (sup.sup.getGills() < 15000) {
            System.out.println("NOT ENOUGH MONEY");
        } else if (sup.numOfUnemployed < 100) {
            System.out.println("NOT ENOUGH PEOPLE");

        }else {
            return new Military(sup,idToAssign);
        }
    }

    void attack(Block enemyBlock) {
        if (sup.sup.getGills() > 5000) {
            if (this.MilPower > enemyBlock.blockDefense.MilPower) {
                enemyBlock.die();
                System.out.println("Attacked and Won");
            } else {
                System.out.println("Attacked but lost");
            }
        } else {
            System.out.println("Attack needs more money");
        }


    }

    @Override
    int getScore() {
        return (int) Math.pow(10, World.world.day - startingDay);
    }




    int getEmployed(){
        return 100+10*(level-1);
    }
}
