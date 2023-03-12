package functions;

import static model.Toy.toysList;
import view.*;
import model.Toy;

public class AdminFunctions {

    public void getToysList(){
        UserView adminView = new UserView();
        if (toysList.isEmpty()){
            System.out.println("Лист пуст");
        } else {
            adminView.actualToysList();
            toysList.forEach(n -> System.out.println(n.getToyInfo()));
            System.out.println();
        }
    }

    private Toy createToy() {
        Toy newToy = new Toy();
        UserView adminView = new UserView();
        newToy.setId(Toy.newId());
        newToy.setName(adminView.giveToyName());
        newToy.setAmount(adminView.giveToyAmount());
        newToy.setDropChance(adminView.giveToyDropChance());
        return newToy;
    }

    public void putToy() {
        UserView adminView = new UserView();
        Toy newToy = createToy();
        if(!toysList.isEmpty()) {  // функция не доработана. сразвнивает и правильно работает только с первыйм значением в цикле
            for (Toy toy: toysList) {
                if(toy.getName().equals(newToy.getName()) && toy.getDropChance() == newToy.getDropChance()) {
                    toy.setAmount(toy.getAmount() + newToy.getAmount());
                    adminView.succesToyAdd();
                    return;
                }
                toysList.add(newToy);
                adminView.succesToyAdd();
                return;
            }
        }
        if(toysList.isEmpty()) {
            toysList.add(newToy);
            adminView.succesToyAdd();
        }

    }

    public void removeToy(){
        UserView adminView = new UserView();
        ErrorView adminErrorView = new ErrorView();
        String nameToy = adminView.giveToyName();
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
        adminErrorView.unSuccesToyFind();
    }

}
