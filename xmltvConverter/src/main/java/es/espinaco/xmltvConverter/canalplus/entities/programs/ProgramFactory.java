package es.espinaco.xmltvConverter.canalplus.entities.programs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ProgramFactory {

	@Autowired
	private ApplicationContext context;

	public ProgramParser getProgram(String program) {
		try {
			return context.getBean(ProgramTypes.valueOf(program).getType());
		} catch (NullPointerException | IllegalArgumentException e) {
			System.err.println(program);
			return context.getBean(GenericProgram.class);
		}
	}

}
