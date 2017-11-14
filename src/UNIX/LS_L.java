package UNIX;

public class LS_L extends AbstractLS {
    protected String echo(CommandVO vo) {
        return FileManager.ls_l(vo.formatData());
    }
    //l—°œÓ
    protected String getOperateParam() {
        return super.L_PARAM;
    }
}