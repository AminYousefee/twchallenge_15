import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class City {

    City enemy;
    private double score;
    private int gills;
    Military blockMilitary;

    ArrayList<Block> blocks;

    void addBlock() {

    }

    void removeblock(int blockid) {

    }


    void changeScore() {

    }

    void yield() {

    }


    void addMilitary() {

    }

    void removeMilitary() {

    }


    void processCommand(String command) {
        if (command.equalsIgnoreCase("See score")) {
            System.out.println(this.getScore());
        }
        if (command.equals("See gills")) {
            System.out.println(this.getGills());
        }

        Matcher m;

        if ((m = getMatched("attack\\s+\\[(\\d+)\\]", command)) != null) {
            int tempId= Integer.parseInt(m.group(1));
            Block t1 = enemy.findBlockById(tempId);
            if (this.blockMilitary==null){
                System.out.println("No Military Found");
            }
            else {
                this.blockMilitary.attack(t1);
            }

        }
    }

    private Matcher getMatched(String strPattern, String input) {
        Pattern pattern = Pattern.compile(strPattern);
        Matcher m = pattern.matcher(input);
        if (!m.find())
            return null;
        return m;
    }


    public double getScore() {
        return score;
    }

    public int getGills() {
        return gills;
    }

    public void setEnemy(City enemy) {
        this.enemy = enemy;
    }







    Block findBlockById(int id){
        for (Block index:this.blocks){
            if(index.getId()==id){
                return index;
            }
        }
    }

}
