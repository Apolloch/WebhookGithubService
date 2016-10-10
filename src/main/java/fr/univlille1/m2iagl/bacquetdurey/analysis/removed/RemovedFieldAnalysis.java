package fr.univlille1.m2iagl.bacquetdurey.analysis.removed;

import fr.univlille1.m2iagl.bacquetdurey.analysis.FieldAnalysis;

public class RemovedFieldAnalysis extends FieldAnalysis implements Removed{

	public RemovedFieldAnalysis(String className, String commentText) {
		super(className, commentText);
		
		analysisMessage = "\tFIELD : " + className + "\n" + 
				"\t\tComment text removed\n" +
				"\t\t\tOn master : " + this.commentText + "\n" + 
				"\t\t\tOn pull request : NOTHING\n";
		
	}



}
