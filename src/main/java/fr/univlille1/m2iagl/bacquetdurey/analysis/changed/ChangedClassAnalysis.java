package fr.univlille1.m2iagl.bacquetdurey.analysis.changed;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ClassAnalysis;

public class ChangedClassAnalysis extends ClassAnalysis implements Changed{

	private String pullRequestCommentText;
	
	public ChangedClassAnalysis(String className, String masterCommentText, String pullRequestCommentText) {
		super(className, masterCommentText);
		
		this.pullRequestCommentText = pullRequestCommentText;
		
		analysisMessage = "CLASS : " + className + "\n" + 
				"\tComment text changed\n" +
				"\t\tOn master : " + commentText + "\n" + 
				"\t\tOn pull request : " + this.pullRequestCommentText + "\n";
		
		
		
	}

	
	

}
