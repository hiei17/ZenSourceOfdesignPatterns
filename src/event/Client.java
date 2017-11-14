package event;

public class Client {
    public static void main(String[] args) {
        //����¼��ַ����� ȫ���̾���ôһ������ʵ��
        EventDispatch dispatch = EventDispatch.getEventDispatch();

        //panda �ɷ������չ
//������ؤ���¼��Ĵ���
        dispatch.registerCustomer(new Beggar());
//����ƽ����¼��Ĵ���
        dispatch.registerCustomer(new Commoner());
//���ܹ�����¼��Ĵ���
        dispatch.registerCustomer(new Nobleman());

        //���� ���� �������õ��¼� �¼��õ��¼��ַ�����
        ProductManager factory = new ProductManager();

//����һ����Ʒ
        System.out.println("=====ģ�ⴴ����Ʒ�¼�========");
        System.out.println("����һ������С�к���ԭ�ӵ�");
        Product p = factory.createProduct("С�к�ԭ�ӵ�");
//�޸�һ����Ʒ
        System.out.println("\n=====ģ���޸Ĳ�Ʒ�¼�========");
        System.out.println("��С�к�ԭ�ӵ��޸�Ϊ���Ӻ�ԭ�ӵ�");
        factory.editProduct(p, "���Ӻ�ԭ�ӵ�");
//�ٿ�¡һ��ԭ�ӵ�
        System.out.println("\n=====ģ���¡��Ʒ�¼�========");
        System.out.println("��¡���Ӻ�ԭ�ӵ�");
        factory.clone(p);
//����һ����Ʒ
        System.out.println("\n=====ģ�����ٲ�Ʒ�¼�========");
        System.out.println("�������Ӻ�ԭ�ӵ�");
        factory.abandonProduct(p);
    }
}