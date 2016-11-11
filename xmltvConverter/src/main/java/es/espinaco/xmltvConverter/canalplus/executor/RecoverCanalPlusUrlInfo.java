package es.espinaco.xmltvConverter.canalplus.executor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.Charset;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import es.espinaco.xmltvConverter.canalplus.entities.programs.BaseProgram;
import es.espinaco.xmltvConverter.canalplus.entities.programs.ProgramFactory;

@Component
public class RecoverCanalPlusUrlInfo {

	@Value("${movistarPlus.urlCache}")
	private boolean cache;

	@Value("${basedir}")
	private String baseDir;

	@Value("${movistarPlus.urlFolder}")
	private String urlFolder;

	@Autowired
	private ProgramFactory programFactory;

	private File cacheFolder;

	@PostConstruct
	public void init() {
		if (this.cache) {
			File baseFolder = new File(baseDir);
			File cacheFolder = new File(baseFolder, urlFolder);
			if (!cacheFolder.exists()) {
				cacheFolder.mkdirs();
			}
			this.cacheFolder = cacheFolder;
		}
	}

	public BaseProgram convert(String id, String url, String genero) throws IOException {
		BaseProgram toReturn = null;
		InputStream is;
		URL urlBase = new URL(url);
		if (cache) {
			File fichero = new File(cacheFolder, id + ".txt");
			if (!fichero.exists()) {
				is = urlBase.openConnection().getInputStream();
				OutputStream os = new BufferedOutputStream(new FileOutputStream(fichero));
				IOUtils.copy(is, os);
				is.close();
				os.close();
			} else {
				fichero.setLastModified(System.currentTimeMillis());
			}
			is = new BufferedInputStream(new FileInputStream(fichero));
		} else {
			is = urlBase.openConnection().getInputStream();
		}
		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer, Charset.forName("UTF8"));
		String theString = writer.toString();
		Document doc = Jsoup.parse(theString);
		toReturn = programFactory.getProgram(genero).processHtml(doc);

		if (toReturn == null) {
			System.err.println(genero);
			return null;
		}
		return toReturn;
	}

}
