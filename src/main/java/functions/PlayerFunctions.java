package functions;

import model.Toy;

import static model.Toy.toysList;

public class PlayerFunctions {

    public Toy play() {
        Toy prize = new Toy();
        prize = toysList.get(0); // test не добавлен алгоритм выбора случайной игрушки
        prize.setAmount(1);
        return prize;
    }




}

