//    mainMenu() // завершить программу может только администратор
//          1 - для входа от имени администратора
//          2 - для входа игрока
//          adminMenu()
//              1 - Посмотреть список игрушек
//              2 - Добавить новую игрушку
//              3 - Убрать игрушку
//              4 - Посмотреть очередь
//              5 - Выйти из режима администратора
//              6 - Завершить работу программы
//          playerMenu()
//             1 - чтобы начать играть нажмите
//             2 - чтобы забрать приз нажмите
//             3 - для выхода из игры нажмите
//
//      Исключения

package controller;

import functions.AdminFunctions;
import view.ErrorView;
import view.UserView;

import java.util.Scanner;
import static model.Toy.toysList;

public class Controller {
    public static void run(){
        Boolean online = true;
        Boolean admin = false;
        Boolean player = false;
        String playerName;
        Scanner input = new Scanner(System.in);
        AdminFunctions adminWork = new AdminFunctions();
        UserView userView = new UserView();
        ErrorView ErrorView = new ErrorView();
        while (online) {
            userView.mainMenu();
            switch (input.next()) {
                case "1":
                    admin = true;
                    System.out.println("Вы вошли как администратор. Выберите пункт меню: ");
                    while (admin) {
                        userView.adminMenu();
                        switch (input.next()) {
                            case "1":
                                userView.actualToysList();
                                adminWork.getToysList();
                                break;
                            case "2":
                                adminWork.putToy();
                                toysList.forEach(n -> System.out.println(n.getToyInfo())); // проверка, добавляет, но меняет количество при совпадении только у первой позиции
                                System.out.println("Добавить");
                                break;
                            case "3":
                                adminWork.removeToy();
                                userView.succesToyremove();
                                System.out.println("Убрать");
                                break;
                            case "4":
                                System.out.println("очередь");
                                break;
                            case "5":
                                admin = false;
                                break;
                            case "6":
                                userView.goodbye();
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
                    System.out.println("Приветствую Вас на розыгрыше призов!\n" +
                            "Введите свое имя для участия:\n");
                    playerName = input.next();
                    System.out.println("Отлично, "+ playerName + "!\nВыберите дальнейшую команду:\n");
                    while (player){
                        userView.playerMenu();
                        switch (input.next()) {
                            case "1":
                                System.out.println("играть");
                                break;
                            case "2":
                                System.out.println("забрать");
                                break;
                            case "3":
                                System.out.println("выход");
                                player = false;
                                System.out.println("");
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
