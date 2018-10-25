public class Bazar extends Elem {
    @Override
    int getScore(){
        return (int)Math.pow(5,World.world.day-startingDay);
    }
    int getEmployed(){
        return 50+20*(level-1);
    }

}
