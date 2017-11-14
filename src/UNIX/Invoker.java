package UNIX;

public class Invoker {
    //执行命令
    public String exec(String _commandStr) {
//定义返回值
        String result = "";
//首先解析命令
        CommandVO vo = new CommandVO(_commandStr);
//检查是否支持该命令
        if (!CommandEnum.getNames().contains(vo.getCommandName())) {
            return "无法执行命令，请检查命令格式";
        }

        //产生命令对象
        //拿到交这个名的枚举实例
        CommandEnum commandEnum = CommandEnum.valueOf(vo.getCommandName());
        String className = commandEnum.getValue();
        Command command;
        //这里用到了命令模式
        try {
            //终于得到具体命令
            command = (Command) Class.forName(className).newInstance();
            //执行
            result = command.execute(vo);
        } catch (Exception e) {

        }

        return result;
    }
}