package view;

public class ErrorView {
    public void incorrectInput() {
        System.out.println("Команда введена неверно\n");
    }

    public void actualToysListIsEmpty() {
        System.out.println("Список пуст");
    }

    public void unSuccesToyFind() {
        System.out.println("Такой игрушки нет в списке для розыгрыша\n");
    }
}
