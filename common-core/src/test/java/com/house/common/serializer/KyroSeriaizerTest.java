package com.house.common.serializer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KyroSeriaizerTest {

    @Test
    public void serialize() {
        User zhangsan = new User();
        zhangsan.setAge(10);
        zhangsan.setName("zhangsan");
        KyroSeriaizer<User> userKyroSeriaizer = new KyroSeriaizer<>();
        User user = userKyroSeriaizer.deserialize(userKyroSeriaizer.serialize(zhangsan), User.class);
        User user1 = userKyroSeriaizer.deserialize(userKyroSeriaizer.serialize(zhangsan), User.class);
        assertEquals(zhangsan, user);
        assert userKyroSeriaizer.serialize(zhangsan) == userKyroSeriaizer.serialize(zhangsan);
    }
}