package event;


import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

//�۲���
public class EventDispatch implements Observer {


    //�¼������� �����¼��Ķ�������
    private Vector<EventCustomer> customer = new Vector<EventCustomer>();

    //����ģʽ ���ܻ����̰߳�ȫ����
    private final static EventDispatch dispatch = new EventDispatch();
    //�����������µ�ʵ��
    private EventDispatch(){
    }

    //panda ÿ���õ��Ķ���ͬ��
    public static EventDispatch getEventDispatch(){
        return dispatch;
    }


    //�¼�����
    @Override
    public void update(Observable o, Object arg) {
//�¼���Դͷ
        Product product = (Product)arg;
//�¼�
        ProductEvent event = (ProductEvent)o;
//�����ߴ����������н���ģʽ�ĺ��ģ������Ǻܸ��ӵ�ҵ���߼�
        for(EventCustomer e:customer){

            for(EventCustomType t:e.getCustomType()){
                //panda ����������¼��� �ʹ���
                if(t.getValue()== event.getEventType().getValue()){
                    e.exec(event);
                }
            }
        }
    }
    //ע���¼�������
    public void registerCustomer(EventCustomer _customer){
        customer.add(_customer);
    }
}