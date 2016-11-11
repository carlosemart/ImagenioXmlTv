package es.espinaco.xmltvConverter.canalplus.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Canal {
	
	private String name;
	@SerializedName(value = "DATOS_CADENA")
	private DatosCadena datosCadena;
	@SerializedName(value = "PROGRAMAS")
	private List<Programas> programas;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DatosCadena getDatosCadena() {
		return datosCadena;
	}

	public void setDatosCadena(DatosCadena datosCadena) {
		this.datosCadena = datosCadena;
	}

	public List<Programas> getProgramas() {
		return programas;
	}

	public void setProgramas(List<Programas> programas) {
		this.programas = programas;
	}

}
