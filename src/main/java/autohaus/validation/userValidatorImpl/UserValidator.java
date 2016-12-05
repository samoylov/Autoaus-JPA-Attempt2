package autohaus.validation.userValidatorImpl;

import autohaus.dao.UserDao;
import autohaus.entity.User;
import autohaus.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userValidator")
public class UserValidator implements Validator {

    @Autowired
    UserDao dao;

    public void validate(Object object) throws Exception {

        User user = (User) object;

        if (user.getName().isEmpty())
            throw new UserValidationException(UserValidationMessages.EMPTY_USERNAME_FIELD);
        if(dao.findByName(user.getName()) != null)
            throw new UserValidationException(UserValidationMessages.EXISTING_USERNAME_FIELD);

        if (user.getPassword().isEmpty())
            throw new UserValidationException(UserValidationMessages.EMPTY_PASSWORD_FIELD);
    }
}
