package event;

public class Beggar extends EventCustomer {
    //ֻ�ܴ����������Ķ���
    public Beggar(){
        super(EventCustomType.DEL);
    }

    @Override
    public void exec(ProductEvent event) {
//�¼���Դͷ
        Product p = event.getSource();
//�¼�����
        ProductEventType type = event.getEventType();
        System.out.println("��ؤ�����¼�:"+p.getName() +"����,�¼�����="+type);
    }
}

