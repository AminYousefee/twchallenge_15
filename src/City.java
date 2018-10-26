import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class City {
    World world;
    City enemy;
    private double score;
    private int gills = 30000;
    Military blockMilitary;
    int idToAssign = 1;

    ArrayList<Block> blocks;

    public City(World world1) {
        world = world1;
        //todo
        blocks = new ArrayList<Block>(0);

    }


    void addBlock() {

    }

    void removeBlock(int blockId) {
        Block t1 = this.findBlockById(blockId);
        for (Elem index : t1.elems) {
            index.removeElem(false);
        }
        this.blocks.remove(t1);
        this.changeGills(500);

    }


    void changeScore(double score) {
        this.score += score;

    }

    void yield() {

    }


    void removeMilitary() {

    }


    void processCommand(String command) {
        Matcher m;
        //todo a very big method


        //See Score
        if (command.equalsIgnoreCase("See score")) {
            System.out.format("%.2f\n", this.getScore());
            //todo a big bug
        }

        //See gills
        else if (command.equalsIgnoreCase("See gills")) {
            System.out.println(this.getGills());
        }


        //When the player wants to attack
        else if ((m = getMatched("attack\\s+\\[(\\d+)\\]", command)) != null) {
            int tempId = Integer.parseInt(m.group(1));
            Block t1 = enemy.findBlockById(tempId);
            if (this.blockMilitary == null) {
                System.out.println("No Military Found");
            } else {
                this.blockMilitary.attack(t1);
            }

        }


        //When the player wants to loot
        else if ((m = getMatched("attack\\s+\\[(\\d+)\\]", command)) != null) {
            int tempId = Integer.parseInt(m.group(1));
            Block t1 = enemy.findBlockById(tempId);
            if (this.blockMilitary == null) {
                System.out.println("No Military Found");
            } else {
                this.blockMilitary.loot(t1);
            }

        }


        //To add new block
        else if ((m = getMatched("add\\s+block\\s*$", command.toLowerCase())) != null) {
            Block temp = Block.addBlock(this, idToAssign);

            if (temp != null) {
                this.blocks.add(temp);
                idToAssign++;
            }
        }

        //To remove a block
        else if ((m = getMatched("remove\\s+(\\d+)\\s*$", command.toLowerCase())) != null) {
            int tempId = Integer.parseInt(m.group(1));
            this.removeBlock(tempId);

        }

        //To upgrade a block
        else if ((m = getMatched("upgrade\\s+(\\d+)\\s*$", command.toLowerCase())) != null) {
            int tempId = Integer.parseInt(m.group(1));
            this.findBlockById(tempId).upgradeBlock();

        }
        //To add new military
        else if ((m = getMatched("add\\s+army\\s+(\\d+)\\s*$", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            Block tempBlock = this.findBlockById(blockId);
            if (this.blockMilitary != null) {
                System.out.println("Military Already Exists");
            } else if (tempBlock.hasCapasity()) {
                Military t1 = Military.addMilitary(tempBlock, tempBlock.getNumToAssign());
                if (t1 != null) {
                    tempBlock.addNumToAssign();
                    this.findBlockById(blockId).elems.add(t1);
                }

            }
        }

        //To add defense
        else if ((m = getMatched("add\\s+defense\\s+(\\d+)\\s*$", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            Block tempBlock = this.findBlockById(blockId);
            if (tempBlock.blockDefense != null) {
                System.out.println("Defense Already Exists");
            } else if (tempBlock.hasCapasity()) {
                Defense t1 = Defense.addDefense(tempBlock, tempBlock.getNumToAssign());
                if (t1 != null) {
                    tempBlock.addNumToAssign();
                    tempBlock.elems.add(t1);
                }
            }

        }


        //To add Bazar
        else if ((m = getMatched("add\\s+bazaar\\s+(\\d+)\\s*$", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            Block tempBlock = this.findBlockById(blockId);
            if (tempBlock.hasCapasity()) {
                Bazar t1 = Bazar.addBazar(tempBlock, tempBlock.getNumToAssign());
                if (t1 != null) {
                    tempBlock.addNumToAssign();
                    tempBlock.elems.add(t1);
                }
            }
        }


        //To add Home
        else if ((m = getMatched("add\\s+home\\s+(\\d+)\\s+(\\d+)+\\s+(\\d+)\\s*$", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int tempNumOfFloor = Integer.parseInt(m.group(2));
            int tempNumOfUnits = Integer.parseInt(m.group(3));
            Block tempBlock = findBlockById(blockId);
            if (tempBlock.hasCapasity()) {
                Home t1 = Home.addHome(tempBlock, tempBlock.getNumToAssign(), tempNumOfFloor, tempNumOfUnits);
                if (t1 != null) {
                    tempBlock.addNumToAssign();
                    tempBlock.elems.add(t1);
                }
            }
        }


        // To add floor to a home
        else if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s+floor\\s*$", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int elemId = Integer.parseInt(m.group(2));
            if (this.findBlockById(blockId).findElemById(elemId) instanceof Home) {
                ((Home) this.findBlockById(blockId).findElemById(elemId)).addFloor();
            } else {
                System.out.println("NOT GILDONI");
            }

        }


        //To add unit to a home
        else if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s+unit\\s*$", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int elemId = Integer.parseInt(m.group(2));
            if (this.findBlockById(blockId).findElemById(elemId) instanceof Home) {
                ((Home) this.findBlockById(blockId).findElemById(elemId)).addUnit();
            } else {
                System.out.println("NOT GILDONI");
            }
        }


        //add unit and floor to home
        else if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s+floor\\s+unit\\s*$", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int elemId = Integer.parseInt(m.group(2));

            if (this.findBlockById(blockId).findElemById(elemId) instanceof Home) {
                ((Home) this.findBlockById(blockId).findElemById(elemId)).addFloorAndUnit();
            } else {
                System.out.println("NOT GILDONI");
            }
        }


        //add unit and floor to home
        else if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s+unit\\s+floor\\s*$", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int elemId = Integer.parseInt(m.group(2));

            if (this.findBlockById(blockId).findElemById(elemId) instanceof Home) {
                ((Home) this.findBlockById(blockId).findElemById(elemId)).addFloorAndUnit();
            } else {
                System.out.println("NOT GILDONI");
            }
        }


        //upgrade units
        else if ((m = getMatched("upgrade\\s+(\\d+)\\s+(\\d+)\\s*$", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int elemId = Integer.parseInt(m.group(2));

            if (this.findBlockById(blockId).findElemById(elemId) instanceof Home) {
                System.out.println("GILDONIEH");
            } else {
                this.findBlockById(blockId).findElemById(elemId).upgradeElem();
            }
        }


        //remove elems

        else if ((m = getMatched("remove\\s+(\\d+)\\s+(\\d+)\\s*$", command.toLowerCase())) != null) {
            int blockId = Integer.parseInt(m.group(1));
            int elemId = Integer.parseInt(m.group(2));

            this.findBlockById(blockId).findElemById(elemId).removeElem(true);

        }


        //When the player wants to yield
        else if (command.equalsIgnoreCase("YIELD")) {
            world.flag = true;
        } else {
            System.out.println("command not found");
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
        double sum = score;
        if (blocks == null)
            return 0;
        else {
            for (Block index : blocks) {
                if (index != null) {
                    sum += index.getScore();
                }
            }
            return sum;
        }
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


    void done() {
        int res = 0;
        for (Block block : blocks) {
            res += block.calculateIncome();
        }
        changeGills(res);
    }


}
