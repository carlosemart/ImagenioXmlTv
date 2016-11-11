package es.espinaco.xmltvConverter.threads;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import es.espinaco.xmltvConverter.canalplus.entities.MovistarPlusResponse;

@Component
@Scope("prototype")
public class GenerateMovistarPlusResponse implements Callable<Map.Entry<Calendar, MovistarPlusResponse>>
{
	private static final String url = "http://www.plus.es/guia/#DATE1#/?v=json&verticalScroll=true&isMobile=false&fecha=#DATE2#";
	private File cacheFolder;
	private int i;
	
	@Resource(name = "urlFormatter")
	private SimpleDateFormat urlFormatter;

	@Resource(name = "querystringFormatter")
	private SimpleDateFormat querystringFormatter;

	@Resource(name = "movistarGson")
	private Gson parser;

	@Value("${movistarPlus.jsonCache}")
	private boolean cache;

	@Value("${movistarPlus.urlGuia}")
	private String urlGuia = url;

	
	public GenerateMovistarPlusResponse() {
		
	}

	@Override
	public Entry<Calendar, MovistarPlusResponse> call() throws Exception {
		MovistarPlusResponse toreturn;
		Calendar nuevaFecha;
		InputStream is;
		Date fecha = new Date();
		String basicUrl;
		File fichero;
		URL urlBase;
		nuevaFecha = Calendar.getInstance();
		nuevaFecha.setTime(fecha);
		nuevaFecha.add(Calendar.DAY_OF_MONTH, i);
		basicUrl = urlGuia.replace("#DATE1#", urlFormatter.format(nuevaFecha.getTime()));
		basicUrl = basicUrl.replace("#DATE2#", querystringFormatter.format(nuevaFecha.getTime()));
		urlBase = new URL(basicUrl);
		if (cache) {
			fichero = new File(cacheFolder, querystringFormatter.format(nuevaFecha.getTime()) + ".txt");
			if (!fichero.exists()) {
				is = urlBase.openConnection().getInputStream();
				OutputStream os = new BufferedOutputStream(new FileOutputStream(fichero));
				IOUtils.copy(is, os);
				is.close();
				os.close();
			}
			is = new BufferedInputStream(new FileInputStream(fichero));
		} else {
			is = urlBase.openConnection().getInputStream();
		}
		toreturn = parser.fromJson(new InputStreamReader(is), MovistarPlusResponse.class);
		is.close();
		return new AbstractMap.SimpleEntry<Calendar, MovistarPlusResponse>(nuevaFecha, toreturn);
	}

	public File getCacheFolder() {
		return cacheFolder;
	}

	public void setCacheFolder(File cacheFolder) {
		this.cacheFolder = cacheFolder;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}
