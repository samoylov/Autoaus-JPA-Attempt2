package autohaus.editor;

import autohaus.service.CountryService;

import java.beans.PropertyEditorSupport;

public class CountryEditor extends PropertyEditorSupport{

    private final CountryService countryService;

    public CountryEditor(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(countryService.findOne(Integer.parseInt(text)));
    }

}
