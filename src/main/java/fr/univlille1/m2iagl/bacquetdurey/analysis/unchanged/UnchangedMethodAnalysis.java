package fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged;

import fr.univlille1.m2iagl.bacquetdurey.analysis.MethodAnalysis;

public class UnchangedMethodAnalysis extends MethodAnalysis implements Unchanged{

	public UnchangedMethodAnalysis(String methodName, String commentText) {
		super(methodName, commentText);
		
		analysisMessage = "METHOD : " + methodName + "\n"
				+ "\tComment text has no changes : " + commentText + "\n";
	}

}
