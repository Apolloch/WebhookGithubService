package fr.univlille1.m2iagl.bacquetdurey.analysis;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedMethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedMethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedMethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedMethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.model.MethodModel;

public class TestMethodAnalysis {

	@Test
	public void testSameMethodWithNoCommentResultIsUnchanged(){
		MethodModel masterMethodModel = SpecialFactory.createMethodWithNoComment("A");
		MethodModel pullRequestMethodModel = SpecialFactory.createMethodWithNoComment("A");
		
		MethodAnalysis methodAnalysis = JavadocAnalyser.analyseMethod(masterMethodModel, pullRequestMethodModel);
	
		assertTrue(methodAnalysis instanceof UnchangedMethodAnalysis);
	
	}
	
	

	@Test
	public void testSameMethodWithSameCommentResultIsUnchanged(){
		MethodModel masterMethodModel = SpecialFactory.createMethodWithSpecificComment("A", "toto");
		MethodModel pullRequestMethodModel = SpecialFactory.createMethodWithSpecificComment("A", "toto");
		
		MethodAnalysis methodAnalysis = JavadocAnalyser.analyseMethod(masterMethodModel, pullRequestMethodModel);
	
		assertTrue(methodAnalysis instanceof UnchangedMethodAnalysis);
	
	}
	
	@Test
	public void testMethodWithDifferentCommentResultIsChanged(){
		MethodModel masterMethodModel = SpecialFactory.createMethodWithSpecificComment("A", "toto");
		MethodModel pullRequestMethodModel = SpecialFactory.createMethodWithSpecificComment("A", "tata");
		
		MethodAnalysis methodAnalysis = JavadocAnalyser.analyseMethod(masterMethodModel, pullRequestMethodModel);
	
		assertTrue(methodAnalysis instanceof ChangedMethodAnalysis);
	
	}
	
	@Test
	public void testMethodWithMasterNoCommentPullRequestCommentExistResultIsAdded(){
		MethodModel masterMethodModel = SpecialFactory.createMethodWithNoComment("A");
		MethodModel pullRequestMethodModel = SpecialFactory.createMethodWithSpecificComment("A", "tata");
		
		MethodAnalysis methodAnalysis = JavadocAnalyser.analyseMethod(masterMethodModel, pullRequestMethodModel);
	
		assertTrue(methodAnalysis instanceof AddedMethodAnalysis);
	
	}
	
	@Test
	public void testMethodWithMasterCommentExistPullRequestNoCommentResultIsRemoved(){
		MethodModel masterMethodModel = SpecialFactory.createMethodWithSpecificComment("A", "tata");
		MethodModel pullRequestMethodModel = SpecialFactory.createMethodWithNoComment("A");
		
		MethodAnalysis methodAnalysis = JavadocAnalyser.analyseMethod(masterMethodModel, pullRequestMethodModel);
	
		assertTrue(methodAnalysis instanceof RemovedMethodAnalysis);
	
	}
}
