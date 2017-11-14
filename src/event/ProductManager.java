package event;

//����
public class ProductManager {

 //panda �Ƿ���Դ���һ����Ʒ
   private boolean isPermittedCreate = false;

    public Product createProduct(String name){
        //�����޸�Ȩ�ޣ������� Ψһһ���ܰ�isPermittedCreate���true�ĵط�
        isPermittedCreate = true;
        Product p = new Product(this,name);
        //panda ����һ�������¼�
        new ProductEvent(p,ProductEventType.NEW_PRODUCT);
        return p;
    }
    //����һ����Ʒ
    public void abandonProduct(Product p){
//����һ����Ʒ������ɾ�����ݿ��¼
    //panda ����ɾ���¼�
        new ProductEvent(p,ProductEventType.DEL_PRODUCT);
        p = null;
    }
    //�޸�һ����Ʒ
    public void editProduct(Product p,String name){
//�޸ĺ�Ĳ�Ʒ
        p.setName(name);
        //panda �����޸��¼�
        new ProductEvent(p,ProductEventType.EDIT_PRODUCT);
    }
    //����Ƿ���Դ���һ����Ʒ
    public boolean isCreateProduct(){
        return isPermittedCreate;
    }
    //��¡һ����Ʒ
    public Product clone(Product p){
//������¡�¼�
        new ProductEvent(p,ProductEventType.CLONE_PRODUCT);
        return p.clone();
    }
}

