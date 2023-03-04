import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.*;
public class console1 {
    public String getStringRandom(int length) {
        
        String val = "";
        Random random = new Random();
        
        //参数length，表示生成几位随机数
        for(int i = 0; i < 6; i++) {
            
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

        //生成随机数字和字母,
    public static void main(String[] args) throws IOException{
        String ran;
        Object wat1 = new Object();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        Console cons = System.console();
        String username = cons.readLine("User name:");
        char[] passwd = cons.readPassword("Passwd:");

        int linelength = passwd.length;

        console1 con1 = new console1();
        String ran1 = con1.getStringRandom(6);

        StringBuffer str = new StringBuffer(linelength);

        Thread t1 = new Thread();

        try {
            
        for (int j = 0; j < linelength; j++) {
            str.append("*");
        }

        System.out.println("用户名为:" + username);
        System.out.println("密码为:" + str);
        System.out.println("验证码:" + ran1);
        System.out.println("输入验证码显示密码");
        
        ran =  buf.readLine();

        if(ran.equals(ran1)){

        System.out.println("用户名为:" + username);
        System.out.println("密码为:" + String.valueOf(passwd));
        }else{
            System.out.println("错误,按三秒后退出");
            TimeUnit.SECONDS.sleep(3);
            
        } 
    }catch (Exception e) {
        e.printStackTrace();
    }
    t1.start();
    }
}

