package fr.univlille1.m2iagl.bacquetdurey.analysis.changed;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ConstructorAnalysis;

public class ChangedConstructorAnalysis extends ConstructorAnalysis implements Changed{

	protected String pullRequestCommentText;
	
	public ChangedConstructorAnalysis(String constructorName, String masterCommentText, String pullRequestCommentText) {
		super(constructorName, masterCommentText);
		
		this.pullRequestCommentText = pullRequestCommentText;
		
		analysisMessage = "\tCONSTRUCTOR : " + constructorName + "\n" + 
				"\t\tComment text changed\n" +
				"\t\t\tOn master : " + commentText + "\n" + 
				"\t\t\tOn pull request : " + this.pullRequestCommentText + "\n";
	}

	

}
