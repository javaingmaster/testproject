package zty.java.component;

public class Client {
	public static void main(String[] args)
    {
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();

        Composite composite1 = new Composite();
        composite1.add(leaf1);
        composite1.add(leaf2);

        Component leaf3 = new Leaf();
        Component leaf4 = new Leaf();

        Composite composite2 = new Composite();
        composite2.add(composite1);
        composite2.add(leaf3);
        composite2.add(leaf4);

        // Composite和Leaf执行起来无差别：
        composite2.dosomething();
        leaf4.dosomething();
    }
}
