package fr.univlille1.m2iagl.bacquetdurey.analysis;

import java.util.ArrayList;
import java.util.List;

public class AnalysisModel {

	public static AnalysisModel currentAnalysisModel = new AnalysisModel();
	
	private List<ClassAnalysis> classesAnalysis;
	
	public AnalysisModel(){
		classesAnalysis = new ArrayList<>();
	}
	
	public void addClassAnalysis(ClassAnalysis classAnalysis){
		classesAnalysis.add(classAnalysis);
	}
	
	
	public List<ClassAnalysis> getClassesAnalysis(){
		return classesAnalysis;
	}

}
