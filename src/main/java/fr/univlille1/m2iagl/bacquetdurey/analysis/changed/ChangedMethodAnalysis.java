package fr.univlille1.m2iagl.bacquetdurey.analysis.changed;

import fr.univlille1.m2iagl.bacquetdurey.analysis.MethodAnalysis;

public class ChangedMethodAnalysis extends MethodAnalysis implements Changed{

	protected String pullRequestCommentText;
	
	public ChangedMethodAnalysis(String methodName, String masterCommentText, String pullRequestCommentText) {
		super(methodName, masterCommentText);
		
		this.pullRequestCommentText = pullRequestCommentText;
		
		analysisMessage = "\tMETHOD : " + methodName + "\n" + 
				"\t\tComment text changed\n" +
				"\t\t\tOn master : " + commentText + "\n" + 
				"\t\t\tOn pull request : " + this.pullRequestCommentText + "\n";
	}


}
