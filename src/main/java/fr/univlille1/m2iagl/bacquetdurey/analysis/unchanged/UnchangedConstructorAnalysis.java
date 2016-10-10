package fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ConstructorAnalysis;

public class UnchangedConstructorAnalysis extends ConstructorAnalysis implements Unchanged{

	public UnchangedConstructorAnalysis(String constructorName, String commentText) {
		super(constructorName, commentText);
		
		analysisMessage = "CONSTRUCTOR : " + constructorName + "\n"
				+ "\tComment text has no changes : " + commentText + "\n";
	}

}
