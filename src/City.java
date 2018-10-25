import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class City {

    City enemy;
    private double score;
    private int gills = 30000;
    Military blockMilitary;
    int idToAssign = 1;

    ArrayList<Block> blocks;

    void addBlock() {

    }

    void removeblock(int blockid) {
        Block t1 = this.findBlockById(blockid);
        this.blocks.remove(t1);

    }


    void changeScore() {

    }

    void yield() {

    }


    void addMilitary() {
        if

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
            int tempId = Integer.parseInt(m.group(1));
            Block t1 = enemy.findBlockById(tempId);
            if (this.blockMilitary == null) {
                System.out.println("No Military Found");
            } else {
                this.blockMilitary.attack(t1);
            }

        }

        if ((m = getMatched("add\\s+block\\s+", command.toLowerCase())) != null) {
            Block temp = new Block();
            this.blocks.add(temp);

        }
        if ((m = getMatched("remove\\s+(\\d+)", command.toLowerCase())) != null) {
            int tempId = Integer.parseInt(m.group(1));
            this.removeblock(tempId);

        }
        if ((m = getMatched("upgrade\\s+(\\d+)", command.toLowerCase())) != null) {
            int tempId = Integer.parseInt(m.group(1));
            this.findBlockById(tempId).upgradeBlock();

        }
        if ((m = getMatched("add\\s+army\\s+(\\d+)", command.toLowerCase())) != null) {
            int tempId = Integer.parseInt(m.group(1));
            if (this.blockMilitary != null) {
                System.out.println("Military Already Exists");
            } else {
                Military t1 = new Military();
                this.findBlockById(tempId).addElem(t1);
            }

        }
        if ((m = getMatched("add\\s+defense\\s+(\\d+)", command.toLowerCase())) != null) {
            int tempId = Integer.parseInt(m.group(1));
            if (this.findBlockById(tempId).blockDefense != null) {
                System.out.println("Defense Already Exists");
            } else {
                Defense t1 = new Defense();
                this.findBlockById(tempId).addElem(t1);
            }

        }
        if ((m = getMatched("add\\s+bazar\\s+(\\d+)", command.toLowerCase())) != null) {
            int tempId = Integer.parseInt(m.group(1));
            Bazar t1 = new Bazar();
            this.findBlockById(tempId).addElem(t1);
        }
        if ((m = getMatched("add\\s+bazar\\s+(\\d+)", command.toLowerCase())) != null) {
            int tempId = Integer.parseInt(m.group(1));
            Bazar t1 = new Bazar();
            this.findBlockById(tempId).addElem(t1);
        }
        if ((m = getMatched("add\\s+home\\s+(\\d+)\\s+(\\d+)+\\s+(\\d+)", command.toLowerCase())) != null) {
            int tempId = Integer.parseInt(m.group(1));
            int tempNumOfFloor = Integer.parseInt(m.group(2));
            int tempNumOfUnits = Integer.parseInt(m.group(3));
            Gildoni t1 = new Gildoni(tempNumOfFloor, tempNumOfUnits);
            this.findBlockById(tempId).addElem(t1);
        }
        //todo
        if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s+floor", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int unitId = Integer.parseInt(m.group(2));

        }

        if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s+unit", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int unitId = Integer.parseInt(m.group(2));
            int tempNumOfUnits = Integer.parseInt(m.group(3));
            Gildoni t1 = new Gildoni(tempNumOfFloor, tempNumOfUnits);
            this.findBlockById(tempId).addElem(t1);
        }
        if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s+floor\\s+unit", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int unitId = Integer.parseInt(m.group(2));
            int tempNumOfUnits = Integer.parseInt(m.group(3));
            Gildoni t1 = new Gildoni(tempNumOfFloor, tempNumOfUnits);
            this.findBlockById(tempId).addElem(t1);
        }





//todo





    }

    private Matcher getMatched(String strPattern, String input) {
        Pattern pattern = Pattern.compile(strPattern);
        Matcher m = pattern.matcher(input);
        if (!m.find())
            return null;
        return m;
    }


    public int  getScore() {
        int sum = 0;
        for (Block index : blocks) {
            sum += index.getScore();
        }
        return sum;
    }

    public int getGills() {
        return gills;
    }

    public void setEnemy(City enemy) {
        this.enemy = enemy;
    }


    Block findBlockById(int id) {
        for (Block index : this.blocks) {
            if (index.getId() == id) {
                return index;
            }
        }
        System.out.println("Block Not Found");
        return null;
    }


    void changeGills(int change) {
        gills += change;
    }


}
