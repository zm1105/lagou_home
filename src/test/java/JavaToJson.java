import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : zhoumin
 * @data :  2020/8/25 18:17
 */
public class JavaToJson {

  public static void main(String[] args) {
    Persion persion = new Persion("张三", 23);
    String s = JSON.toJSONString(persion);
    System.out.println(s);

    Persion p1 = new Persion("张三", 23);
    Persion p2 = new Persion("张三", 23);
    Persion p3 = new Persion("张三", 23);

    List<Persion> list = new ArrayList<>();
    Collections.addAll(list, p1, p2, p3);
    String s1 = JSON.toJSONString(list);
    System.out.println(s1);

    String json= "{\"age\":23,\"name\":\"张三\"}";
    Persion persion1 = JSON.parseObject(json, Persion.class);
    System.out.println(persion1);

    String json1= "[{\"NAME\":\"张三\"},{\"NAME\":\"张三\"},{\"NAME\":\"张三\"}]";
    List<Persion> persions = JSON.parseArray(json1, Persion.class);
    System.out.println(persions);
  }
}
