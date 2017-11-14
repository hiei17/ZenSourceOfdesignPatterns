package event;

public class Client {
    public static void main(String[] args) {
        //获得事件分发中心 全工程就这么一个中心实例
        EventDispatch dispatch = EventDispatch.getEventDispatch();

        //panda 可方便地扩展
//接受乞丐对事件的处理
        dispatch.registerCustomer(new Beggar());
//接受平民对事件的处理
        dispatch.registerCustomer(new Commoner());
//接受贵族对事件的处理
        dispatch.registerCustomer(new Nobleman());

        //建立 工厂 里面有用到事件 事件用到事件分发中心
        ProductManager factory = new ProductManager();

//制造一个产品
        System.out.println("=====模拟创建产品事件========");
        System.out.println("创建一个叫做小男孩的原子弹");
        Product p = factory.createProduct("小男孩原子弹");
//修改一个产品
        System.out.println("\n=====模拟修改产品事件========");
        System.out.println("把小男孩原子弹修改为胖子号原子弹");
        factory.editProduct(p, "胖子号原子弹");
//再克隆一个原子弹
        System.out.println("\n=====模拟克隆产品事件========");
        System.out.println("克隆胖子号原子弹");
        factory.clone(p);
//遗弃一个产品
        System.out.println("\n=====模拟销毁产品事件========");
        System.out.println("遗弃胖子号原子弹");
        factory.abandonProduct(p);
    }
}