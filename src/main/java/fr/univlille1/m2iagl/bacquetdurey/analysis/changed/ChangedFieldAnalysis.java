package fr.univlille1.m2iagl.bacquetdurey.analysis.changed;

import fr.univlille1.m2iagl.bacquetdurey.analysis.FieldAnalysis;

public class ChangedFieldAnalysis extends FieldAnalysis implements Changed{
	
	private String pullRequestCommentText;

	public ChangedFieldAnalysis(String fieldName, String masterCommentText, String pullRequestCommentText) {
		super(fieldName, masterCommentText);
	
		this.pullRequestCommentText = pullRequestCommentText;
		
		analysisMessage = "\tFIELD : " + fieldName + "\n" + 
				"\t\tComment text changed\n" +
				"\t\t\tOn master : " + commentText + "\n" + 
				"\t\t\tOn pull request : " + this.pullRequestCommentText + "\n";
	}


}
