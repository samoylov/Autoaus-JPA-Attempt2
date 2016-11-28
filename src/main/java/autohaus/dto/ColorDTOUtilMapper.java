package autohaus.dto;

import autohaus.entity.Color;

import java.util.ArrayList;
import java.util.List;

public class ColorDTOUtilMapper {

    public static List<ColorDTO> colorsToColorsDTO(List<Color> colors) {
        List<ColorDTO> colorDTOs = new ArrayList<ColorDTO>();

        for (Color color : colors)
            colorDTOs.add(new ColorDTO(color.getId(), color.getName()));

        return colorDTOs;
    }

}
