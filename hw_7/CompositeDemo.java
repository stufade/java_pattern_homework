package hw_7;

import java.util.ArrayList;
import java.util.List;

/** "Component" */
interface Component {
    void operation();

    void add(Component component);

    void remove(Component component);

    Component getChild(int index);
}

/** "Leaf" */
class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf operation");
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }
}

/** "Composite" */
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    @Override
    public void operation() {
        System.out.println("Composite operation");
        for (Component child : children) {
            child.operation();
        }
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return children.get(index);
    }
}

/** Использование паттерна "Компоновщик" */
public class CompositeDemo {
    public static void main(String[] args) {
        Composite root = new Composite();
        Composite branch = new Composite();
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();

        root.add(branch);
        branch.add(leaf1);
        branch.add(leaf2);

        root.operation();
    }
}
