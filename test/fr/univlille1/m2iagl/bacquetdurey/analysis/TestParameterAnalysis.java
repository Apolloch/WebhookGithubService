package fr.univlille1.m2iagl.bacquetdurey.analysis;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedParameterAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedParameterAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedParameterAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedParameterAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.model.ParameterModel;

public class TestParameterAnalysis {

	@Test
	public void testSameParameterWithNoCommentResultIsUnchanged(){
		ParameterModel masterParameterModel = SpecialFactory.createParameterWithNoComment("A");
		ParameterModel pullRequestParameterModel = SpecialFactory.createParameterWithNoComment("A");
		
		ParameterAnalysis parameterAnalysis = JavadocAnalyser.analyseParameter(masterParameterModel, pullRequestParameterModel);
	
		assertTrue(parameterAnalysis instanceof UnchangedParameterAnalysis);
	
	}
	
	

	@Test
	public void testSameParameterWithSameCommentResultIsUnchanged(){
		ParameterModel masterParameterModel = SpecialFactory.createParameterWithSpecificComment("A", "toto");
		ParameterModel pullRequestParameterModel = SpecialFactory.createParameterWithSpecificComment("A", "toto");
		
		ParameterAnalysis parameterAnalysis = JavadocAnalyser.analyseParameter(masterParameterModel, pullRequestParameterModel);
	
		assertTrue(parameterAnalysis instanceof UnchangedParameterAnalysis);
	
	}
	
	@Test
	public void testParameterWithDifferentCommentResultIsChanged(){
		ParameterModel masterParameterModel = SpecialFactory.createParameterWithSpecificComment("A", "toto");
		ParameterModel pullRequestParameterModel = SpecialFactory.createParameterWithSpecificComment("A", "tata");
		
		ParameterAnalysis parameterAnalysis = JavadocAnalyser.analyseParameter(masterParameterModel, pullRequestParameterModel);
	
		assertTrue(parameterAnalysis instanceof ChangedParameterAnalysis);
	
	}
	
	@Test
	public void testParameterWithMasterNoCommentPullRequestCommentExistResultIsAdded(){
		ParameterModel masterParameterModel = SpecialFactory.createParameterWithNoComment("A");
		ParameterModel pullRequestParameterModel = SpecialFactory.createParameterWithSpecificComment("A", "tata");
		
		ParameterAnalysis parameterAnalysis = JavadocAnalyser.analyseParameter(masterParameterModel, pullRequestParameterModel);
	
		assertTrue(parameterAnalysis instanceof AddedParameterAnalysis);
	
	}
	
	@Test
	public void testParameterWithMasterCommentExistPullRequestNoCommentResultIsRemoved(){
		ParameterModel masterParameterModel = SpecialFactory.createParameterWithSpecificComment("A", "tata");
		ParameterModel pullRequestParameterModel = SpecialFactory.createParameterWithNoComment("A");
		
		ParameterAnalysis parameterAnalysis = JavadocAnalyser.analyseParameter(masterParameterModel, pullRequestParameterModel);
	
		assertTrue(parameterAnalysis instanceof RemovedParameterAnalysis);
	
	}
}
