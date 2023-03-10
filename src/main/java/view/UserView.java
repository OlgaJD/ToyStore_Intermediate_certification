package view;

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



}
