package event;

public class Commoner extends EventCustomer {
    //����ƽ���ܹ�������¼��ļ���
    public Commoner() {
        super(EventCustomType.NEW);
    }
    @Override
    public void exec(ProductEvent event) {
//�¼���Դͷ
        Product p = event.getSource();
//�¼�����
        ProductEventType type = event.getEventType();
        System.out.println("ƽ�����¼�:"+p.getName() +"������,�¼�����="+type);
    }
}
