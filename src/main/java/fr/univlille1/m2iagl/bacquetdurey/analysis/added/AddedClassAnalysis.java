package fr.univlille1.m2iagl.bacquetdurey.analysis.added;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ClassAnalysis;

public class AddedClassAnalysis extends ClassAnalysis implements Added{

	public AddedClassAnalysis(String className, String commentText) {
		super(className, commentText);
		
		analysisMessage = "CLASS : " + className + "\n" + 
				"\tComment text added\n" +
				"\t\tOn master : NOTHING\n" + 
				"\t\tOn pull request : " + this.commentText + "\n";
	}

	

}
