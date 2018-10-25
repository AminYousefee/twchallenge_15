public class Bazar extends Elem {
    @Override
    int getScore(){
        return (int)Math.pow(5,World.world.day-startingDay);
    }

}
