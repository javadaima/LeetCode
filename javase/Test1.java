package javase;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class Test1 {

    @Test
    public void test1() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        User user = new User();
        user.setName("ceshi");
        User2 user2 = new User2();
        user2.setName("ceshi2");
        user.setUser2(user2);
        String s = JSON.toJSONString(user);
        System.out.println(s);
        User clone = (User)Clone.clone(user);
        Object clone1 = Clone.clone(user, 1);
        Object clone2 = Clone.clone(user, -1);
        System.out.println(clone);
    }

}
