package UNIX;

import java.util.List;

public class LSCommand extends Command{
    @Override
    public String execute(CommandVO vo){
        //�������� (������
        List<? extends CommandName> commandNamesLink = super.buildChain(AbstractLS.class);
        //������׽ڵ�
        CommandName firstNode = commandNamesLink.get(0);
        return firstNode.handleMessage(vo);
    }
}