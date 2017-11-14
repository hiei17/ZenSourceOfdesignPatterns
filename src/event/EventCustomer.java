package event;

import java.util.Vector;

public abstract class EventCustomer {
    //����ÿ���������ܹ�����ļ���
    private Vector<EventCustomType> customType = new Vector<EventCustomType>();

    //ÿ�������߶�Ҫ�����Լ�������һ�����¼�
    public EventCustomer(EventCustomType _type){
        addCustomType(_type);
    }

    //ÿ�������߿������Ѷ���¼�
    public void addCustomType(EventCustomType _type){
        customType.add(_type);
    }

    //�õ��Լ��Ĵ�������
    public Vector<EventCustomType> getCustomType(){
        return customType;
    }
    //ÿ���¼���Ҫ���¼���������ʽ����
    public abstract void exec(ProductEvent event);
}
