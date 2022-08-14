package vn.identity.services.api.service.user;

import java.io.IOException;

public interface UserService {
    void getByIdUser(String Id);

    void saveDiem() throws IOException;
}
