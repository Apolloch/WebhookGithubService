package fr.univlille1.m2iagl.bacquetdurey.helper;

import java.util.ArrayList;
import java.util.List;

import fr.univlille1.m2iagl.bacquetdurey.model.ClassModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ConstructorModel;
import fr.univlille1.m2iagl.bacquetdurey.model.FieldModel;
import fr.univlille1.m2iagl.bacquetdurey.model.MethodModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ParameterModel;

public class ListHelper {
	
	public static List<String> retainAllClasses(List<ClassModel> firstList, List<ClassModel> secondList){
		List<String> finalList = new ArrayList<String>();
		
		for(ClassModel firstClass : firstList){
			for(ClassModel secondClass : secondList){
				if(firstClass.getName().equals(secondClass.getName()))
					finalList.add(firstClass.getName());
			}
		}
		
		return finalList;
	}
	
	public static List<String> retainAllParameters(List<ParameterModel> firstList, List<ParameterModel> secondList){
		List<String> finalList = new ArrayList<String>();
		
		for(ParameterModel firstParameter : firstList){
			for(ParameterModel secondParameter : secondList){
				if(firstParameter.getName().equals(secondParameter.getName()))
					finalList.add(firstParameter.getName());
			}
		}
		
		return finalList;
	}
	
	public static List<String> retainAllFields(List<FieldModel> firstList, List<FieldModel> secondList){
		List<String> finalList = new ArrayList<String>();
		
		for(FieldModel firstField : firstList){
			for(FieldModel secondField : secondList){
				if(firstField.getName().equals(secondField.getName()))
					finalList.add(firstField.getName());
			}
		}
		
		return finalList;
	}
	
	public static List<String> retainAllConstructors(List<ConstructorModel> firstList, List<ConstructorModel> secondList){
		List<String> finalList = new ArrayList<String>();
		
		for(ConstructorModel firstConstructor : firstList){
			for(ConstructorModel secondConstructor : secondList){
				if(firstConstructor.getName().equals(secondConstructor.getName()))
					finalList.add(firstConstructor.getName());
			}
		}
		
		return finalList;
	}
	
	public static List<String> retainAllMethods(List<MethodModel> firstList, List<MethodModel> secondList){
		List<String> finalList = new ArrayList<String>();
		
		for(MethodModel firstMethod : firstList){
			for(MethodModel secondMethod : secondList){
				if(firstMethod.getName().equals(secondMethod.getName()))
					finalList.add(firstMethod.getName());
			}
		}
		
		return finalList;
	}
	
	public static FieldModel getFieldModelByName(List<FieldModel> list, String name){
		for(FieldModel fieldModel : list){
			if(fieldModel.getName().equals(name))
				return fieldModel;
		}
		
		return null;
	}
	
	public static ConstructorModel getConstructorModelByName(List<ConstructorModel> list, String name){
		for(ConstructorModel constructorModel : list){
			if(constructorModel.getName().equals(name))
				return constructorModel;
		}
		
		return null;
	}
	
	public static ParameterModel getParameterModelByName(List<ParameterModel> list, String name){
		for(ParameterModel parameterModel : list){
			if(parameterModel.getName().equals(name))
				return parameterModel;
		}
		
		return null;
	}
	
	public static ClassModel getClassModelByName(List<ClassModel> list, String name){
		for(ClassModel classModel : list){
			if(classModel.getName().equals(name))
				return classModel;
		}
		
		return null;
	}
	
	public static MethodModel getMethodModelByName(List<MethodModel> list, String name){
		for(MethodModel methodModel : list){
			if(methodModel.getName().equals(name))
				return methodModel;
		}
		
		return null;
	}
 
}
