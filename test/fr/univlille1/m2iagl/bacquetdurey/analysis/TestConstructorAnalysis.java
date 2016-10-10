package fr.univlille1.m2iagl.bacquetdurey.analysis;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.model.ConstructorModel;

public class TestConstructorAnalysis {
	
	@Test
	public void testSameConstructorWithNoCommentResultIsUnchanged(){
		ConstructorModel masterConstructorModel = SpecialFactory.createConstructorWithNoComment("A");
		ConstructorModel pullRequestConstructorModel = SpecialFactory.createConstructorWithNoComment("A");
		
		ConstructorAnalysis constructorAnalysis = JavadocAnalyser.analyseConstructor(masterConstructorModel, pullRequestConstructorModel);
	
		assertTrue(constructorAnalysis instanceof UnchangedConstructorAnalysis);
	
	}
	
	

	@Test
	public void testSameConstructorWithSameCommentResultIsUnchanged(){
		ConstructorModel masterConstructorModel = SpecialFactory.createConstructorWithSpecificComment("A", "toto");
		ConstructorModel pullRequestConstructorModel = SpecialFactory.createConstructorWithSpecificComment("A", "toto");
		
		ConstructorAnalysis constructorAnalysis = JavadocAnalyser.analyseConstructor(masterConstructorModel, pullRequestConstructorModel);
	
		assertTrue(constructorAnalysis instanceof UnchangedConstructorAnalysis);
	
	}
	
	@Test
	public void testConstructorWithDifferentCommentResultIsChanged(){
		ConstructorModel masterConstructorModel = SpecialFactory.createConstructorWithSpecificComment("A", "toto");
		ConstructorModel pullRequestConstructorModel = SpecialFactory.createConstructorWithSpecificComment("A", "tata");
		
		ConstructorAnalysis constructorAnalysis = JavadocAnalyser.analyseConstructor(masterConstructorModel, pullRequestConstructorModel);
	
		assertTrue(constructorAnalysis instanceof ChangedConstructorAnalysis);
	
	}
	
	@Test
	public void testConstructorWithMasterNoCommentPullRequestCommentExistResultIsAdded(){
		ConstructorModel masterConstructorModel = SpecialFactory.createConstructorWithNoComment("A");
		ConstructorModel pullRequestConstructorModel = SpecialFactory.createConstructorWithSpecificComment("A", "tata");
		
		ConstructorAnalysis constructorAnalysis = JavadocAnalyser.analyseConstructor(masterConstructorModel, pullRequestConstructorModel);
	
		assertTrue(constructorAnalysis instanceof AddedConstructorAnalysis);
	
	}
	
	@Test
	public void testConstructorWithMasterCommentExistPullRequestNOCommentResultIsRemoved(){
		ConstructorModel masterConstructorModel = SpecialFactory.createConstructorWithSpecificComment("A", "tata");
		ConstructorModel pullRequestConstructorModel = SpecialFactory.createConstructorWithNoComment("A");
		
		ConstructorAnalysis constructorAnalysis = JavadocAnalyser.analyseConstructor(masterConstructorModel, pullRequestConstructorModel);
	
		assertTrue(constructorAnalysis instanceof RemovedConstructorAnalysis);
	
	}

}
