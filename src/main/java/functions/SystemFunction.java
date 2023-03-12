package functions;
import model.Toy;
import java.util.ArrayDeque;

public class SystemFunction {

    public static ArrayDeque<Toy> prizeQue = new ArrayDeque<>();

    public void putPrizeToQue(Toy prize) {
        prizeQue.addLast(prize);
    }

    public void removePrize() {
        prizeQue.pop();
    }

    public void getPrizeQue(){
        for (Toy prize: prizeQue) {
            System.out.println(prize.getToyInfo());

        }
    }

    public String getDataSave() {
        Toy toArchive = prizeQue.getFirst();
        return toArchive.getToyInfoArchive() + "\n";
    }


}