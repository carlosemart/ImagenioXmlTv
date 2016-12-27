package es.espinaco.xmltvConverter.canalplus.entities.programs;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GenericProgram implements ProgramParser {

	@Override
	public BaseProgram processHtml(Document doc) {
		BaseProgram toReturn = new BaseProgram();
		StringBuilder sb = new StringBuilder();
		Element el = doc.getElementsByAttributeValue("itemprop", "description").first();
		for (Node actual : el.childNodes()) {
			if ("p".equals(actual.nodeName())) {
				if (actual.childNodeSize() > 0) {
					sb.append(actual.childNode(0).toString());
				}
			}
		}
		toReturn.setDescription(sb.toString());
		return toReturn;
	}

}
