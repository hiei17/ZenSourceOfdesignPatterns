package UNIX;

/**
 * Created by Administrator on 2017/11/8 0008.
 */
public abstract class CommandName {
    private CommandName nextOperator;

    public final String handleMessage(CommandVO vo){
        //处理结果

        //判断是否是自己处理的参数
        if(vo.getParam().size() == 0 || vo.getParam().contains (this.getOperateParam())){
            return this.echo(vo);
        }
        if(this.nextOperator !=null){
            return this.nextOperator.handleMessage(vo);
        }
        return "命令无法执行";
    }

    //设置剩余参数由谁来处理
    public void setNext(CommandName _operator){
        this.nextOperator = _operator;
    }

    //每个处理者都要处理一个后缀参数
    protected abstract String getOperateParam();

    //每个处理者都必须实现处理任务
    protected abstract String echo(CommandVO vo);
}