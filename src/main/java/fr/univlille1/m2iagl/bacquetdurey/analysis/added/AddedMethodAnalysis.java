package fr.univlille1.m2iagl.bacquetdurey.analysis.added;

import fr.univlille1.m2iagl.bacquetdurey.analysis.MethodAnalysis;

public class AddedMethodAnalysis extends MethodAnalysis implements Added{

	public AddedMethodAnalysis(String methodName, String commentText) {
		super(methodName, commentText);
		
		analysisMessage = "\nCONSTRUCTOR : " + methodName + "\n" + 
				"\t\tComment text added\n" +
				"\t\t\tOn master : NOTHING\n" + 
				"\t\t\tOn pull request : " + this.commentText + "\n";
	}


}
