package com.example.client2;

import lombok.Data;

@Data
public class User {
    private String name;
    private String city;
    private int age;

    public static User getMockUser() {
        User user = new User();
        user.setName("foo");
        user.setCity("Pune");
        user.setAge(30);
        return user;
    }
}
