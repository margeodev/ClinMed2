package com.sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sistema.model.Consulta;
import com.sistema.model.Paciente;
import com.sistema.repository.Consultas;
import com.sistema.repository.Pacientes;
import com.sistema.util.cdi.CDIServiceLocator;

@FacesConverter("consultaConverter")
public class ConsultaConverter implements Converter {
	
	private Consultas consRep;
	
	public ConsultaConverter(){
		consRep = CDIServiceLocator.getBean(Consultas.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent arg1, String value) {	
		Consulta consulta = null;
		if (value != null){
			Integer id = new Integer(value);
			consulta = consRep.porId(id);
		}		
		return consulta;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent arg1, Object value) {	
		if (value != null) {
			Integer codigo = ((Consulta) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			System.out.println("consulta: " + retorno);
			return retorno;
		}		
		return "";		
	}
}
