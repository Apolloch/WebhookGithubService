package fr.univlille1.m2iagl.bacquetdurey.analysis;

import java.util.List;

public abstract class MethodAnalysis extends Analysis{

	protected String methodName;
	protected String commentText;
	
	protected List<ParameterAnalysis> parametersAnalysis;
	
	
	public MethodAnalysis(String methodName, String commentText){
		this.methodName = methodName;
		this.commentText = commentText;
	}
	
	public void addParameterAnalysis(ParameterAnalysis parameterAnalysis){
		parametersAnalysis.add(parameterAnalysis);
	}
	
	public List<ParameterAnalysis> getParametersAnalysis(){
		return parametersAnalysis;
	}

}
