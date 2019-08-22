package com.house.common.serializer;

import org.junit.Assert;
import org.junit.Test;

public class FstSerializerTest {
    @Test
    public void test(){
        User user = new User();
        user.setName("zhangsan");
        user.setAge(10);
        FstSerializer<User> userFstSerializer = new FstSerializer<>();
        byte[] serialize = userFstSerializer.serialize(user);
        User user1 = userFstSerializer.deserialize(serialize);
        Assert.assertEquals(user, user1);
    }
}