package view;

import model.Toy;

import java.util.Scanner;

public class UserView {
    Scanner input = new Scanner(System.in);

    public void actualToysList() {
        System.out.println("Актуальный список игрушек, учавствующих в розыгрыше:");
    }

    public String giveToyName(){
        System.out.println("Введите название игрушки: ");
        return input.nextLine();
    }

    public int giveToyAmount() {
        System.out.println("Введите количество: ");
        while (true) {
            while (!input.hasNextInt()) {
                System.out.println("Это не число, попробуйте еще раз");
                input.next();
            }
            int amount = input.nextInt();
            if (amount < 0) {
                System.out.println("Число должно быть больше 0, попробуйте еще раз");
            } else {
                return amount;
            }
        }
    }

    public int giveToyDropChance() {
        System.out.println("Введите шанс выпадения для игрушки от 1 до 100: ");
        while (true) {
            while (!input.hasNextInt()) {
                System.out.println("Это не число, попробуйте еще раз");
                input.next();
            }
            int dropChance = input.nextInt();
            if (dropChance < 1 || dropChance > 100) {
                System.out.println("Число должно быть от 1 до  100, попробуйте еще раз");
            } else {
                return dropChance;
            }
        }
    }

    public void succesToyAdd(){
        System.out.println("Новая игрушка успешно добавлена");
    }

    public void succesToyremove() {
        System.out.println("Игрушка удалена в количестве 1 шт.");
    }


    public void mainMenu() {
        System.out.println("Вы находитесь в главном меню.\n" +
                "1 - для входа от имени администратора\n" +
                "2 - для входа игрока\n");
    }

    public void adminMenu() {
        System.out.println("1 - Посмотреть список игрушек учавствующих в розыгрыше\n"+
                "2 - Добавить новую игрушку\n" +
                "3 - Быстрое удаление игрушки по названию (1 шт.)\n" +
                "4 - Посмотреть очередь на выдачу\n" +
                "5 - Выйти из режима администратора\n"+
                "6 - Завершить работу программы\n");
    }

    public void playerMenu() {
        System.out.println("1 - чтобы начать играть\n" +
                "2 - чтобы забрать приз\n" +
                "3 - для выхода из игры\n");
    }

    public void greeting(Toy prize) {
        System.out.println("Поздравляем! Ваш выйгрыш - " + prize.getName());
    }

    public void goodbye() {
        System.out.println("До новых встреч!");
    }







}
