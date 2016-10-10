package fr.univlille1.m2iagl.bacquetdurey.analysis.added;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ParameterAnalysis;

public class AddedParameterAnalysis extends ParameterAnalysis implements Added{

	public AddedParameterAnalysis(String parameterName, String commentText) {
		super(parameterName, commentText);
		
		analysisMessage = "\tPARAMETER: " + parameterName + "\n" + 
				"\t\t\tComment text added\n" +
				"\t\t\t\tOn master : NOTHING\n" + 
				"\t\t\t\tOn pull request : " + this.commentText + "\n";
	}

}
