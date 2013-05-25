package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		  
			  
		        String email = (String) arg2;
		        
		        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		        Matcher m = p.matcher(email);
		        boolean matchFound = m.matches();
		        
		        if(!matchFound) {
		            FacesMessage message = new FacesMessage();
		            message.setSeverity(FacesMessage.SEVERITY_ERROR);
		            message.setSummary("Yanlýþ E-Posta");
		            message.setDetail("Bu E-Posta geçersiz.");
		            throw new ValidatorException(message);
		        }
		    

	}

}
