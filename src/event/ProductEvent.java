package event;

import java.util.Observable;

//事件
public class ProductEvent extends Observable {

    //事件起源
    private Product source;

    //事件的类型 枚举
    private ProductEventType type;



    //事件源头以及事件类型
    public ProductEvent(Product p,ProductEventType _type){
        this.source = p;
        this.type = _type;
        //事件触发
        notifyEventDispatch();
    }
    //通知事件处理中心
    private void notifyEventDispatch(){

        EventDispatch dispatch = EventDispatch.getEventDispatch();
        super.addObserver(dispatch);
        super.setChanged();
        //通知唯一的订阅者中介dispatch  dispatch再转发
        super.notifyObservers(source);
    }



    //获得事件的始作俑者
    public Product getSource(){
        return source;
    }
    //获得事件的类型
    public ProductEventType getEventType(){
        return this.type;
    }

}