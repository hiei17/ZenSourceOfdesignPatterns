package event;

/**
 * Created by Administrator on 2017/11/10 0010.
 */
public class Product implements Cloneable{
    //��Ʒ����
    private String name;
    //�Ƿ�������Ա��
    private boolean canChanged = false;

    //panda �������� public   ʵ����ֻ��ͨ��ProductManager
    public Product(ProductManager manager,String _name){
        //�Ƿ���������Ʒ ProductManager������ ��ʵ�ⲿֻ��ͨ��ProductManager�ķ������õ�Product
        if(manager.isCreateProduct()){
            canChanged =true;
            this.name = _name;
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(canChanged){
            this.name = name;
        }
    }
    //��дclone����
    @Override
    public Product clone(){
        Product p =null;
        try {
            p =(Product)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
