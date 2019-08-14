package com.house.common.serializer;

import org.junit.Test;

public class FstSerializerTest {
    @Test
    public void test(){
        User user = new User();
        user.setName("zhangsan");
        user.setAge(10);
        FstSerializer<User> userFstSerializer = new FstSerializer<>();
        byte[] serialize = userFstSerializer.serialize(user);
        byte[] serialize2 = userFstSerializer.serialize(user);
        assert serialize==serialize2;
    }
}