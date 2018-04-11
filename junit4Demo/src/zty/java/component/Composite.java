package zty.java.component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{

	// List的类型是接口类型Component，这样就既可以放Leaf，又可以放Composite
    private List<Component> list = new ArrayList<Component>();

    public void add(Component component)
    {
        list.add(component);
    }

    public void remove(Component component)
    {
        list.remove(component);
    }

    public List<Component> getAll()
    {
        return this.list;
    }


	@Override
	public void dosomething() {
		for (Component component : list)
        {
            // 如果是叶子，直接执行
            // 如果是复合的，则继续遍历其中包含的list
            component.dosomething();
        }
	}
	
}
