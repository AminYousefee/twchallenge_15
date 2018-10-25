    public class Army extends Elem{
    double MilPoewr = 0.2;

        @Override
        void upgradeElem() {
            if (this.MilPoewr >= 1){
                System.out.println("not possible");
            }else {
                this.MilPoewr += 0.2;
            }
        }

    }
