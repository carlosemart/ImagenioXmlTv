package es.espinaco.xmltvConverter.canalplus.entities.programs;

public enum ProgramTypes {
	
	Series(TvShowProgram.class);
	
	Class<ProgramParser> type;
	
	private ProgramTypes(Class type) {
		this.type = type;
	}

	public Class<ProgramParser> getType() {
		return type;
	}
	
}
