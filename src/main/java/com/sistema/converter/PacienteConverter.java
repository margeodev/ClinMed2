package com.sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sistema.model.Paciente;
import com.sistema.repository.Pacientes;
import com.sistema.util.cdi.CDIServiceLocator;

@FacesConverter("pacConverter")
public class PacienteConverter implements Converter {
	
	private Pacientes pacRep;
	
	public PacienteConverter(){
		pacRep = CDIServiceLocator.getBean(Pacientes.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent arg1, String value) {	
		Paciente paciente = null;
		if (value != null){
			Integer id = new Integer(value);
			paciente = pacRep.porId(id);
		}		
		return paciente;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent arg1, Object value) {	
		if (value != null) {
			Integer codigo = ((Paciente) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			System.out.println("paciente: " + retorno);
			return retorno;
		}		
		return "";		
	}
}
