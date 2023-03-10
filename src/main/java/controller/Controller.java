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

import java.util.Scanner;

public class Controller {
    public static void run(){
        Boolean online = true;
        Boolean admin = false;
        Boolean player = false;
        String playerName;
        Scanner input = new Scanner(System.in);
        while (online) {
            System.out.println("1 - для входа от имени администратора\n" +
                    "2 - для входа игрока\n");
            switch (input.next()) {
                case "1":
                    admin = true;
                    System.out.println("Вы вошли как администратор. Выберите пункт меню: ");
                    while (admin) {
                        System.out.println("1 - Посмотреть список игрушек учавствующих в розыгрыше\n"+
                                "2 - Добавить новую игрушку\n" +
                                "3 - Убрать игрушку\n" +
                                "4 - Посмотреть очередь на выдачу\n" +
                                "5 - Выйти из режима администратора\n"+
                                "6 - Завершить работу программы\n");
                        switch (input.next()) {
                            case "1":
                                System.out.println("список игрушек");
                                break;
                            case "2":
                                System.out.println("Добавить");
                                break;
                            case "3":
                                System.out.println("Убрать");
                                break;
                            case "4":
                                System.out.println("очередь");
                                break;
                            case "5":
                                System.out.println("Выйти");
                                admin = false;
                                break;
                            case "6":
                                System.out.println("До новых встреч!");
                                admin = false;
                                online = false;
                                break;
                            default:
                                System.out.println("Команда введена неверно\n");
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
                        System.out.println("" +
                                "1 - чтобы начать играть нажмите\n" +
                                "2 - чтобы забрать приз нажмите\n" +
                                "3 - для выхода из игры нажмите\n");
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
                                System.out.println("Команда введена неверно\n");
                        }
                    }
                    break;
                default:
                    System.out.println("Команда введена неверно\n");
            }

        }

    }




}
