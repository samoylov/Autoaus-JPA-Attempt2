package autohaus.editor;

import autohaus.service.ColorService;

import java.beans.PropertyEditorSupport;

public class ColorEditor extends PropertyEditorSupport{

    private final ColorService colorService;

    public ColorEditor(ColorService colorService) {
        this.colorService = colorService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(colorService.findOne(Integer.parseInt(text)));
    }

}
