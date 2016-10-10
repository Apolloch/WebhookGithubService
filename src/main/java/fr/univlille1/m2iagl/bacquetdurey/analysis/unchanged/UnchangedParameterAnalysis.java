package fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ParameterAnalysis;

public class UnchangedParameterAnalysis extends ParameterAnalysis implements Unchanged{

	public UnchangedParameterAnalysis(String parameterName, String commentText) {
		super(parameterName, commentText);
		
		analysisMessage = "PARAMETER : " + parameterName + "\n"
				+ "\tComment text has no changes : " + commentText + "\n";
	}

}
