package fr.univlille1.m2iagl.bacquetdurey.analysis;

public abstract class FieldAnalysis extends Analysis{

	protected String fieldName;
	protected String commentText;
	
	
	public FieldAnalysis(String className, String commentText){
		this.fieldName = className;
		this.commentText = commentText;
	}
	
	public String getFieldName(){
		return fieldName;
	}
}
