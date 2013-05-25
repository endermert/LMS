package tools;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.component.inputtext.InputText;

public class PassValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object arg2)
			throws ValidatorException {
		
		    System.out.println(component.getFamily());
		    String field1Id = (String) component.getAttributes().get("field1Id");
		    
		    InputText textInput = (InputText) context.getViewRoot().findComponent(field1Id);
		 
		    if (textInput == null)
		        throw new IllegalArgumentException(String.format("Unable to find component with id %s",field1Id));

		    String field1 = (String) textInput.getValue();
	
			    String confirm = (String) arg2;
			    
			    if (field1 != null && field1.length() != 0 && !field1.equals(confirm)) {
			    FacesMessage message = new FacesMessage();
		        message.setSeverity(FacesMessage.SEVERITY_ERROR);
		        message.setSummary("Uyumsuz Þifre");
		        message.setDetail("Þifreler eþit olmalýdýr");
	            throw new ValidatorException(message);
	        }
	    

	}

}
