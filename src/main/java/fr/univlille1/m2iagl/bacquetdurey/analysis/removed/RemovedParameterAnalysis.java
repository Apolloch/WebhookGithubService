package fr.univlille1.m2iagl.bacquetdurey.analysis.removed;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ParameterAnalysis;

public class RemovedParameterAnalysis extends ParameterAnalysis implements Removed{

	public RemovedParameterAnalysis(String parameterName, String commentText) {
		super(parameterName, commentText);
		
		analysisMessage = "PARAMETER : " + parameterName + "\n" + 
				"\t\tComment text removed\n" +
				"\t\t\tOn master : " + this.commentText + "\n" + 
				"\t\t\tOn pull request : NOTHING\n";
	}

}
