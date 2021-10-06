package api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private int userId;
    private int id;
    private String title;
    private String name;
    private int salary;
    private int age;

    @Override
    public String toString() {
        return "UserResponse{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
