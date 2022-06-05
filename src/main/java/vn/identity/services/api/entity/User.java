package vn.identity.services.api.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import vn.identity.services.api.entity.enums.Gender;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@Entity
@Table(name = "Users")
public class User extends AuditedEntity {

    @Column(name = "UserName", nullable = false)
    private String userName;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "FistName", nullable = false)
    private String fistName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "Gender")
    private Gender gender;

    @Column(name = "Address")
    @Type(type = "org.hibernate.type.TextType")
    private String address;

}