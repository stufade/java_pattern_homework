package hw_8;

import java.util.ArrayList;
import java.util.List;

// Интерфейс Visitor с методами для каждого типа элемента
interface Visitor {
    void visitElementA(ConcreteElementA elementA);

    void visitElementB(ConcreteElementB elementB);
}

// Интерфейс Element с методом accept для принятия посетителя
interface Element {
    void accept(Visitor visitor);
}

// Конкретный класс элемента A
class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }

    public void operationA() {
        System.out.println("Операция А");
    }
}

// Конкретный класс элемента B
class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }

    public void operationB() {
        System.out.println("Операция B");
    }
}

// Конкретная реализация посетителя
class ConcreteVisitor implements Visitor {
    @Override
    public void visitElementA(ConcreteElementA elementA) {
        System.out.println("Посетитель обрабатывает ConcreteElementA.");
        elementA.operationA();
    }

    @Override
    public void visitElementB(ConcreteElementB elementB) {
        System.out.println("Посетитель обрабатывает ConcreteElementB.");
        elementB.operationB();
    }
}

// Клиентский класс для демонстрации использования паттерна Посетитель
public class VisitorDemo {
    public static void main(String[] args) {
        List<Element> elements = new ArrayList<>();
        elements.add(new ConcreteElementA());
        elements.add(new ConcreteElementB());

        Visitor visitor = new ConcreteVisitor();

        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
