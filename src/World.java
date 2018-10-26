import java.util.Scanner;

public class World {
    //static World world;
    public int day = 0;
    City a;
    City b;
    boolean flag = false;


    private World() {
    }

    public static void main(String[] args) {
        World world = new World();
        world.a = new City(world);
        world.b = new City(world);
        world.a.enemy = world.b;
        world.b.enemy = world.a;

        Scanner s = new Scanner(System.in);
        City temp = world.a;
        while (!world.flag) {
            String t = s.nextLine();
            if (t.equals("done")) {
                world.day++;
                if (temp == world.a) {
                    temp.done();
                    temp = world.b;
                } else {
                    temp.done();
                    temp = world.a;

                }
            } else {
                temp.processCommand(t);
            }


        }
        System.out.println("a scored");
        System.out.println(world.a.getScore());
        System.out.println("b scored");
        System.out.println(world.a.getScore());


    }

    void addDay() {

    }


    void isFinished() {

    }


}
