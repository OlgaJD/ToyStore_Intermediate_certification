package functions;

import model.Toy;
import java.util.*;
import static model.Toy.toysList;

public class PlayerFunctions {

    public Toy play() {
        Toy prize = new Toy();
        prize = winner();
        prize.setAmount(1);
        return prize;
    }

    public Toy winner() {
        double sumDropChance = 0.0;
        for (Toy toy : toysList) {
            sumDropChance += toy.getDropChance();
        }
        Random random = new Random();
        double rnd = random.nextDouble(0.5, 0.9) * sumDropChance;
        double nDropChance = 0.0;
        Toy resultToy = new Toy();
        for (Toy toy : toysList) {
            nDropChance += toy.getDropChance();
            if (nDropChance >= rnd) {
                    resultToy.setId(toy.getId());
                    resultToy.setName(toy.getName());
                    resultToy.setDropChance(toy.getDropChance());
                    resultToy.setAmount(1);
                break;
            }
        }
        return resultToy;
    }
}


