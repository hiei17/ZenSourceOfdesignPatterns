package event;


import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

//观察者
public class EventDispatch implements Observer {


    //事件消费者 订阅事件的都在里面
    private Vector<EventCustomer> customer = new Vector<EventCustomer>();

    //单例模式 可能会有线程安全隐患
    private final static EventDispatch dispatch = new EventDispatch();
    //不允许生成新的实例
    private EventDispatch(){
    }

    //panda 每次拿到的都是同个
    public static EventDispatch getEventDispatch(){
        return dispatch;
    }


    //事件触发
    @Override
    public void update(Observable o, Object arg) {
//事件的源头
        Product product = (Product)arg;
//事件
        ProductEvent event = (ProductEvent)o;
//处理者处理，这里是中介者模式的核心，可以是很复杂的业务逻辑
        for(EventCustomer e:customer){

            for(EventCustomType t:e.getCustomType()){
                //panda 监听了这个事件的 就触发
                if(t.getValue()== event.getEventType().getValue()){
                    e.exec(event);
                }
            }
        }
    }
    //注册事件处理者
    public void registerCustomer(EventCustomer _customer){
        customer.add(_customer);
    }
}