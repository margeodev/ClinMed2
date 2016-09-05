package com.sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sistema.model.Especialidade;
import com.sistema.repository.Especialidades;
import com.sistema.util.cdi.CDIServiceLocator;

@FacesConverter(value="especConverter")
public class EspecialidadeConverter implements Converter {
	
	private Especialidades espRep;
	
	public EspecialidadeConverter(){
		espRep = CDIServiceLocator.getBean(Especialidades.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent arg1, String value) {		
		Especialidade retorno = null;
		if (value != null){
			Integer id = new Integer(value);
			retorno = espRep.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent arg1, Object value) {		
		if (value != null) {
			Integer codigo = ((Especialidade) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}		
		return "";		
		
	}
}
