package fr.univlille1.m2iagl.bacquetdurey.analysis;

import fr.univlille1.m2iagl.bacquetdurey.model.ClassModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ConstructorModel;
import fr.univlille1.m2iagl.bacquetdurey.model.FieldModel;
import fr.univlille1.m2iagl.bacquetdurey.model.MethodModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ParameterModel;

public class SpecialFactory {

	public static ClassModel createClassWithNoComment(String name) {
		return new ClassModel(name, "");
	}
	
	public static ClassModel createClassWithSpecificComment(String name, String commentText) {
		return new ClassModel(name, commentText);
	}
	
	public static MethodModel createMethodWithNoComment(String name) {
		return new MethodModel("", "", name, "");
	}
	
	public static MethodModel createMethodWithSpecificComment(String name, String commentText) {
		return new MethodModel("", "", name, commentText);
	}
	
	public static FieldModel createFieldWithNoComment(String name) {
		return new FieldModel("", name, "");
	}
	
	public static FieldModel createFieldWithSpecificComment(String name, String commentText) {
		return new FieldModel("", name, commentText);
	}
	
	public static ConstructorModel createConstructorWithNoComment(String name) {
		return new ConstructorModel(name, "");
	}
	
	public static ConstructorModel createConstructorWithSpecificComment(String name, String commentText) {
		return new ConstructorModel(name, commentText);
	}
	
	public static ParameterModel createParameterWithNoComment(String name) {
		return new ParameterModel("", name, "");
	}
	
	public static ParameterModel createParameterWithSpecificComment(String name, String commentText) {
		return new ParameterModel("", name, commentText);
	}
	
	

}
