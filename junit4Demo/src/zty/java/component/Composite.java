package zty.java.component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{

	// List�������ǽӿ�����Component�������ͼȿ��Է�Leaf���ֿ��Է�Composite
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
            // �����Ҷ�ӣ�ֱ��ִ��
            // ����Ǹ��ϵģ�������������а�����list
            component.dosomething();
        }
	}
	
}
