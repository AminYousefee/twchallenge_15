public class Bazar extends Elem {
    @Override
    int getScore(){
        return (int)Math.pow(5,World.world.day-startingDay);
    }

    public Bazar(Block Sup, int idToAssign) {
        super(Sup, idToAssign);
    }

    public static Bazar addBazar(Block sup, int idToAssign) {
        if (sup.sup.getGills() < 6000) {
            System.out.println("NOT ENOUGH MONEY");
        } else if (sup.numOfUnemployed < 50) {
            System.out.println("NOT ENOUGH PEOPLE");

        }else {
            return new Bazar(sup,idToAssign);
        }
    }






    int getEmployed(){
        return 50+20*(level-1);
    }

}
