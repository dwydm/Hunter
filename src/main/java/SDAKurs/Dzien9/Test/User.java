package SDAKurs.Dzien9.Test;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@Data
public class User {
    private String name;
    private String surname;
    private int age;
    private int foot;
    private int height;
    private String nationality;
    private String eyesColor;
    private String hairColor;

    //lombok example

    public static void main(String[] args) {
        User.builder()
                .name("T")
                .age(30)
                .height(180)
                .build();
    }
}
