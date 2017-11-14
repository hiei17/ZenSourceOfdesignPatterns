package UNIX;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    //ģ�巽�� ������ʵ��
    public abstract String execute(CommandVO vo);

    //��������
    protected final List<? extends CommandName> buildChain(Class<? extends CommandName> abstractClass) {
        //ȡ�����е��������µ�����
        List<Class> classes = ClassUtils.getSonClass(abstractClass);
        //��������ʵ���������������ϵ
        List<CommandName> commandNameList = new ArrayList< >();
        for (Class c : classes) {
            CommandName commandName = null;
            try {
//����ʵ��
                commandName = (CommandName) Class.forName(c.getName()).newInstance();
            } catch (Exception e) {
// TODO �쳣����
            }
            //��������
            //ͷ
            if (commandNameList.size() == 0) {
                commandNameList.add(commandName);
            }
            //�Ӻ���
            commandNameList.get(commandNameList.size() - 1).setNext(commandName);
        }
        return commandNameList;
    }
}
