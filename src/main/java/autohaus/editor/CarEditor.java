package autohaus.editor;

import autohaus.service.CarService;

import java.beans.PropertyEditorSupport;

public class CarEditor extends PropertyEditorSupport{

    private final CarService carService;

    public CarEditor(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(carService.findOne(Integer.parseInt(text)));
    }

}
