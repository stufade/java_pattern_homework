package hw_7;

import java.util.HashMap;
import java.util.Map;

// Интерфейс Flyweight
interface Flyweight {
    void operation(String extrinsicState);
}

// Конкретная реализация Flyweight, которая может разделяться
class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println(
                "Интринзическое состояние: " + intrinsicState + ", экстризическое состояние: " + extrinsicState);
    }
}

// Конкретная реализация Flyweight, которая не разделяется
class UnsharedConcreteFlyweight implements Flyweight {
    private String allState;

    public UnsharedConcreteFlyweight(String allState) {
        this.allState = allState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("Все состояние: " + allState + ", экстризическое состояние: " + extrinsicState);
    }
}

// Фабрика для создания и управления Flyweight объектами
class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}

// Демонстрация использования паттерна Легковес
public class FlyweightDemo {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight fw1 = factory.getFlyweight("state1");
        fw1.operation("extrinsic1");

        Flyweight fw2 = factory.getFlyweight("state1");
        fw2.operation("extrinsic2"); // fw1 и fw2 это один и тот же объект

        Flyweight fw3 = new UnsharedConcreteFlyweight("unique");
        fw3.operation("extrinsic3"); // не использует общий объект
    }
}
