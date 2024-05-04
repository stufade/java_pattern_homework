package hw_6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Фабричный:");
        Creator creator = new ConcreteCreator();
        FactoryProduct product = creator.factoryMethod();
        product.use();
        //
        System.out.println();
        System.out.println("Прототип:");
        try {
            Prototype original = new Prototype("Original data");

            // Клонируем объект
            Prototype clone = original.clone();

            // Меняем данные в клоне
            clone.setData("Cloned data");

            System.out.println("Original data: " + original.getData());
            System.out.println("Cloned data: " + clone.getData());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //
        System.out.println();
        System.out.println("Абстрактная фабрика:");
        AbstractFactory factory = new ConcreteFactory();
        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();

        productA.createA();
        productB.createB();
        //
        System.out.println();
        System.out.print("Строиттель:");
        Director director = new Director();
        Builder builder = new ConcreteBuilder();

        Product product1 = director.construct(builder);
        System.out.println("Product built: " + product1);
    }
}
