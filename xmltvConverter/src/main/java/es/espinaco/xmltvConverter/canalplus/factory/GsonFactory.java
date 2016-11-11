package es.espinaco.xmltvConverter.canalplus.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import es.espinaco.xmltvConverter.canalplus.entities.ListCanales;

@Component("gsonFactory")
public class GsonFactory {
	
	@Autowired
	private JsonDeserializer<ListCanales> deserializer;

	public Gson create() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES);
		gsonBuilder.registerTypeAdapter(ListCanales.class, deserializer);
		return gsonBuilder.create();
	}

}
