package fr.univlille1.m2iagl.bacquetdurey.analysis.added;

import fr.univlille1.m2iagl.bacquetdurey.analysis.FieldAnalysis;

public class AddedFieldAnalysis extends FieldAnalysis implements Added{

	public AddedFieldAnalysis(String className, String commentText) {
		super(className, commentText);
		
		analysisMessage = "\tFIELD : " + fieldName + "\n" + 
				"\t\tComment text added\n" +
				"\t\t\tOn master : NOTHING\n" + 
				"\t\t\tOn pull request : " + this.commentText + "\n";
	}

	

}
