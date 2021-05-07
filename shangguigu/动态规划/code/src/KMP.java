import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/5/7
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 **/
public class KMP {

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String source = "BBC ABCDAB ABCDABCDABDE";
        String target = "ABCDAB ";
        boolean calculate = kmp.calculate(source,target);
        System.out.println(calculate?source+" 包含 "+target:"不包含");
    }

    public boolean calculate(String source,String target){


        if(source.length()<target.length()){
            return false;
        }

        // 部分匹配值表

        int table[] = new int[target.length()];
        int max=0;

        for(int i=0;i<target.length();i++){

            for(int j=0;j<i;j++){
                String front = target.substring(0, j+1);
                String behind = target.substring(i-j,i+1);
                if(front.equals(behind)){
                    int length = front.length();
                    if(length>max){
                        max = length;
                    }
                }
            }
            table[i] = max;
            max = 0;
        }

        int ti=0;
        // 开始匹配
        for(int si=0;si<source.length();si++){
            while(ti<target.length()&&source.charAt(si)==target.charAt(ti)){
                ti++;
                si++;
            }
            // 如何指针超出了target的长度
            if(ti>target.length()-1){
                return true;
            }
            // 如果不匹配就跳
            si = si-table[ti];
            ti=0;
        }


        return false;
    }

}
