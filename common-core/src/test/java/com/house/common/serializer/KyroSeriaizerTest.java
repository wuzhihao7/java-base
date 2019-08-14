package com.house.common.serializer;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

@Data
@NoArgsConstructor
class User implements Serializable {
    private static final long serialVersionUID = -545769456851805390L;
    private int age;
    private String name;
}

public class KyroSeriaizerTest {

    @Test
    public void serialize() {
        User zhangsan = new User();
        zhangsan.setAge(10);
        zhangsan.setName("zhangsan");
        KyroSeriaizer<User> userKyroSeriaizer = new KyroSeriaizer<>();
        User user = userKyroSeriaizer.deserialize(userKyroSeriaizer.serialize(zhangsan), User.class);
        User user1 = userKyroSeriaizer.deserialize(userKyroSeriaizer.serialize(zhangsan), User.class);
        System.out.println(zhangsan);
        System.out.println(user);
        assertEquals(zhangsan, user);
        assert userKyroSeriaizer.serialize(zhangsan) == userKyroSeriaizer.serialize(zhangsan);
    }
}