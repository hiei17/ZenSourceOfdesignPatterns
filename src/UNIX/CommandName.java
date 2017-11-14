package UNIX;

/**
 * Created by Administrator on 2017/11/8 0008.
 */
public abstract class CommandName {
    private CommandName nextOperator;

    public final String handleMessage(CommandVO vo){
        //������

        //�ж��Ƿ����Լ�����Ĳ���
        if(vo.getParam().size() == 0 || vo.getParam().contains (this.getOperateParam())){
            return this.echo(vo);
        }
        if(this.nextOperator !=null){
            return this.nextOperator.handleMessage(vo);
        }
        return "�����޷�ִ��";
    }

    //����ʣ�������˭������
    public void setNext(CommandName _operator){
        this.nextOperator = _operator;
    }

    //ÿ�������߶�Ҫ����һ����׺����
    protected abstract String getOperateParam();

    //ÿ�������߶�����ʵ�ִ�������
    protected abstract String echo(CommandVO vo);
}