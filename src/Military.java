public class Military extends Army {

    int[] importantDays;

    public Military(Block sup, int idToAssign) {
        super(sup, idToAssign);
        importantDays = new int[5];
        importantDays[0] = startingDay;
        this.block.city.blockMilitary=this;

    }


    public static Military addMilitary(Block sup, int idToAssign) {
        if (sup.city.getGills() < 15000) {
            System.out.println("NOT ENOUGH MONEY");
            return null;
        } else if (sup.getNumOfUnemployed()< 100) {
            System.out.println("NOT ENOUGH PEOPLE");
            return null;

        } else {
            return new Military(sup, idToAssign);
        }
    }

    void attack(Block enemyBlock) {
        if (block.city.getGills() > 5000) {
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

    void loot(Block enemyBlock) {
        if (enemyBlock.blockDefense != null) {
            System.out.println("DEFENSE ELEM FOUND");
        } else {
            block.city.changeGills(500 * enemyBlock.elems.size());

        }
    }


    @Override
    int getScore() {
        return (int) Math.pow(10, block.city.world.day - startingDay);
    }


    int getEmployed() {
        return 100 + 10 * (level - 1);
    }

    @Override
    void removeElem() {
        block.city.changeGills(10000);
        block.elems.remove(this);
    }

    @Override
    void upgradeElem() {
        if (level == 5) {
            System.out.println("LEVEL 5 NO UPDATE POSSIBLE");
        } else if (block.city.getGills() < 20000) {
            System.out.println("NOT ENOUGH MONEY");
        } else if (block.getNumOfUnemployed() < 10) {
            System.out.println("NOT ENOUGH MAN");

        } else {
            this.level++;
            MilPower += 0.2;
            block.city.changeGills(-20000);
            importantDays[level - 1] = this.block.city.world.day;
        }


    }


    @Override
    int CalculateIncome() {
        int result = 0;

        for (int i = 1; i < level; i++) {
            result += (block.city.world.day - importantDays[i]) * 100 * 10;
        }
        return result + (block.city.world.day - startingDay) * 100 * 100;
    }


}
