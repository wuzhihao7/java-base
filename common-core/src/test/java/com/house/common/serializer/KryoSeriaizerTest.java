package com.house.common.serializer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KryoSeriaizerTest {

    @Test
    public void serialize() {
        User zhangsan = new User();
        zhangsan.setAge(10);
        zhangsan.setName("zhangsan");
        KryoSeriaizer<User> userKryoSeriaizer = new KryoSeriaizer<>();
        User user = userKryoSeriaizer.deserialize(userKryoSeriaizer.serialize(zhangsan));
        User user1 = userKryoSeriaizer.deserialize(userKryoSeriaizer.serialize(zhangsan));
        System.out.println(user);
        System.out.println(user1);
        assertEquals(zhangsan, user);
    }
}