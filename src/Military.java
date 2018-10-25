public class Military extends Army {


    public Military() {
    }

    public static Military addMilitary(City city,int B) {
        if (city.getGills() < 15000) {
            System.out.println("NOT ENOUGH MONEY");
        } else if (numOfUnemployed < 100) {
            System.out.println("NOT ENOUGH PEOPLE");

        }else {
            return new Military(city);
        }
    }

    void attack(Block enemyBlock) {
        if (sup.sup.getGills() > 5000) {
            if (this.MilPoewr > enemyBlock.blockDefense.MilPoewr) {
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
}
