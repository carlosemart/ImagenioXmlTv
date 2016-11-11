package es.espinaco.xmltvConverter.canalplus.entities.programs;

import org.jsoup.nodes.Document;

public interface ProgramParser {
	
	public BaseProgram processHtml(Document doc);

}
