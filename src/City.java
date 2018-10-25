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
        this.changeGills(500);

    }


    void changeScore() {

    }

    void yield() {

    }


    void removeMilitary() {

    }


    void processCommand(String command) {
        //todo a very big method


        //See Score
        if (command.equalsIgnoreCase("See score")) {
            System.out.println(this.getScore());
        }

        //See gills
        if (command.equals("See gills")) {
            System.out.println(this.getGills());
        }

        Matcher m;


        //When the player wants to attack
        if ((m = getMatched("attack\\s+\\[(\\d+)\\]", command)) != null) {
            int tempId = Integer.parseInt(m.group(1));
            Block t1 = enemy.findBlockById(tempId);
            if (this.blockMilitary == null) {
                System.out.println("No Military Found");
            } else {
                this.blockMilitary.attack(t1);
            }

        }

        //To add new block
        if ((m = getMatched("add\\s+block\\s+", command.toLowerCase())) != null) {
            Block temp = Block.addBlock(this, idToAssign);

            if (temp != null) {
                this.blocks.add(temp);
                idToAssign++;
            }
        }

        //To remove a block
        if ((m = getMatched("remove\\s+(\\d+)", command.toLowerCase())) != null) {
            int tempId = Integer.parseInt(m.group(1));
            this.removeblock(tempId);

        }

        //To upgrade a block
        if ((m = getMatched("upgrade\\s+(\\d+)", command.toLowerCase())) != null) {
            int tempId = Integer.parseInt(m.group(1));
            this.findBlockById(tempId).upgradeBlock();

        }
        //To add new army
        if ((m = getMatched("add\\s+army\\s+(\\d+)", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            if (this.blockMilitary != null) {
                System.out.println("Military Already Exists");
            } else if (this.findBlockById(blockId).hasCapasity()) {
                Military t1 = Military.addElem(this.findBlockById(blockId),idToAssign);
                if(t1!=null){
                    idToAssign++;
                    this.findBlockById(blockId).elems.add(t1);
                }

            }
        }

        //To add defense
        if ((m = getMatched("add\\s+defense\\s+(\\d+)", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            if (this.findBlockById(blockId).blockDefense != null) {
                System.out.println("Defense Already Exists");
            } else if (this.findBlockById(blockId).hasCapasity()) {
                Defense t1 = Defense.addElem(this.findBlockById(blockId),idToAssign)
                if(t1!=null){
                    idToAssign++;
                    this.findBlockById(blockId).elems.add(t1);
                }
            }

        }


        //
        if ((m = getMatched("add\\s+bazar\\s+(\\d+)", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            if (this.findBlockById(blockId).hasCapasity()) {
                Bazar t1 = new Bazar();
                this.findBlockById(blockId).addElem(t1);
            }
        }
        if ((m = getMatched("add\\s+home\\s+(\\d+)\\s+(\\d+)+\\s+(\\d+)", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int tempNumOfFloor = Integer.parseInt(m.group(2));
            int tempNumOfUnits = Integer.parseInt(m.group(3));
            if (this.findBlockById(blockId).hasCapasity()) {
                Home t1 = new Home(tempNumOfFloor, tempNumOfUnits);
                this.findBlockById(blockId).addElem(t1);
            }
        }

        if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s+floor", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int elemId = Integer.parseInt(m.group(2));
            if (this.findBlockById(blockId).findElemById(elemId) instanceof Home) {
                ((Home) this.findBlockById(blockId).findElemById(elemId)).addFloor();
            } else {
                System.out.println("NOT GILDONI");
            }

        }

        if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s+unit", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int elemId = Integer.parseInt(m.group(2));
            if (this.findBlockById(blockId).findElemById(elemId) instanceof Home) {
                ((Home) this.findBlockById(blockId).findElemById(elemId)).addUnit();
            } else {
                System.out.println("NOT GILDONI");
            }
        }
        if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s+floor\\s+unit", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int elemId = Integer.parseInt(m.group(2));

            if (this.findBlockById(blockId).findElemById(elemId) instanceof Home) {
                ((Home) this.findBlockById(blockId).findElemById(elemId)).addUnit();
                ((Home) this.findBlockById(blockId).findElemById(elemId)).addFloor();
            } else {
                System.out.println("NOT GILDONI");
            }
        }
        if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s+unit\\s+floor", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int elemId = Integer.parseInt(m.group(2));

            if (this.findBlockById(blockId).findElemById(elemId) instanceof Home) {
                ((Home) this.findBlockById(blockId).findElemById(elemId)).addUnit();
                ((Home) this.findBlockById(blockId).findElemById(elemId)).addFloor();
            } else {
                System.out.println("NOT GILDONI");
            }
        }
        if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int elemId = Integer.parseInt(m.group(2));

            if (this.findBlockById(blockId).findElemById(elemId) instanceof Home) {
                System.out.println("GILDONIEH");
            } else {
                this.findBlockById(blockId).findElemById(elemId).upgradeElem();
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


    public int getScore() {
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
