package fr.univlille1.m2iagl.bacquetdurey.analysis.removed;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ConstructorAnalysis;

public class RemovedConstructorAnalysis extends ConstructorAnalysis implements Removed{

	public RemovedConstructorAnalysis(String constructorName, String commentText) {
		super(constructorName, commentText);
		
		analysisMessage = "\tCONSTRUCTOR : " + constructorName + "\n" + 
				"\t\tComment text removed\n" +
				"\t\t\tOn master : " + this.commentText + "\n" + 
				"\t\t\tOn pull request : NOTHING\n";
	}


}
