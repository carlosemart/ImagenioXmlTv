package es.espinaco.xmltvConverter.threads;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.espinaco.xmltvConverter.canalplus.entities.Programas;
import es.espinaco.xmltvConverter.canalplus.entities.programs.BaseProgram;
import es.espinaco.xmltvConverter.canalplus.executor.RecoverCanalPlusUrlInfo;

@Component
@Scope("prototype")
public class ProgramExtraInfo implements Callable<String> {
	
	private Programas programa;
	
	@Autowired
	private RecoverCanalPlusUrlInfo info;

	@Override
	public String call() throws Exception {

          BaseProgram extendedInfo = info.convert(programa.getEvento(), programa.getUrl(), programa.getGenero());
          programa.setBaseProgram(extendedInfo);
          return "";
	}

	public Programas getPrograma() {
		return programa;
	}

	public void setPrograma(Programas programa) {
		this.programa = programa;
	}

}
