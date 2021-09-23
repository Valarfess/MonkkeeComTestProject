package model.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private int id;
    private String name;
    private int salary;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}

