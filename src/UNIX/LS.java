package UNIX;

public class LS extends AbstractLS {
    //最简单的ls命令
    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls(vo.formatData());
    }
    //参数为空
    @Override
    protected String getOperateParam() {
        return DEFAULT_PARAM;
    }
}