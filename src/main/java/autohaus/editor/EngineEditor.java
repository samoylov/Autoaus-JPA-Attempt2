package autohaus.editor;

import autohaus.service.EngineService;

import java.beans.PropertyEditorSupport;

public class EngineEditor extends PropertyEditorSupport{

    private final EngineService engineService;

    public EngineEditor(EngineService engineService) {
        this.engineService = engineService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(engineService.findOne(Integer.parseInt(text)));
    }

}
