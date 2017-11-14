package event;

/**
 * Created by Administrator on 2017/11/10 0010.
 */
public class Product implements Cloneable{
    //产品名称
    private String name;
    //是否可以属性变更
    private boolean canChanged = false;

    //panda 看起来是 public   实际上只能通过ProductManager
    public Product(ProductManager manager,String _name){
        //是否允许建立产品 ProductManager来决定 其实外部只能通过ProductManager的方法来得到Product
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
    //覆写clone方法
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
