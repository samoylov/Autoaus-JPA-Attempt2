package autohaus.editor;

import autohaus.service.CustomerService;

import java.beans.PropertyEditorSupport;

public class CustomerEditor extends PropertyEditorSupport{

    private final CustomerService customerService;

    public CustomerEditor(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(customerService.findOne(Integer.parseInt(text)));
    }

}
