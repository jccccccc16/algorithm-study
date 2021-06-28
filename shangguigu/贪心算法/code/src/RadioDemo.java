import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/6/25
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 * 集合覆盖
 * 选择最少的广播台，让所有的地区都可以接收到信号
 * 尝试根据题目，答题
 **/
public class RadioDemo {

    // 城市
    static String[] address = new String[]{"北京","上海","天津","广州","深圳","成都","杭州","大连"};

    // 广播台
    static Map<String,List<String>> radioMap = new HashMap<String,List<String>>();

    // 电台初始化,每个电台所能覆盖的城市
    static {
        System.out.println("++++++++++");
        radioMap.put("k1",Arrays.asList("北京","上海","天津") );
        radioMap.put("k2",Arrays.asList("广州","深圳","北京"));
        radioMap.put("k3",Arrays.asList("成都","上海","杭州"));
        radioMap.put("k4",Arrays.asList("上海","天津"));
        radioMap.put("k5",Arrays.asList("杭州","大连"));
    }

    public static void main(String[] args) {
        List<String> calculate = calculate(radioMap);
        for (String s : calculate) {
            System.out.println(s);
        }
    }

    public static List<String> calculate(Map<String,List<String>> radioAddressMap){
        List<String> radioResult = new ArrayList<>();
        Set<String> addressResult = new HashSet<String>();
        // 遍历广播台
        // 直到覆盖所有的地区
        String maxRadio = "";
        int maxScope;
        while (addressResult.size()!=address.length){
            maxScope = 0;
            // 寻找与当前addressResult或运算最大的集合
            for (Map.Entry<String, List<String>> entry : radioAddressMap.entrySet()) {
                // 记录该电台或之后的地区数量
                int scope = 0;
                List<String> addressList = entry.getValue();
                for (String s : addressList) {
                    // 如果不包含
                    if(!addressResult.contains(s)){
                        scope++;
                    }
                }
                if(scope>maxScope){
                    maxScope = scope;
                    maxRadio = entry.getKey();
                }
            }
            // 复制到addressResult中

            radioResult.add(maxRadio);
            addressResult.addAll(radioMap.get(maxRadio));
            radioAddressMap.remove(maxRadio);

        }
        return radioResult;
    }





}
