package fr.univlille1.m2iagl.bacquetdurey.analysis;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.model.FieldModel;

public class TestFieldAnalysis {

	@Test
	public void testSameFieldWithNoCommentResultIsUnchanged(){
		FieldModel masterFieldModel = SpecialFactory.createFieldWithNoComment("A");
		FieldModel pullRequestFieldModel = SpecialFactory.createFieldWithNoComment("A");
		
		FieldAnalysis fieldAnalysis = JavadocAnalyser.analyseField(masterFieldModel, pullRequestFieldModel);
	
		assertTrue(fieldAnalysis instanceof UnchangedFieldAnalysis);
	
	}
	
	

	@Test
	public void testSameFieldWithSameCommentResultIsUnchanged(){
		FieldModel masterFieldModel = SpecialFactory.createFieldWithSpecificComment("A", "toto");
		FieldModel pullRequestFieldModel = SpecialFactory.createFieldWithSpecificComment("A", "toto");
		
		FieldAnalysis fieldAnalysis = JavadocAnalyser.analyseField(masterFieldModel, pullRequestFieldModel);
	
		assertTrue(fieldAnalysis instanceof UnchangedFieldAnalysis);
	
	}
	
	@Test
	public void testFieldWithDifferentCommentResultIsChanged(){
		FieldModel masterFieldModel = SpecialFactory.createFieldWithSpecificComment("A", "toto");
		FieldModel pullRequestFieldModel = SpecialFactory.createFieldWithSpecificComment("A", "tata");
		
		FieldAnalysis fieldAnalysis = JavadocAnalyser.analyseField(masterFieldModel, pullRequestFieldModel);
	
		assertTrue(fieldAnalysis instanceof ChangedFieldAnalysis);
	
	}
	
	@Test
	public void testFieldWithMasterNoCommentPullRequestCommentExistResultIsAdded(){
		FieldModel masterFieldModel = SpecialFactory.createFieldWithNoComment("A");
		FieldModel pullRequestFieldModel = SpecialFactory.createFieldWithSpecificComment("A", "tata");
		
		FieldAnalysis fieldAnalysis = JavadocAnalyser.analyseField(masterFieldModel, pullRequestFieldModel);
	
		assertTrue(fieldAnalysis instanceof AddedFieldAnalysis);
	
	}
	
	@Test
	public void testFieldWithMasterCommentExistPullRequestNoCommentResultIsRemoved(){
		FieldModel masterFieldModel = SpecialFactory.createFieldWithSpecificComment("A", "tata");
		FieldModel pullRequestFieldModel = SpecialFactory.createFieldWithNoComment("A");
		
		FieldAnalysis fieldAnalysis = JavadocAnalyser.analyseField(masterFieldModel, pullRequestFieldModel);
	
		assertTrue(fieldAnalysis instanceof RemovedFieldAnalysis);
	
	}
}
