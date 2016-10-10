package fr.univlille1.m2iagl.bacquetdurey.analysis;

import java.util.List;

import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedMethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedParameterAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedMethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedParameterAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedMethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedParameterAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedMethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedParameterAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.helper.ListHelper;
import fr.univlille1.m2iagl.bacquetdurey.model.ClassModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ConstructorModel;
import fr.univlille1.m2iagl.bacquetdurey.model.FieldModel;
import fr.univlille1.m2iagl.bacquetdurey.model.MethodModel;
import fr.univlille1.m2iagl.bacquetdurey.model.Model;
import fr.univlille1.m2iagl.bacquetdurey.model.ParameterModel;

public class JavadocAnalyser {



	public static void analyse(Model masterModel, Model pullRequestModel, AnalysisModel analysisModel){

		List<String> existingClassModelNames = ListHelper.retainAllClasses(masterModel.getClassModel(), pullRequestModel.getClassModel());


		for(String className : existingClassModelNames){
			ClassModel masterModelClass = ListHelper.getClassModelByName(masterModel.getClassModel(), className);
			ClassModel pullRequestModelClass = ListHelper.getClassModelByName(pullRequestModel.getClassModel(), className);

			analysisModel.addClassAnalysis(analyseClass(masterModelClass, pullRequestModelClass));
		}

	}

	public static ClassAnalysis analyseClass(ClassModel masterModelClass, ClassModel pullRequestModelClass){

		String masterCommentText = masterModelClass.getCommentText();
		String pullRequestCommentText = pullRequestModelClass.getCommentText();

		ClassAnalysis classAnalysis;

		if(masterCommentText.equals(pullRequestCommentText)){
			classAnalysis = new UnchangedClassAnalysis(masterModelClass.getName(), masterCommentText);

		} else if(masterCommentText.equals("")){
			classAnalysis = new AddedClassAnalysis(masterModelClass.getName(), pullRequestCommentText);

		} else if(pullRequestCommentText.equals("")){
			classAnalysis = new RemovedClassAnalysis(masterModelClass.getName(), masterCommentText);

		} else {
			classAnalysis = new ChangedClassAnalysis(masterModelClass.getName(), masterCommentText, pullRequestCommentText);
		}


		List<String> existingFieldModelNames = ListHelper.retainAllFields(masterModelClass.getFields(), pullRequestModelClass.getFields());


		for(String fieldName : existingFieldModelNames){
			FieldModel masterModelField = ListHelper.getFieldModelByName(masterModelClass.getFields(), fieldName);
			FieldModel pullRequestModelField = ListHelper.getFieldModelByName(pullRequestModelClass.getFields(), fieldName);

			classAnalysis.addFieldAnalysis(analyseField(masterModelField, pullRequestModelField));
		}

		List<String> existingConstructorModelNames = ListHelper.retainAllConstructors(masterModelClass.getConstructors(), pullRequestModelClass.getConstructors());


		for(String constructorName : existingConstructorModelNames){
			ConstructorModel masterModelConstructor = ListHelper.getConstructorModelByName(masterModelClass.getConstructors(), constructorName);
			ConstructorModel pullRequestModelConstructor = ListHelper.getConstructorModelByName(pullRequestModelClass.getConstructors(), constructorName);

			classAnalysis.addConstructorAnalysis(analyseConstructor(masterModelConstructor, pullRequestModelConstructor));
		}

		List<String> existingMethodModelNames = ListHelper.retainAllMethods(masterModelClass.getMethods(), pullRequestModelClass.getMethods());


		for(String methodName : existingMethodModelNames){
			MethodModel masterModelMethod = ListHelper.getMethodModelByName(masterModelClass.getMethods(), methodName);
			MethodModel pullRequestModelMethod = ListHelper.getMethodModelByName(pullRequestModelClass.getMethods(), methodName);

			classAnalysis.addMethodAnalysis(analyseMethod(masterModelMethod, pullRequestModelMethod));
		}

		return classAnalysis;


	}

	public static FieldAnalysis analyseField(FieldModel masterModelField, FieldModel pullRequestModelField){
		String masterCommentText = masterModelField.getCommentText();
		String pullRequestCommentText = pullRequestModelField.getCommentText();

		FieldAnalysis fieldAnalysis;

		if(masterCommentText.equals(pullRequestCommentText)){
			fieldAnalysis = new UnchangedFieldAnalysis(masterModelField.getName(), masterCommentText);

		} else if(masterCommentText.equals("")){
			fieldAnalysis = new AddedFieldAnalysis(masterModelField.getName(), pullRequestCommentText);

		} else if(pullRequestCommentText.equals("")){
			fieldAnalysis = new RemovedFieldAnalysis(masterModelField.getName(), masterCommentText);

		} else {
			fieldAnalysis = new ChangedFieldAnalysis(masterModelField.getName(), masterCommentText, pullRequestCommentText);
		}


		return fieldAnalysis;
	}

	public static ConstructorAnalysis analyseConstructor(ConstructorModel masterModelConstructor, ConstructorModel pullRequestModelConstructor){
		String masterCommentText = masterModelConstructor.getCommentText();
		String pullRequestCommentText = pullRequestModelConstructor.getCommentText();

		ConstructorAnalysis constructorAnalysis;

		if(masterCommentText.equals(pullRequestCommentText)){
			constructorAnalysis = new UnchangedConstructorAnalysis(masterModelConstructor.getName(), masterCommentText);

		} else if(masterCommentText.equals("")){
			constructorAnalysis = new AddedConstructorAnalysis(masterModelConstructor.getName(), pullRequestCommentText);

		} else if(pullRequestCommentText.equals("")){
			constructorAnalysis = new RemovedConstructorAnalysis(masterModelConstructor.getName(), masterCommentText);

		} else {
			constructorAnalysis = new ChangedConstructorAnalysis(masterModelConstructor.getName(), masterCommentText, pullRequestCommentText);
		}
		
		List<String> existingParameterModelNames = ListHelper.retainAllParameters(masterModelConstructor.getParameters(), pullRequestModelConstructor.getParameters());


		for(String parameterName : existingParameterModelNames){
			ParameterModel masterModelParameter = ListHelper.getParameterModelByName(masterModelConstructor.getParameters(), parameterName);
			ParameterModel pullRequestModelParameter = ListHelper.getParameterModelByName(pullRequestModelConstructor.getParameters(), parameterName);

			constructorAnalysis.addParameterAnalysis(analyseParameter(masterModelParameter, pullRequestModelParameter));
		}

		return constructorAnalysis;
	}

	public static MethodAnalysis analyseMethod(MethodModel masterModelMethod, MethodModel pullRequestModelMethod){
		String masterCommentText = masterModelMethod.getCommentText();
		String pullRequestCommentText = pullRequestModelMethod.getCommentText();

		MethodAnalysis methodAnalysis;

		if(masterCommentText.equals(pullRequestCommentText)){
			methodAnalysis = new UnchangedMethodAnalysis(masterModelMethod.getName(), masterCommentText);

		} else if(masterCommentText.equals("")){
			methodAnalysis = new AddedMethodAnalysis(masterModelMethod.getName(), pullRequestCommentText);

		} else if(pullRequestCommentText.equals("")){
			methodAnalysis = new RemovedMethodAnalysis(masterModelMethod.getName(), masterCommentText);

		} else {
			methodAnalysis = new ChangedMethodAnalysis(masterModelMethod.getName(), masterCommentText, pullRequestCommentText);
		}
		
		List<String> existingParameterModelNames = ListHelper.retainAllParameters(masterModelMethod.getParameters(), pullRequestModelMethod.getParameters());


		for(String parameterName : existingParameterModelNames){
			ParameterModel masterModelParameter = ListHelper.getParameterModelByName(masterModelMethod.getParameters(), parameterName);
			ParameterModel pullRequestModelParameter = ListHelper.getParameterModelByName(pullRequestModelMethod.getParameters(), parameterName);

			methodAnalysis.addParameterAnalysis(analyseParameter(masterModelParameter, pullRequestModelParameter));
		}


		return methodAnalysis;
	}

	public static ParameterAnalysis analyseParameter(ParameterModel masterModelParameter, ParameterModel pullRequestModelParameter){
		String masterCommentText = masterModelParameter.getCommentText();
		String pullRequestCommentText = pullRequestModelParameter.getCommentText();

		ParameterAnalysis parameterAnalysis;

		if(masterCommentText.equals(pullRequestCommentText)){
			parameterAnalysis = new UnchangedParameterAnalysis(masterModelParameter.getName(), masterCommentText);

		} else if(masterCommentText.equals("")){
			parameterAnalysis = new AddedParameterAnalysis(masterModelParameter.getName(), pullRequestCommentText);

		} else if(pullRequestCommentText.equals("")){
			parameterAnalysis = new RemovedParameterAnalysis(masterModelParameter.getName(), masterCommentText);

		} else {
			parameterAnalysis = new ChangedParameterAnalysis(masterModelParameter.getName(), masterCommentText, pullRequestCommentText);
		}


		return parameterAnalysis;
	}



}
