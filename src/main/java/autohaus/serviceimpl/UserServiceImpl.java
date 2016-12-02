package autohaus.serviceimpl;

import autohaus.dao.ModelDao;
import autohaus.dao.UserDao;
import autohaus.entity.User;
import autohaus.entity.UserRole;
import autohaus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDao dao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void save(User user) {
        user.setRole(UserRole.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
        dao.save(user);
    }

    public List<User> findAll() {
        return dao.findAll();
    }

    public User findOne(int id) {
        return dao.findOne(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }


    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return dao.findByName(name);
    }
}
