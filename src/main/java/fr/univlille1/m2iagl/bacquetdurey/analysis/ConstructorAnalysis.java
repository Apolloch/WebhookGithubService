package fr.univlille1.m2iagl.bacquetdurey.analysis;

import java.util.ArrayList;
import java.util.List;

public abstract class ConstructorAnalysis extends Analysis{

	protected String constructorName;
	protected String commentText;
	
	protected List<ParameterAnalysis> parametersAnalysis;
	
	
	public ConstructorAnalysis(String constructorName, String commentText){
		this.constructorName = constructorName;
		this.commentText = commentText;

		this.parametersAnalysis = new ArrayList<>();
	}
	
	public void addParameterAnalysis(ParameterAnalysis parameterAnalysis){
		parametersAnalysis.add(parameterAnalysis);
	}
	
	public List<ParameterAnalysis> getParametersAnalysis(){
		return parametersAnalysis;
	}
}
