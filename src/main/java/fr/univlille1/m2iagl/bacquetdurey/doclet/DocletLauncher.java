package fr.univlille1.m2iagl.bacquetdurey.doclet;

import java.util.List;

import fr.univlille1.m2iagl.bacquetdurey.model.Model;

public class DocletLauncher {


	private final static String JAR_PATH = "./lib/com-sun-javadoc.jar";
	private final static String DOCLET_SRC_FILE = "/src/main/java/fr/univlille1/m2iagl/bacquetdurey/doclet/GetJavadocDoclet.java";
	private final static String DOCLET_OPTION = "fr.univlille1.m2iagl.GetJavadocDoclet";
	
	private final static String DOCLET_PATH_OPTION = "bin";

	private String pathToCheck;
	private List<String> packages;
	
	public DocletLauncher(){
		
	}

	public boolean start(String pathToCheck, List<String> packages, Model model){
		Model.currentModel = model;
		this.packages = packages;
		this.pathToCheck = pathToCheck;
		if(!compile())
			return false;

		boolean execResult = execute();
		
		return execResult;
	}

	private boolean compile(){

		String command = "javac -classpath " + JAR_PATH + " " + DOCLET_SRC_FILE;
		
		Runtime runTime = Runtime.getRuntime();

		Process process = null;

		try {
			process = runTime.exec(command);
			process.waitFor();
		} catch(Exception e){
			return false;
		}

		return true;
	}

	private boolean execute(){
		
		String packageNames = "";
		
		for(int i=0;i<packages.size()-1;i++){
			packageNames += packages.get(i) + " ";
		}
		
		packageNames += packages.get(packages.size()-1);
		
		com.sun.tools.javadoc.Main.execute(new String[]{"-docletpath", DOCLET_PATH_OPTION, "-doclet", DOCLET_OPTION, "-sourcepath", pathToCheck, packageNames});
		
		return true;
	}
}
