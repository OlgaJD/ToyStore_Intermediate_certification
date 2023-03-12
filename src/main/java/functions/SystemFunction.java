package functions;
import model.Toy;
import view.ErrorView;
import view.UserView;

import java.util.ArrayDeque;

import static model.Toy.toysList;

public class SystemFunction {

    public static ArrayDeque<Toy> prizeQue = new ArrayDeque<>();

    public void putPrizeToQue(Toy prize) {
        prizeQue.addLast(prize);
    }

    public void removePrizeFromQue() {
        Toy prizeOutFirst = prizeQue.getFirst();
        System.out.println("Спасибо за участие! Ваш приз " + prizeOutFirst.getName() + " ждет вас!");
        prizeQue.pop();
    }

    public void getPrizeQue(){
        for (Toy prize: prizeQue) {
            System.out.println(prize.getToyInfo());
        }
    }

    public String getDataSave() {
        Toy toArchive = prizeQue.getFirst();
        return toArchive.getToyInfoArchive();
    }


    public void removeToyAfterWonPrize(Toy prize){
        String nameToy = prize.getName();
        int index = -1;
        for (int i = 0; i < toysList.size(); i++) {
            if (toysList.get(i).getName().equals(nameToy)) {
                index = i;
                if (toysList.get(i).getAmount() == 1) {
                    toysList.remove(index);
                }
                else {
                    int count = toysList.get(i).getAmount();
                    toysList.get(i).setAmount(count-1);
                }
                return;
            }
        }
    }

}