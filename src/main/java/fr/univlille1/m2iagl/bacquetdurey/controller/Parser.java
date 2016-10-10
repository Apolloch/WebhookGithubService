package fr.univlille1.m2iagl.bacquetdurey.controller;

import java.util.ArrayList;
import java.util.List;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.Tag;

import fr.univlille1.m2iagl.bacquetdurey.model.ClassModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ConstructorModel;
import fr.univlille1.m2iagl.bacquetdurey.model.FieldModel;
import fr.univlille1.m2iagl.bacquetdurey.model.MethodModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ParameterModel;

public class Parser {

	public static ClassModel parseClass(ClassDoc classDoc){

		ClassModel classModel = new ClassModel(classDoc.name(), classDoc.commentText());
		ConstructorDoc[] constructorsDoc = classDoc.constructors();

		for(int i=0;i<constructorsDoc.length;i++){
			ConstructorDoc constructorDoc = constructorsDoc[i];
			classModel.addConstructorModel(Parser.parseConstructor(constructorDoc));
		}

		FieldDoc[] fieldsDoc = classDoc.fields();

		for(int i=0;i<fieldsDoc.length;i++){
			FieldDoc fieldDoc = fieldsDoc[i];
			classModel.addFieldModel(Parser.parseField(fieldDoc));
		}

		MethodDoc[] methodsDoc = classDoc.methods();

		for(int i=0;i<methodsDoc.length;i++){
			MethodDoc methodDoc = methodsDoc[i];
			classModel.addMethodModel(Parser.parseMethod(methodDoc));
		}

		return classModel;
	}

	public static ConstructorModel parseConstructor(ConstructorDoc constructorDoc){

		ConstructorModel constructorModel = new ConstructorModel(constructorDoc.name(), constructorDoc.commentText());		


		for(Parameter parameter : constructorDoc.parameters()){
			constructorModel.addParameterModel(Parser.parseParameter(parameter));
		}

		return constructorModel;
	}

	public static ParameterModel parseParameter(Parameter parameter){
		return new ParameterModel(parameter.typeName(), parameter.name(), "");
	}

	public static ParameterModel parseParameterTag(ParamTag paramTag){
		return new ParameterModel("", paramTag.parameterName(), paramTag.parameterComment());
	}

	public static FieldModel parseField(FieldDoc fieldDoc){
		return new FieldModel(fieldDoc.name(), fieldDoc.type().typeName(), fieldDoc.commentText());
	}

	public static MethodModel parseMethod(MethodDoc methodDoc){

		MethodModel methodModel = new MethodModel(Parser.getVisibility(methodDoc), methodDoc.returnType().typeName(), methodDoc.name(), methodDoc.commentText());

		Tag[] tags = methodDoc.tags();
		
		methodModel.setCommentTextReturn(parseCommentTextReturn(tags));

		methodModel.addParametersModel(merge(methodDoc.parameters(), parseParamTags(tags)));

		return methodModel;
	}
	
	private static String parseCommentTextReturn(Tag [] tags){
		for(Tag tag : tags){
			if(tag.name().equals("@return"))
				return tag.text();
		}
		
		return "";
	}

	private static List<ParamTag> parseParamTags(Tag [] tags){

		List<ParamTag> paramTags = new ArrayList<ParamTag>();
		
		for(Tag tag : tags){
			if(tag.name().equals("@param"))
				paramTags.add((ParamTag) tag);
		}

		return paramTags;
	}


	private static String getVisibility(MethodDoc methodDoc){
		if(methodDoc.isPublic())
			return "public";

		if(methodDoc.isPrivate())
			return "private";

		if(methodDoc.isProtected())
			return "protected";

		return "";
	}

	private static List<ParameterModel> merge(Parameter[] parameters, List<ParamTag> paramTags){

		List<ParameterModel> parametersModel = new ArrayList<ParameterModel>();
		for(Parameter parameter : parameters){
			parametersModel.add(Parser.parseParameter(parameter));
		}
		
		for(ParamTag paramTag : paramTags){
			ParameterModel parameterModel = getParameterModelFromName(parametersModel, paramTag.parameterName());
			
			if(parameterModel != null)
				parameterModel.setCommentText(paramTag.parameterComment());
			else
				parametersModel.add(parseParameterTag(paramTag));
		}
		
		
		
		return parametersModel;

	}
	
	private static ParameterModel getParameterModelFromName(List<ParameterModel> parametersModel, String name){
		for(int i=0;i<parametersModel.size();i++){
			ParameterModel parameterModel = parametersModel.get(i);
			if(name.equals(parameterModel.getName()))
				return parameterModel;
		}
		return null;
	}


}
