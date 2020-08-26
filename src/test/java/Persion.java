import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : zhoumin
 * @data :  2020/8/25 18:16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persion {

  @JSONField(name = "NAME",ordinal = 1)
  private  String name;

  //不转
  @JSONField(serialize = false)
  private  int age;
}
