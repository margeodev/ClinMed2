package com.sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.sistema.model.Medico;
import com.sistema.repository.Medicos;
import com.sistema.util.cdi.CDIServiceLocator;

@FacesConverter("medConverter")
public class MedicoConverter implements Converter {
	
	private Medicos medRep;
	
	public MedicoConverter(){
		medRep = CDIServiceLocator.getBean(Medicos.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent arg1, String value) {	
		Medico medico = null;
		if (value != null){
			Integer id = new Integer(value);
			medico = medRep.porId(id);
		}		
		return medico;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent arg1, Object value) {	
		if (value != null) {
			Integer codigo = ((Medico) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			System.out.println("medico: " + retorno);
			return retorno;
		}		
		return "";		
	}
}
