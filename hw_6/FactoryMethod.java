package hw_6;

// Интерфейс продукта
interface FactoryProduct {
    void use();
}

// Конкретный продукт
class ConcreteProduct implements FactoryProduct {
    @Override
    public void use() {
        System.out.println("Concrete FactoryProduct is being used");
    }
}

// Интерфейс фабрики
abstract class Creator {
    abstract FactoryProduct factoryMethod();

    void anOperation() {
        FactoryProduct product = factoryMethod();
        System.out.println("An operation with product:");
        product.use();
    }
}

// Конкретная фабрика
class ConcreteCreator extends Creator {
    @Override
    public FactoryProduct factoryMethod() {
        return new ConcreteProduct();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        FactoryProduct product = creator.factoryMethod();
        product.use();
    }
}