package es.espinaco.xmltvConverter.canalplus.adapter;

import java.lang.reflect.Type;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import es.espinaco.xmltvConverter.canalplus.entities.Canal;
import es.espinaco.xmltvConverter.canalplus.entities.ListCanales;

@Component
public class ListCanalesTypeAdapter implements JsonDeserializer<ListCanales>  {
	
	@Resource(name="emptyGson")
	private Gson gson;
	
	public ListCanales deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

		JsonObject json = element.getAsJsonObject();

        ListCanales canales = new ListCanales();

        for (Entry<String, JsonElement> entry : json.entrySet())
        {
            String name = entry.getKey();
            Canal canal = gson.fromJson(entry.getValue(), Canal.class);
            canal.setName(name);

            canales.getCanales().add(canal);
             
        }

        return canales;
	}

}
