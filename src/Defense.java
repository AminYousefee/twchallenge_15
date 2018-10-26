public class Defense extends Army{

    @Override
    void removeElem() {
        block.city.changeGills(10000);
        block.elems.remove(this);

    }

    public static Defense addDefense(Block block, int idToAssign) {
        if (block.city.getGills() < 10000) {
            System.out.println("NOT ENOUGH MONEY");
            return null;
        } else if (block.getNumOfUnemployed() < 30) {
            System.out.println("NOT ENOUGH PEOPLE");
            return null;

        }else {
            return new Defense(block,idToAssign);
        }
    }

    public Defense(Block sup,int idToAssign) {
        super(sup,idToAssign);
    }

    @Override
    int getScore() {
        return (int)Math.pow(15, block.city.world.day-startingDay);
    }


    @Override
    void upgradeElem() {
        if(level==5){
            System.out.println("LEVEL 5 NO UPDATE POSSIBLE");
        }else if (block.city.getGills()<5000){
            System.out.println("NOT ENOUGH MONEY");

        }else {
            this.level++;
            MilPower+=0.2;
            block.city.changeGills(-5000);
        }



    }

    int getEmployed(){
        return 30;
    }

    @Override
    int CalculateIncome() {
        return (block.city.world.day-startingDay)*100*30;
    }
}
