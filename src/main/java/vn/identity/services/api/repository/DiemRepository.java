package vn.identity.services.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.identity.services.api.entity.Diem;

@Repository
public interface DiemRepository extends JpaRepository<Diem, String> {
}
