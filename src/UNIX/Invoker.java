package UNIX;

public class Invoker {
    //ִ������
    public String exec(String _commandStr) {
//���巵��ֵ
        String result = "";
//���Ƚ�������
        CommandVO vo = new CommandVO(_commandStr);
//����Ƿ�֧�ָ�����
        if (!CommandEnum.getNames().contains(vo.getCommandName())) {
            return "�޷�ִ��������������ʽ";
        }

        //�����������
        //�õ����������ö��ʵ��
        CommandEnum commandEnum = CommandEnum.valueOf(vo.getCommandName());
        String className = commandEnum.getValue();
        Command command;
        //�����õ�������ģʽ
        try {
            //���ڵõ���������
            command = (Command) Class.forName(className).newInstance();
            //ִ��
            result = command.execute(vo);
        } catch (Exception e) {

        }

        return result;
    }
}