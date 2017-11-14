package UNIX;

import java.util.ArrayList;
import java.util.HashSet;

public class CommandVO {
    //���������������ķָ�����,һ���ǿո�
    public final static String DIVIDE_FLAG =" ";
    //�������ǰ�ķ��ţ�Unixһ����-,��ls -la
    public final static String PREFIX="-";
    //����������ls��du
    private String commandName = "";
    //�����б�
    private ArrayList<String> paramList = new ArrayList<String>();
    //�������б�
    private ArrayList<String> dataList = new ArrayList<String>();

    //ͨ�����캯�����ݽ�������
    public CommandVO(String commandStr){

            //���ݷָ����Ų�ֳ�ִ�з���
            String[] complexStr = commandStr.split(CommandVO.DIVIDE_FLAG);

            //��һ��������ִ�з���
            this.commandName = complexStr[0];

            //ʣ�µĲ��� �ǲ����� �ŵ�List��
            for(int i=1;i<complexStr.length;i++){
                String str = complexStr[i];
                //����ǰ׺���ţ���Ϊ�ǲ���
                if(str.indexOf(CommandVO.PREFIX)==0){
                    this.paramList.add(str.replace(CommandVO.PREFIX, "").trim());
                }else{
                    this.dataList.add(str.trim());
                }
            }

    }
    //�õ�������
    public String getCommandName(){
        return this.commandName;
    }
    //��ò���
    public ArrayList<String> getParam(){
//Ϊ�˷��㴦��ղ���
        if(this.paramList.size() ==0){
            this.paramList.add("");
        }
        return new ArrayList(new HashSet(this.paramList));
    }
    //��ò�����
    public ArrayList<String> getData(){
        return this.dataList;
    }

    public String formatData() {
        //todo
        return "";
    }
}