package es.espinaco.xmltvConverter.canalplus.entities;

import com.google.gson.annotations.SerializedName;

import es.espinaco.xmltvConverter.canalplus.entities.programs.BaseProgram;

public class Programas {

	@SerializedName(value = "ESTRENO")
	private Boolean estreno;
	@SerializedName(value = "DIRECTO")
	private Boolean directo;
	@SerializedName(value = "TEMPORADA")
	private String temporada;
	@SerializedName(value = "TITULO")
	private String titulo;
	@SerializedName(value = "GENERO")
	private String genero;
	@SerializedName(value = "DURACION")
	private Integer duracion;
	@SerializedName(value = "DURACION_VISUAL")
	private Integer duracionVisual;
	@SerializedName(value = "HORA_INICIO")
	private String horaInicio;
	@SerializedName(value = "HORA_FIN")
	private String horaFin;
	@SerializedName(value = "ELEMENTO")
	private String elemento;
	@SerializedName(value = "EVENTO")
	private String Evento;
	@SerializedName(value = "URL")
	private String url;
	private boolean aumentarDiaInicio = false;
	private boolean aumentarDiaFin = false;
	private BaseProgram baseProgram;

	public Boolean getEstreno() {
		return estreno;
	}

	public void setEstreno(Boolean estreno) {
		this.estreno = estreno;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getDuracionVisual() {
		return duracionVisual;
	}

	public void setDuracionVisual(Integer duracionVisual) {
		this.duracionVisual = duracionVisual;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getEvento() {
		return Evento;
	}

	public void setEvento(String evento) {
		Evento = evento;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getDirecto() {
		return directo;
	}

	public void setDirecto(Boolean directo) {
		this.directo = directo;
	}

	public boolean isAumentarDiaInicio() {
		return aumentarDiaInicio;
	}

	public void setAumentarDiaInicio(boolean aumentarDiaInicio) {
		this.aumentarDiaInicio = aumentarDiaInicio;
	}

	public boolean isAumentarDiaFin() {
		return aumentarDiaFin;
	}

	public void setAumentarDiaFin(boolean aumentarDiaFin) {
		this.aumentarDiaFin = aumentarDiaFin;
	}

	public BaseProgram getBaseProgram() {
		return baseProgram;
	}

	public void setBaseProgram(BaseProgram baseProgram) {
		this.baseProgram = baseProgram;
	}

}
