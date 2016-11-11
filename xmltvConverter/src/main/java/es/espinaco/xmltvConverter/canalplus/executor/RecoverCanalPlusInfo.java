package es.espinaco.xmltvConverter.canalplus.executor;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import es.espinaco.xmltvConverter.canalplus.entities.Canal;
import es.espinaco.xmltvConverter.canalplus.entities.MovistarPlusResponse;
import es.espinaco.xmltvConverter.canalplus.entities.Programas;
import es.espinaco.xmltvConverter.threads.CorrectCanal;
import es.espinaco.xmltvConverter.threads.GenerateMovistarPlusResponse;
import es.espinaco.xmltvConverter.threads.ProgramExtraInfo;

@Service
public class RecoverCanalPlusInfo {

	private static final String url = "http://www.plus.es/guia/#DATE1#/?v=json&verticalScroll=true&isMobile=false&fecha=#DATE2#";

	// private static final String urlFormatterString = "YYYY-MM-dd";
	// private static final String querystringFormatterString = "ddMMYYYY";

	@Resource(name = "urlFormatter")
	private SimpleDateFormat urlFormatter;

	@Resource(name = "querystringFormatter")
	private SimpleDateFormat querystringFormatter;

	@Resource(name = "movistarGson")
	private Gson parser;

	@Resource(name = "recoverInfoTaskExecutor")
	private TaskExecutor taskExecutor;

	@Autowired
	private ApplicationContext context;

	@Value("${movistarPlus.numberOfDays:7}")
	private int numberOfDays;

	@Value("${movistarPlus.jsonCache}")
	private boolean cache;

	@Value("${basedir}")
	private String baseDir;

	@Value("${movistarPlus.jsonFolder}")
	private String jsonFolder;

	@Value("${movistarPlus.urlGuia}")
	private String urlGuia = url;

	@Value("${movistarPlus.processExtendInfo:value}")
	private Boolean processExtendInfo;

	public Map<Calendar, MovistarPlusResponse> recover() throws IOException {
		// Inicializando Parser

		File cacheFolder = null;
		Map<Calendar, MovistarPlusResponse> toReturn = new HashMap<Calendar, MovistarPlusResponse>();
		if (cache) {
			File baseFolder = new File(baseDir);
			cacheFolder = new File(baseFolder, jsonFolder);
			if (!cacheFolder.exists()) {
				cacheFolder.mkdirs();
			}
		}
		
		List<FutureTask<Map.Entry<Calendar, MovistarPlusResponse>>> hilos = new ArrayList<FutureTask<Map.Entry<Calendar, MovistarPlusResponse>>>();
		GenerateMovistarPlusResponse mr;
		for (int i = 0; i < numberOfDays; i++) {
			mr = context.getBean(GenerateMovistarPlusResponse.class);
			mr.setCacheFolder(cacheFolder);
			mr.setI(i);
			FutureTask<Map.Entry<Calendar, MovistarPlusResponse>> actual = new FutureTask<Map.Entry<Calendar, MovistarPlusResponse>>(
					mr);
			hilos.add(actual);
			taskExecutor.execute(actual);
		}
		Entry<Calendar, MovistarPlusResponse> valor;
		for (FutureTask<Map.Entry<Calendar, MovistarPlusResponse>> a : hilos) {
			try {
				valor = a.get();
				toReturn.put(valor.getKey(), valor.getValue());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		return toReturn;
	}

	public void correctInfo(Map<Calendar, MovistarPlusResponse> toCorrect) {
		for (Entry<Calendar, MovistarPlusResponse> response : toCorrect.entrySet()) {
			correctMovistarPlusResponse(response.getValue());
		}
	}

	private void correctMovistarPlusResponse(MovistarPlusResponse value) {
		List<FutureTask<String>> hilos = new ArrayList<FutureTask<String>>();
		CorrectCanal cc;
		FutureTask<String> actual;
		ProgramExtraInfo einfo;
		for (Canal canal : value.getData().getCanales()) {
			cc = context.getBean(CorrectCanal.class);
			cc.setCanal(canal);
			actual = new FutureTask<String>(cc);
			hilos.add(actual);
			taskExecutor.execute(actual);
			if (processExtendInfo) {
				for (Programas programa : canal.getProgramas()) {
					einfo = context.getBean(ProgramExtraInfo.class);
					einfo.setPrograma(programa);
					actual = new FutureTask<String>(einfo);
					hilos.add(actual);
					taskExecutor.execute(actual);
				}
			}
		}
		for (FutureTask<String> a : hilos) {
			try {
				a.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
