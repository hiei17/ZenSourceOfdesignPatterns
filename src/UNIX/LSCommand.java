package UNIX;

import java.util.List;

public class LSCommand extends Command{
    @Override
    public String execute(CommandVO vo){
        //所有子类 (子命令
        List<? extends CommandName> commandNamesLink = super.buildChain(AbstractLS.class);
        //链表的首节点
        CommandName firstNode = commandNamesLink.get(0);
        return firstNode.handleMessage(vo);
    }
}