package UNIX;

public class LS_A extends AbstractLS {
    //ls -a����
    protected String echo(CommandVO vo) {
        return FileManager.ls_a(vo.formatData());
    }
    protected String getOperateParam() {
        return super.A_PARAM;
    }
}