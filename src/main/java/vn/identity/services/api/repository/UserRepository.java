package vn.identity.services.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import vn.identity.services.api.entity.enums.Gender;
import vn.identity.services.api.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    @NonNull
    User findFirstByUserNameEqualsIgnoreCaseAndGenderEqualsOrderByAgeAsc(@NonNull String userName, @NonNull Gender gender);

    List<User> findByUserNameEqualsIgnoreCaseAndAgeEquals(@NonNull String userName, Integer age);

}
