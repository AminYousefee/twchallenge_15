import java.util.Scanner;

public class World {
    static World world;
    public int day;
    City a;
    City b;


    private World() {
    }

    public static void main(String[] args) {
        world= new World();
        world.a=new City();
        world.b = new City();
        world.a.enemy=world.b;
        world.b.enemy=world.a;
        boolean flag =false;
        Scanner s =new Scanner(System.in);
        City temp=world.a;
        while (flag){
            String t =s.nextLine();
            if (t.equals("done")){
                if (temp==world.a){
                    temp=world.b;
                }else {
                    temp=world.a;
                }
            }else {
                temp.processCommand(t);
            }




        }







    }
    void addDay(){

    }








    void isFinished(){

    }






}
