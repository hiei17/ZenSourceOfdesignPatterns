package UNIX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws IOException {
        Invoker invoker = new Invoker();
        while(true){
//UNIX�µ�Ĭ����ʾ����
            System.out.print("#");
//�������
            String input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
//����quit��exit���˳�
            if(input.equals("quit") || input.equals("exit")){
                return;
            }
            //panda
            String result = invoker.exec(input);
            System.out.println(result);
        }
    }
}