public class Bazar extends Elem {


    int[] importantDays;
    @Override
    double getScore(){
        return Math.pow(5, block.city.world.day-startingDay);
    }

    public Bazar(Block Sup, int idToAssign) {
        super(Sup, idToAssign);
        importantDays =new int[5];

        importantDays[0] = startingDay;
    }

    public static Bazar addBazar(Block sup, int idToAssign) {
        if (sup.city.getGills() < 6000) {
            System.out.println("NOT ENOUGH MONEY");
            return null;
        } else if (sup.getNumOfUnemployed() < 50) {
            System.out.println("NOT ENOUGH PEOPLE");
            return null;

        }else {
            sup.city.changeGills(-6000);
            return new Bazar(sup,idToAssign);
        }
    }






    int getEmployed(){
        return 50+20*(level-1);
    }


    @Override
    void upgradeElem() {
        if (block.city.getGills() < (this.level+1)*5000) {
            System.out.println("NOT ENOUGH MONEY");
        } else if (block.numOfUnemployed < 20) {
            System.out.println("NOT ENOUGH PEOPLE");

        }else {
            level++;
            block.city.changeGills(-(this.level+1)*5000);
            importantDays[level - 1] = this.block.city.world.day;
        }
    }

    @Override
    void removeElem(boolean status) {
        if (block.city.getGills()<500){
            System.out.println("NOT ENOUGH MONEY");
        }else {
            block.city.changeGills(-500);
            block.elems.remove(this);
        }
    }
    @Override
    int CalculateIncome() {
        int result = 0;

        for (int i = 1; i < level; i++) {
            result += (block.city.world.day - importantDays[i]) * 100 * 20;
        }
        return result + (block.city.world.day - startingDay) * 100 * 50;
    }//todo when "done " add income to gills





}
