package fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged;

import fr.univlille1.m2iagl.bacquetdurey.analysis.FieldAnalysis;

public class UnchangedFieldAnalysis extends FieldAnalysis implements Unchanged{

	
	public UnchangedFieldAnalysis(String fieldName, String commentText){
		super(fieldName, commentText);
		
		analysisMessage = "FIELD : " + fieldName + "\n"
				+ "\tComment text has no changes : " + commentText + "\n";
	}
}
