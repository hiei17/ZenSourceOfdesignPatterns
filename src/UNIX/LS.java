package UNIX;

public class LS extends AbstractLS {
    //��򵥵�ls����
    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls(vo.formatData());
    }
    //����Ϊ��
    @Override
    protected String getOperateParam() {
        return DEFAULT_PARAM;
    }
}