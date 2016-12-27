package es.espinaco.xmltvConverter.threads;

import java.util.concurrent.Callable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.espinaco.xmltvConverter.canalplus.entities.Canal;
import es.espinaco.xmltvConverter.canalplus.entities.Programas;

@Component
@Scope("prototype")
public class CorrectCanal implements Callable<String> {
	
	private Canal canal;

	public CorrectCanal() {
		
	}

	@Override
	public String call() throws Exception {
		String[] hora;
		boolean controlInicio = false, controlFin = false;
		int horaInicio = 0, horaFin = 0;
		for (Programas programa : canal.getProgramas()) {
			hora = programa.getHoraInicio().split(":");
			if (controlInicio || Integer.parseInt(hora[0]) < horaInicio) {
				controlInicio = true;
			}
			programa.setAumentarDiaInicio(controlInicio);
			hora = programa.getHoraFin().split(":");
			if (controlFin || Integer.parseInt(hora[0]) < horaFin) {
				controlFin = true;
			}
			programa.setAumentarDiaFin(controlFin);
		}
		return "";
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

}
