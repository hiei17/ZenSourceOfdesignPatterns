package event;

import java.util.Observable;

//�¼�
public class ProductEvent extends Observable {

    //�¼���Դ
    private Product source;

    //�¼������� ö��
    private ProductEventType type;



    //�¼�Դͷ�Լ��¼�����
    public ProductEvent(Product p,ProductEventType _type){
        this.source = p;
        this.type = _type;
        //�¼�����
        notifyEventDispatch();
    }
    //֪ͨ�¼���������
    private void notifyEventDispatch(){

        EventDispatch dispatch = EventDispatch.getEventDispatch();
        super.addObserver(dispatch);
        super.setChanged();
        //֪ͨΨһ�Ķ������н�dispatch  dispatch��ת��
        super.notifyObservers(source);
    }



    //����¼���ʼ��ٸ��
    public Product getSource(){
        return source;
    }
    //����¼�������
    public ProductEventType getEventType(){
        return this.type;
    }

}