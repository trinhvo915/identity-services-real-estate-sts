package vn.identity.services.api.dto;

import lombok.*;
import vn.identity.services.api.entity.enums.Gender;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String userName;

    private String password;

    private String fistName;

    private String lastName;

    private Integer age;

    private Gender gender;

    private String address;
}
