package autohaus.dto;

import autohaus.entity.Color;
import autohaus.entity.User;

import java.util.ArrayList;
import java.util.List;

public class DTOUtilMapper {

    public static List<ColorDTO> colorsToColorsDTO(List<Color> colors) {
        List<ColorDTO> colorDTOs = new ArrayList<ColorDTO>();

        for (Color color : colors)
            colorDTOs.add(new ColorDTO(color.getId(), color.getName()));

        return colorDTOs;
    }

    public static List<UserDTO> usersToUsersDTO(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();

        for (User user : users)
            userDTOs.add(new UserDTO(user.getId(), user.getName(), user.getPhone(), user.getEmail()));

        return userDTOs;
    }

}
