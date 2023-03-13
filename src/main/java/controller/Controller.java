package controller;

import functions.AdminFunctions;
import functions.FileWorker;
import functions.PlayerFunctions;
import functions.SystemFunction;
import model.Toy;
import view.ErrorView;
import view.UserView;
import java.util.Scanner;

public class Controller {
    public static void run(){
        Boolean online = true;
        Boolean admin = false;
        Boolean player = false;
        String playerName;
        Scanner input = new Scanner(System.in);
        SystemFunction systemWork = new SystemFunction();
        AdminFunctions adminWork = new AdminFunctions();
        PlayerFunctions playerWork = new PlayerFunctions();
        UserView userView = new UserView();
        ErrorView ErrorView = new ErrorView();
        FileWorker fileWorker = new FileWorker();
        while (online) {
            userView.mainMenu();
            switch (input.next()) {
                case "1":
                    admin = true;
                    userView.helloAdmin();
                    while (admin) {
                        userView.adminMenu();
                        switch (input.next()) {
                            case "1":
                                adminWork.getToysList();
                                break;
                            case "2":
                                adminWork.putToy();
                                break;
                            case "3":
                                adminWork.removeToy();
                                break;
                            case "4":
                                adminWork.removeToysByID();
                                break;
                            case "5":
                                systemWork.getPrizeQue();
                                break;
                            case "6":
                                admin = false;
                                break;
                            case "7":
                                userView.programmOff();
                                admin = false;
                                online = false;
                                input.close();
                                break;
                            default:
                                ErrorView.incorrectInput();
                        }
                    }
                    break;
                case "2":
                    player = true;
                    userView.hello();
                    playerName = input.next();
                    System.out.println("Отлично, "+ playerName + "!\nВыберите дальнейшую команду:\n");
                    while (player){
                        userView.playerMenu();
                        switch (input.next()) {
                            case "1":
                                Toy prize = playerWork.play();
                                systemWork.putPrizeToQue(prize);
                                userView.greeting(prize);
                                systemWork.removeToyAfterWon(prize);
                                break;
                            case "2":
                                fileWorker.saveData();
                                systemWork.removePrizeFromQue();
                                break;
                            case "3":
                                player = false;
                                userView.goodbye();
                                break;
                            default:
                                ErrorView.incorrectInput();
                        }
                    }
                    break;
                default:
                    ErrorView.incorrectInput();
            }
        }
    }

}
