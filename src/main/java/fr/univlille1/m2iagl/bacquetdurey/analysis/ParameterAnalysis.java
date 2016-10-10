package fr.univlille1.m2iagl.bacquetdurey.analysis;

public abstract class ParameterAnalysis extends Analysis{

	protected String parameterName;
	protected String commentText;
	
	public ParameterAnalysis(String parameterName, String commentText){
		this.parameterName = parameterName;
		this.commentText = commentText;
	}
}
