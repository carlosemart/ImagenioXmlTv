package es.espinaco.xmltvConverter.canalplus.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DatosCadena {
	
	@SerializedName(value = "CODIGO")
	private String codigo;
	@SerializedName(value = "MARCA")
	private String marca;
	@SerializedName(value = "NOMBRE")
	private String nombre;
	@SerializedName(value = "URL")
	private String url;
	@SerializedName(value = "DIAL_PRINCIPAL")
	private List<String> dialPrincipal;
	@SerializedName(value = "DIALES")
	private List<Integer> diales;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getDialPrincipal() {
		return dialPrincipal;
	}

	public void setDialPrincipal(List<String> dialPrincipal) {
		this.dialPrincipal = dialPrincipal;
	}

	public List<Integer> getDiales() {
		return diales;
	}

	public void setDiales(List<Integer> diales) {
		this.diales = diales;
	}

}
