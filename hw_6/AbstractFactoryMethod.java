package hw_6;

// Интерфейс для продукта А
interface ProductA {
    void createA();
}

// Интерфейс для продукта B
interface ProductB {
    void createB();
}

// Интерфейс для абстрактной фабрики
interface AbstractFactory {
    ProductA createProductA();

    ProductB createProductB();
}

// Конкретная реализация продукта A
class ConcreteProductA implements ProductA {
    @Override
    public void createA() {
        System.out.println("Concrete Product A created");
    }
}

// Конкретная реализация продукта B
class ConcreteProductB implements ProductB {
    @Override
    public void createB() {
        System.out.println("Concrete Product B created");
    }
}

// Конкретная реализация абстрактной фабрики
class ConcreteFactory implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB();
    }
}

public class AbstractFactoryMethod {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();

        productA.createA();
        productB.createB();
    }
}