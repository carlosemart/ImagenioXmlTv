package es.espinaco.xmltvConverter.canalplus.entities.programs;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TvShowProgram implements ProgramParser {

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
		el = doc.getElementsByTag("main").first();
		if (el != null) {
			el = el.getElementsByAttributeValue("class", "cover").first();
			if (el != null) {
				toReturn.setIcon(el.getElementsByTag("img").first().attr("src"));
			}
		}
		el = doc.getElementsByAttributeValue("class","title-especial").first();
		if (el != null) {
			Element actual = el.getElementsByAttributeValue("class", "h-gamma").first();
			if ("p".equals(actual.nodeName())) {
				if (actual.childNodeSize() > 0) {
					toReturn.setTitle(actual.childNode(0).toString());
				}
			}
			actual = el.getElementsByAttributeValue("class", "h-epsilon").first();
			if ("h1".equals(actual.nodeName())) {
				if (actual.childNodeSize() > 0) {
					toReturn.setSubTitle(actual.childNode(0).toString());
				}
			}
			
		}
		return toReturn;
	}

}
