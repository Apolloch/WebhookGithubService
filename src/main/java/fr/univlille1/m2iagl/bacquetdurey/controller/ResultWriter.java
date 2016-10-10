package fr.univlille1.m2iagl.bacquetdurey.controller;

import java.io.PrintWriter;

import fr.univlille1.m2iagl.bacquetdurey.analysis.AnalysisModel;
import fr.univlille1.m2iagl.bacquetdurey.analysis.ClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.ConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.FieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.MethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.ParameterAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.model.MethodModel;
import fr.univlille1.m2iagl.bacquetdurey.model.PackageModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ParameterModel;

public class ResultWriter{
	
	PrintWriter printWriter;
	
	AnalysisModel analysisModel;
	
	public ResultWriter(PrintWriter printWriter, AnalysisModel analysisModel){
		this.printWriter = printWriter;
		this.analysisModel = analysisModel;
	}
	
	public void write(){
		
		for(ClassAnalysis classModel : analysisModel.getClassesAnalysis()){
			writeClassAnalysis(classModel);
		}
		
		printWriter.close();
	}

	public void writeClassAnalysis(ClassAnalysis classAnalysis){
		
		printWriter.write(classAnalysis.getAnalysisMessage());
		
		for(FieldAnalysis fieldAnalysis : classAnalysis.getFieldsAnalysis()){
			writeFieldAnalysis(fieldAnalysis);
		}
		
		for(ConstructorAnalysis constructorAnalysis : classAnalysis.getConstructorsAnalysis()){
			writeConstructorAnalysis(constructorAnalysis);
		}
		
		for(MethodAnalysis methodAnalysis : classAnalysis.getMethodsAnalysis()){
			writeMethodAnalysis(methodAnalysis);
		}
			

	}

	public void writeConstructorAnalysis(ConstructorAnalysis constructorAnalysis){
		
		printWriter.write(constructorAnalysis.getAnalysisMessage());
		
		printWriter.write("\t(\n");
		for(ParameterAnalysis parameterAnalysis : constructorAnalysis.getParametersAnalysis()){
			writeParameterAnalysis(parameterAnalysis);
		}
		printWriter.write("\t)\n");

	}

	public void writeFieldAnalysis(FieldAnalysis fieldAnalysis){
		
		printWriter.write(fieldAnalysis.getAnalysisMessage());
		printWriter.write("\n");

	}
	
	public void writeMethodAnalysis(MethodAnalysis methodAnalysis){
		
		printWriter.write(methodAnalysis.getAnalysisMessage());
	
		printWriter.write("\t(\n");
		for(ParameterAnalysis parameterAnalysis : methodAnalysis.getParametersAnalysis()){
			writeParameterAnalysis(parameterAnalysis);
		}
		
		printWriter.write("\t)\n");
	}


	public void writeParameterAnalysis(ParameterAnalysis parameterAnalysis){
		
		printWriter.write(parameterAnalysis.getAnalysisMessage());
		printWriter.write("\n");
	}



}
