package autohaus.editor;

import autohaus.service.TransmissionService;

import java.beans.PropertyEditorSupport;

public class TransmissionEditor extends PropertyEditorSupport{

    private final TransmissionService transmissionService;

    public TransmissionEditor(TransmissionService transmissionService) {
        this.transmissionService = transmissionService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(transmissionService.findOne(Integer.parseInt(text)));
    }

}
