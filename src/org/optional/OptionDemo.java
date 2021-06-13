package org.optional;

import org.bean.Order;
import org.bean.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Steven
 */
public class OptionDemo {


    public static void main(String[] args) {

        User user = new User();

        String result = Optional.ofNullable(user).map(user1 -> user1.getName()).orElse("参数为空");
        System.out.println("result=" + result);

        List<Order> orders = Optional.of(user).flatMap(o -> Optional.ofNullable(o.getOrder())).orElse(Collections.emptyList());
        System.out.println("order 结果 =" + orders);

        boolean present = Optional.ofNullable(user).map(m -> m.getAge()).isPresent();
        System.out.println("present:" + present);

        user.setName("steven");
        // ifPresent  如果 user .getName()不等于 空 ，则 设置 年龄为18
        Optional.ofNullable(user).map(m -> m.getName()).ifPresent(s -> user.setAge(18));
        System.out.println(user);
    }

}
