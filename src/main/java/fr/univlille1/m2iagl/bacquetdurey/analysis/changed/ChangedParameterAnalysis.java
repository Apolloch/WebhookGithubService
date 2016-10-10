package fr.univlille1.m2iagl.bacquetdurey.analysis.changed;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ParameterAnalysis;

public class ChangedParameterAnalysis extends ParameterAnalysis implements Changed{

	protected String pullRequestCommentText;
	
	public ChangedParameterAnalysis(String parameterName, String masterCommentText, String pullRequestCommentText) {
		super(parameterName, masterCommentText);
		
		this.pullRequestCommentText = pullRequestCommentText;
		
		analysisMessage = "\t\tPARAMETER : " + parameterName + "\n" + 
				"\t\t\tComment text changed\n" +
				"\t\t\t\tOn master : " + commentText + "\n" + 
				"\t\t\t\tOn pull request : " + this.pullRequestCommentText + "\n";
	}

	
	
}
