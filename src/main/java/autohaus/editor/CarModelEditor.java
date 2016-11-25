package autohaus.editor;

import autohaus.service.CarModelService;

import java.beans.PropertyEditorSupport;

public class CarModelEditor extends PropertyEditorSupport{

    private final CarModelService carModelService;

    public CarModelEditor(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(carModelService.findOne(Integer.parseInt(text)));
    }

}
