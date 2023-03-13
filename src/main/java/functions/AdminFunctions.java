package functions;

import static model.Toy.toysList;
import view.*;
import model.Toy;

public class AdminFunctions {

    public void getToysList(){
        UserView adminView = new UserView();
        ErrorView adminErrorView = new ErrorView();
        if (toysList.isEmpty()){
            adminErrorView.actualToysListIsEmpty();
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
        boolean done = false;
        for (Toy toy : toysList) {
            if (toy.getName().equalsIgnoreCase(newToy.getName())) {
                toy.setAmount(toy.getAmount() + newToy.getAmount());
                adminView.succesToyAdd();
                done = true;
            }
        }
        if (!done) {
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
                    adminView.succesToyremove();
                }
                else {
                    int count = toysList.get(i).getAmount();
                    toysList.get(i).setAmount(count-1);
                    adminView.succesToyremove();
                }
                return;
            }
        }
        adminErrorView.unSuccesToyFind();
    }

//    public void removeToysByID() {
//        ErrorView adminErrorView = new ErrorView();
//        UserView adminView = new UserView();
//        int removeIndex = adminView.getIdForRemove();
//        int index = -1;
//        for (int i = 0; i < toysList.size(); i++) {
//            if (toysList.get((i)).getId() == removeIndex) {
//                index = i;
////                toysList.remove(i);
////                System.out.println("Удалено");
////                return;
//            }
//        }
//        toysList.remove(index);
//        System.out.println("Удалено");
//    }


    public void removeToysByID() {
        UserView adminView = new UserView();
        int removeIndex = adminView.getIdForRemove();
        try {
            for (int i = 0; i < toysList.size(); i++) {
                if (toysList.get((i)).getId() == removeIndex) {
                    toysList.remove(i);
                }
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
