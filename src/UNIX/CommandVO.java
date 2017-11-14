package UNIX;

import java.util.ArrayList;
import java.util.HashSet;

public class CommandVO {
    //定义参数名与参数的分隔符号,一般是空格
    public final static String DIVIDE_FLAG =" ";
    //定义参数前的符号，Unix一般是-,如ls -la
    public final static String PREFIX="-";
    //命令名，如ls、du
    private String commandName = "";
    //参数列表
    private ArrayList<String> paramList = new ArrayList<String>();
    //操作数列表
    private ArrayList<String> dataList = new ArrayList<String>();

    //通过构造函数传递进来命令
    public CommandVO(String commandStr){

            //根据分隔符号拆分出执行符号
            String[] complexStr = commandStr.split(CommandVO.DIVIDE_FLAG);

            //第一个参数是执行符号
            this.commandName = complexStr[0];

            //剩下的参数 是操作数 放到List中
            for(int i=1;i<complexStr.length;i++){
                String str = complexStr[i];
                //包含前缀符号，认为是参数
                if(str.indexOf(CommandVO.PREFIX)==0){
                    this.paramList.add(str.replace(CommandVO.PREFIX, "").trim());
                }else{
                    this.dataList.add(str.trim());
                }
            }

    }
    //得到命令名
    public String getCommandName(){
        return this.commandName;
    }
    //获得参数
    public ArrayList<String> getParam(){
//为了方便处理空参数
        if(this.paramList.size() ==0){
            this.paramList.add("");
        }
        return new ArrayList(new HashSet(this.paramList));
    }
    //获得操作数
    public ArrayList<String> getData(){
        return this.dataList;
    }

    public String formatData() {
        //todo
        return "";
    }
}