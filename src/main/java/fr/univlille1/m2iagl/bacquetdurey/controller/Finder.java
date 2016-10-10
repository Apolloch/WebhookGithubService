package fr.univlille1.m2iagl.bacquetdurey.controller;

import java.util.List;

import fr.univlille1.m2iagl.bacquetdurey.model.ClassModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ConstructorModel;
import fr.univlille1.m2iagl.bacquetdurey.model.FieldModel;
import fr.univlille1.m2iagl.bacquetdurey.model.MethodModel;
import fr.univlille1.m2iagl.bacquetdurey.model.Model;

public class Finder {

	public ClassModel findClassModel(Model model, String className){
		List<ClassModel> classModels = model.getClassModel();
		for(ClassModel classModel : classModels){
			if(classModel.getName().equals(className))
				return classModel;
		}
			
		return null;
	}
	
	public FieldModel findFieldModel(ClassModel model, String fieldName){
		List<FieldModel> fieldModels = model.getFields();
		for(FieldModel fieldModel : fieldModels){
			if(fieldModel.getName().equals(fieldName))
				return fieldModel;
		}
			
		return null;
	}
	
	public ConstructorModel findConstructorModel(ClassModel model, String constructorName){
		List<ConstructorModel> constructorModels = model.getConstructors();
		for(ConstructorModel constructorModel : constructorModels){
			if(constructorModel.getName().equals(constructorName))
				return constructorModel;
		}
			
		return null;
	}
	
	public MethodModel findMethodModel(ClassModel model, String methodName){
		List<MethodModel> methodModels = model.getMethods();
		for(MethodModel methodModel : methodModels){
			if(methodModel.getName().equals(methodName))
				return methodModel;
		}
			
		return null;
	}

}
