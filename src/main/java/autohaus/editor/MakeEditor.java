package autohaus.editor;

import autohaus.service.MakeService;

import java.beans.PropertyEditorSupport;

public class MakeEditor extends PropertyEditorSupport{

    private final MakeService makeService;

    public MakeEditor(MakeService makeService){
        this.makeService = makeService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(makeService.findOne(Integer.parseInt(text)));
    }

}
