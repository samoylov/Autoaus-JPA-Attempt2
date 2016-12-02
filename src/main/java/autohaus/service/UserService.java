package autohaus.service;

import autohaus.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

public interface UserService {

    void save(User object);

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    public void saveImage(Principal principal, MultipartFile multipartFile);

}
