package fr.univlille1.m2iagl.bacquetdurey.analysis;


import org.junit.Test;

import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedClassAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.model.ClassModel;

import static junit.framework.Assert.assertTrue;

public class TestClassAnalysis {
	
	@Test
	public void testSameClassWithNoCommentResultIsUnchanged(){
		ClassModel masterClassModel = SpecialFactory.createClassWithNoComment("A");
		ClassModel pullRequestClassModel = SpecialFactory.createClassWithNoComment("A");
		
		ClassAnalysis classAnalysis = JavadocAnalyser.analyseClass(masterClassModel, pullRequestClassModel);
	
		assertTrue(classAnalysis instanceof UnchangedClassAnalysis);
	
	}
	
	

	@Test
	public void testSameClassWithSameCommentResultIsUnchanged(){
		ClassModel masterClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		ClassModel pullRequestClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		
		ClassAnalysis classAnalysis = JavadocAnalyser.analyseClass(masterClassModel, pullRequestClassModel);
	
		assertTrue(classAnalysis instanceof UnchangedClassAnalysis);
	
	}
	
	@Test
	public void testClassWithDifferentCommentResultIsChanged(){
		ClassModel masterClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		ClassModel pullRequestClassModel = SpecialFactory.createClassWithSpecificComment("A", "tata");
		
		ClassAnalysis classAnalysis = JavadocAnalyser.analyseClass(masterClassModel, pullRequestClassModel);
	
		assertTrue(classAnalysis instanceof ChangedClassAnalysis);
	
	}
	
	@Test
	public void testClassWithMasterNoCommentPullRequestCommentExistResultIsAdded(){
		ClassModel masterClassModel = SpecialFactory.createClassWithNoComment("A");
		ClassModel pullRequestClassModel = SpecialFactory.createClassWithSpecificComment("A", "tata");
		
		ClassAnalysis classAnalysis = JavadocAnalyser.analyseClass(masterClassModel, pullRequestClassModel);
	
		assertTrue(classAnalysis instanceof AddedClassAnalysis);
	
	}
	
	@Test
	public void testClassWithMasterCommentExistPullRequestNOCommentResultIsRemoved(){
		ClassModel masterClassModel = SpecialFactory.createClassWithSpecificComment("A", "tata");
		ClassModel pullRequestClassModel = SpecialFactory.createClassWithNoComment("A");
		
		ClassAnalysis classAnalysis = JavadocAnalyser.analyseClass(masterClassModel, pullRequestClassModel);
	
		assertTrue(classAnalysis instanceof RemovedClassAnalysis);
	
	}
	
	@Test
	public void testSameClassWithSameCommentSameFieldResultIsUnchanged(){
		ClassModel masterClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		ClassModel pullRequestClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		
		masterClassModel.addFieldModel(SpecialFactory.createFieldWithSpecificComment("B", "toto"));
		pullRequestClassModel.addFieldModel(SpecialFactory.createFieldWithSpecificComment("B", "toto"));

		
		ClassAnalysis classAnalysis = JavadocAnalyser.analyseClass(masterClassModel, pullRequestClassModel);
	
		assertTrue(classAnalysis instanceof UnchangedClassAnalysis);
	
	}
	
	@Test
	public void testSameClassWithSameCommentFieldDifferentResultIsUnchanged(){
		ClassModel masterClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		ClassModel pullRequestClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		
		masterClassModel.addFieldModel(SpecialFactory.createFieldWithSpecificComment("B", "toto"));
		pullRequestClassModel.addFieldModel(SpecialFactory.createFieldWithSpecificComment("B", "tata"));

		
		ClassAnalysis classAnalysis = JavadocAnalyser.analyseClass(masterClassModel, pullRequestClassModel);
	
		assertTrue(classAnalysis instanceof UnchangedClassAnalysis);
	
	}
	
	@Test
	public void testSameClassWithSameCommentSameConstructorResultIsUnchanged(){
		ClassModel masterClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		ClassModel pullRequestClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		
		masterClassModel.addConstructorModel(SpecialFactory.createConstructorWithSpecificComment("B", "toto"));
		pullRequestClassModel.addConstructorModel(SpecialFactory.createConstructorWithSpecificComment("B", "toto"));

		
		ClassAnalysis classAnalysis = JavadocAnalyser.analyseClass(masterClassModel, pullRequestClassModel);
	
		assertTrue(classAnalysis instanceof UnchangedClassAnalysis);
	
	}
	
	@Test
	public void testSameClassWithSameCommentConstructorDifferentResultIsUnchanged(){
		ClassModel masterClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		ClassModel pullRequestClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		
		masterClassModel.addConstructorModel(SpecialFactory.createConstructorWithSpecificComment("B", "toto"));
		pullRequestClassModel.addConstructorModel(SpecialFactory.createConstructorWithSpecificComment("B", "tata"));

		
		ClassAnalysis classAnalysis = JavadocAnalyser.analyseClass(masterClassModel, pullRequestClassModel);
	
		assertTrue(classAnalysis instanceof UnchangedClassAnalysis);
	
	}
	
	@Test
	public void testSameClassWithSameCommentSameMethodResultIsUnchanged(){
		ClassModel masterClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		ClassModel pullRequestClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		
		masterClassModel.addMethodModel(SpecialFactory.createMethodWithSpecificComment("B", "toto"));
		pullRequestClassModel.addMethodModel(SpecialFactory.createMethodWithSpecificComment("B", "toto"));

		
		ClassAnalysis classAnalysis = JavadocAnalyser.analyseClass(masterClassModel, pullRequestClassModel);
	
		assertTrue(classAnalysis instanceof UnchangedClassAnalysis);
	
	}
	
	@Test
	public void testSameClassWithSameCommentMethodDifferentResultIsUnchanged(){
		ClassModel masterClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		ClassModel pullRequestClassModel = SpecialFactory.createClassWithSpecificComment("A", "toto");
		
		masterClassModel.addMethodModel(SpecialFactory.createMethodWithSpecificComment("B", "toto"));
		pullRequestClassModel.addMethodModel(SpecialFactory.createMethodWithSpecificComment("B", "tata"));

		
		ClassAnalysis classAnalysis = JavadocAnalyser.analyseClass(masterClassModel, pullRequestClassModel);
	
		assertTrue(classAnalysis instanceof UnchangedClassAnalysis);
	
	}
	
	

}
