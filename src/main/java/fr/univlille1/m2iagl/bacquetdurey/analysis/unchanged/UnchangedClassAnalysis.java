package fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged;

import fr.univlille1.m2iagl.bacquetdurey.analysis.ClassAnalysis;

public class UnchangedClassAnalysis extends ClassAnalysis implements Unchanged{

	public UnchangedClassAnalysis(String className, String commentText) {
		super(className, commentText);
		
		analysisMessage = "CLASS : " + className + "\n"
						+ "\tComment text has no changes : " + commentText + "\n";
	}

	
	
}
