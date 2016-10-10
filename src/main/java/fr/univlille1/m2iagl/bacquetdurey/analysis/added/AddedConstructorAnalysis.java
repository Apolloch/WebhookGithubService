package fr.univlille1.m2iagl.bacquetdurey.analysis.added;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ConstructorAnalysis;

public class AddedConstructorAnalysis extends ConstructorAnalysis implements Added{

	public AddedConstructorAnalysis(String constructorName, String commentText) {
		super(constructorName, commentText);
		

		analysisMessage = "\tCONSTRUCTOR : " + constructorName + "\n" + 
				"\t\tComment text added\n" +
				"\t\t\tOn master : NOTHING\n" + 
				"\t\t\tOn pull request : " + this.commentText + "\n";
	}


}
