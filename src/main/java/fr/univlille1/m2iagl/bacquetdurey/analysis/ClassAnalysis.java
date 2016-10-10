package fr.univlille1.m2iagl.bacquetdurey.analysis;

import java.util.ArrayList;
import java.util.List;

import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.added.AddedMethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.changed.ChangedMethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.removed.RemovedMethodAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedConstructorAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedFieldAnalysis;
import fr.univlille1.m2iagl.bacquetdurey.analysis.unchanged.UnchangedMethodAnalysis;

public abstract class ClassAnalysis extends Analysis{

	protected String className;
	
	protected List<AddedFieldAnalysis> addedFieldsAnalysis;
	
	protected List<ChangedFieldAnalysis> changedFieldsAnalysis;

	protected List<RemovedFieldAnalysis> removedFieldsAnalysis;
	
	protected List<UnchangedFieldAnalysis> unchangedFieldsAnalysis;
	
	protected List<AddedConstructorAnalysis> addedConstructorsAnalysis;
	
	protected List<ChangedConstructorAnalysis> changedConstructorsAnalysis;
	
	protected List<RemovedConstructorAnalysis> removedConstructorsAnalysis;
	
	protected List<UnchangedConstructorAnalysis> unchangedConstructorsAnalysis;
	
	protected List<AddedMethodAnalysis> addedMethodsAnalysis;
	
	protected List<ChangedMethodAnalysis> changedMethodsAnalysis;

	protected List<RemovedMethodAnalysis> removedMethodsAnalysis;

	protected List<UnchangedMethodAnalysis> unchangedMethodsAnalysis;
	
	protected String commentText;
	
	public ClassAnalysis(String className, String commentText){
		this.className = className;
		this.commentText = commentText;
		
		addedFieldsAnalysis = new ArrayList<>();
		changedFieldsAnalysis = new ArrayList<>();
		removedFieldsAnalysis = new ArrayList<>();
		unchangedFieldsAnalysis = new ArrayList<>();
		addedConstructorsAnalysis = new ArrayList<>();
		changedConstructorsAnalysis = new ArrayList<>();
		removedConstructorsAnalysis = new ArrayList<>();
		unchangedConstructorsAnalysis = new ArrayList<>();
		addedMethodsAnalysis = new ArrayList<>();
		changedMethodsAnalysis = new ArrayList<>();
		removedMethodsAnalysis = new ArrayList<>();
		unchangedMethodsAnalysis = new ArrayList<>();

		
	}
	
	public String getClassName(){
		return className;
	}
	
	public void addFieldAnalysis(FieldAnalysis fieldAnalysis){
		if(fieldAnalysis instanceof AddedFieldAnalysis){
			addedFieldsAnalysis.add((AddedFieldAnalysis) fieldAnalysis);
			
		} else if(fieldAnalysis instanceof ChangedFieldAnalysis){
			changedFieldsAnalysis.add((ChangedFieldAnalysis) fieldAnalysis);
			
		} else if(fieldAnalysis instanceof RemovedFieldAnalysis){
			removedFieldsAnalysis.add((RemovedFieldAnalysis) fieldAnalysis);
			
		} else {
			unchangedFieldsAnalysis.add((UnchangedFieldAnalysis) fieldAnalysis);
			
		}
	}
	
	public void addConstructorAnalysis(ConstructorAnalysis constructorAnalysis){
		if(constructorAnalysis instanceof AddedConstructorAnalysis){
			addedConstructorsAnalysis.add((AddedConstructorAnalysis) constructorAnalysis);
			
		} else if(constructorAnalysis instanceof ChangedConstructorAnalysis){
			changedConstructorsAnalysis.add((ChangedConstructorAnalysis) constructorAnalysis);
			
		} else if(constructorAnalysis instanceof RemovedConstructorAnalysis){
			removedConstructorsAnalysis.add((RemovedConstructorAnalysis) constructorAnalysis);
			
		} else {
			unchangedConstructorsAnalysis.add((UnchangedConstructorAnalysis) constructorAnalysis);
			
		}
	}
	
	public void addMethodAnalysis(MethodAnalysis methodAnalysis){
		if(methodAnalysis instanceof AddedMethodAnalysis){
			addedMethodsAnalysis.add((AddedMethodAnalysis) methodAnalysis);
			
		} else if(methodAnalysis instanceof ChangedMethodAnalysis){
			changedMethodsAnalysis.add((ChangedMethodAnalysis) methodAnalysis);
			
		} else if(methodAnalysis instanceof RemovedMethodAnalysis){
			removedMethodsAnalysis.add((RemovedMethodAnalysis) methodAnalysis);
			
		} else {
			unchangedMethodsAnalysis.add((UnchangedMethodAnalysis) methodAnalysis);
			
		}
	}
	
	public List<FieldAnalysis> getFieldsAnalysis(){
		List<FieldAnalysis> fieldsAnalysis = new ArrayList<FieldAnalysis>(changedFieldsAnalysis);
		fieldsAnalysis.addAll(addedFieldsAnalysis);
		fieldsAnalysis.addAll(removedFieldsAnalysis);
		fieldsAnalysis.addAll(unchangedFieldsAnalysis);

		return fieldsAnalysis;
	}
	
	public List<ConstructorAnalysis> getConstructorsAnalysis(){
		List<ConstructorAnalysis> constructorsAnalysis = new ArrayList<ConstructorAnalysis>(changedConstructorsAnalysis);
		constructorsAnalysis.addAll(addedConstructorsAnalysis);
		constructorsAnalysis.addAll(removedConstructorsAnalysis);
		constructorsAnalysis.addAll(unchangedConstructorsAnalysis);

		return constructorsAnalysis;
	}
	
	public List<MethodAnalysis> getMethodsAnalysis(){
		List<MethodAnalysis> methodsAnalysis = new ArrayList<MethodAnalysis>(changedMethodsAnalysis);
		methodsAnalysis.addAll(addedMethodsAnalysis);
		methodsAnalysis.addAll(removedMethodsAnalysis);
		methodsAnalysis.addAll(unchangedMethodsAnalysis);

		return methodsAnalysis;
	}
	
	

}
