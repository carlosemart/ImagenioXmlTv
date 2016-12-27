package es.espinaco.xmltvConverter.canalplus.entities;

import java.util.LinkedList;
import java.util.List;

public class ListCanales {
	
	private List<Canal> canales = new LinkedList<Canal>();

	public List<Canal> getCanales() {
		return canales;
	}

	public void setCanales(List<Canal> canales) {
		this.canales = canales;
	}

}
