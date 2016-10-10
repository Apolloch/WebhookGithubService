package fr.univlille1.m2iagl.bacquetdurey.analysis.removed;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ClassAnalysis;

public class RemovedClassAnalysis extends ClassAnalysis implements Removed{

	public RemovedClassAnalysis(String className, String commentText) {
		super(className, commentText);
		
		analysisMessage = "CLASS : " + className + "\n" + 
				"\tComment text removed\n" +
				"\t\tOn master : " + this.commentText + "\n" + 
				"\t\tOn pull request : NOTHING\n";
	}

	

}
