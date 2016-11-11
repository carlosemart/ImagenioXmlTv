package es.espinaco.xmltvConverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import es.espinaco.xmltvConverter.canalplus.entities.MovistarPlusResponse;
import es.espinaco.xmltvConverter.canalplus.executor.RecoverCanalPlusInfo;

@Service
public class XmltvConverterImpl implements XmltvConverter {
	
	@Value("${basedir}")
	private String baseDir;
	
	@Autowired
	private RecoverCanalPlusInfo recoverCanalPlusInfo;
	
	
	
	/* (non-Javadoc)
	 * @see es.espinaco.xmltvConverter.XmltvConverter#process()
	 */
	public void process() throws IOException
	{
		
	   
	    File baseFolder = new File(baseDir);
	    if (!(baseFolder.exists() && baseFolder.isDirectory()))
	    {
	      throw new FileNotFoundException(baseDir);
	    }

	    Map<String, String> canales = getMap();
	    Map<String, String> nombres = getMapName();
	    
	    Map<Calendar, MovistarPlusResponse> info = recoverCanalPlusInfo.recover();
	    recoverCanalPlusInfo.correctInfo(info);
	    
//	    
//	    CanalplusConverter converter = new CanalplusConverter(conf); 
//
//	    Tv toreturn = converter.convert(info, canales, nombres);
//	    
//	    System.out.println(getStringFromJaxb(toreturn));
	}
	
	private Map<String, String> getMap() throws IOException {
	    Map<String, String> toReturn = new HashMap<String, String>();
	    InputStream is =
	        XmltvConverter.class.getClassLoader().getResourceAsStream("traductorCanales.txt");
		BufferedReader read = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF8")));
	    String linea = read.readLine();
	    while (linea != null) {
	      String[] separado = linea.split(":");
	      if (separado.length > 1) {
	        toReturn.put(separado[0], "".equals(separado[1]) ? null : separado[1]);
	      }
	      linea = read.readLine();
	    }
	    return toReturn;
	  }

	  private Map<String, String> getMapName() throws IOException {
	    Map<String, String> toReturn = new HashMap<String, String>();
	    InputStream is = XmltvConverter.class.getClassLoader().getResourceAsStream("nombreCanales.txt");
	    BufferedReader read = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF8")));
	    String linea = read.readLine();
	    while (linea != null) {
	      String[] separado = linea.split(":");
	      if (separado.length > 1) {
	        toReturn.put(separado[0], "".equals(separado[1]) ? null : separado[1]);
	      }
	      linea = read.readLine();
	    }
	    return toReturn;
	  }

}
