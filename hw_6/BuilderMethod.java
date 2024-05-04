package hw_6;

// Продукт, который мы строим
class Product {
    private String part1;
    private String part2;

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public String toString() {
        return "Product{part1='" + part1 + "', part2='" + part2 + "'}";
    }
}

// Интерфейс строителя
interface Builder {
    void buildPart1();

    void buildPart2();

    Product getResult();
}

// Конкретный строитель
class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPart1() {
        product.setPart1("Part1 built");
    }

    @Override
    public void buildPart2() {
        product.setPart2("Part2 built");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

// Директор, который управляет строителем
class Director {
    public Product construct(Builder builder) {
        builder.buildPart1();
        builder.buildPart2();
        return builder.getResult();
    }
}

// Пример использования
public class BuilderMethod {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new ConcreteBuilder();

        Product product = director.construct(builder);
        System.out.println("Product built: " + product);
    }
}
