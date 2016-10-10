package fr.univlille1.m2iagl.bacquetdurey.analysis.removed;

import fr.univlille1.m2iagl.bacquetdurey.analysis.MethodAnalysis;

public class RemovedMethodAnalysis extends MethodAnalysis implements Removed{

	public RemovedMethodAnalysis(String methodName, String commentText) {
		super(methodName, commentText);
		
		analysisMessage = "METHOD : " + methodName + "\n" + 
				"\t\tComment text removed\n" +
				"\t\t\tOn master : " + this.commentText + "\n" + 
				"\t\t\tOn pull request : NOTHING\n";
		
		
	}


}
