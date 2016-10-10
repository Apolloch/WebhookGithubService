package fr.univlille1.m2iagl.bacquetdurey.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import fr.univlille1.m2iagl.bacquetdurey.analysis.AnalysisModel;
import fr.univlille1.m2iagl.bacquetdurey.analysis.JavadocAnalyser;
import fr.univlille1.m2iagl.bacquetdurey.controller.ResultWriter;
import fr.univlille1.m2iagl.bacquetdurey.doclet.DocletLauncher;
import fr.univlille1.m2iagl.bacquetdurey.model.Model;
import fr.univlille1.m2iagl.bacquetdurey.webhook.Config;


public class Start {

	//private static String masterBranch = Config.TMP_DIR+Config.MASTER_BRANCH_DIR_NAME+"/src";
	private static String masterBranch = Config.TMP_DIR+Config.MASTER_BRANCH_DIR_NAME + Config.SRC_DIR;

	//private static String pullRequestBranch = Config.TMP_DIR+Config.PULL_REQUEST_DIR_NAME+"/src";
	private static String pullRequestBranch = Config.TMP_DIR+Config.PULL_REQUEST_DIR_NAME + Config.SRC_DIR;

	public static void startAnalyse(String baseDir, String prDir) throws FileNotFoundException {
		// recuperer les packages de la branche master
	//	masterBranch = baseDir;
	//	pullRequestBranch = prDir;
		File folder = new File(masterBranch);

		System.out.println("folder : " + folder);
		if(!folder.exists()){
			throw new NoSuchElementException("");
		}

		File[] files = folder.listFiles();
		List<String> packageNamesMaster = new ArrayList<>();

		if(files.length == 0)
			throw new NoSuchElementException();

		for(File file : files){
			System.out.println("file : " + file.getName());
			packageNamesMaster.add(file.getName());
		}

		// recuperer les packages de la pull request
		File folderBis = new File(pullRequestBranch);

		System.out.println("folder b: " + folder);

		if(!folderBis.exists()){
			throw new NoSuchElementException("");
		}

		File[] filesBis = folderBis.listFiles();

		if(filesBis.length == 0)
			throw new NoSuchElementException();

		List<String> packageNamesPullRequest = new ArrayList<>();
		for(File file : filesBis){
			System.out.println("file : " + file.getName());

			packageNamesPullRequest.add(file.getName());
		}


		DocletLauncher docletLauncher = new DocletLauncher();

		docletLauncher.start(masterBranch, packageNamesMaster, Model.masterBranchModel);

		docletLauncher.start(pullRequestBranch, packageNamesPullRequest, Model.pullRequestBranchModel);

		JavadocAnalyser.analyse(Model.masterBranchModel, Model.pullRequestBranchModel, AnalysisModel.currentAnalysisModel);


		File file = new File(Config.RESULT_DIRECTORY+Config.RESULT_FILE_NAME);

		ResultWriter resultWriter = new ResultWriter(new PrintWriter(file), AnalysisModel.currentAnalysisModel);
		resultWriter.write();
	}

	public static void main(String [] args) throws Exception{
		startAnalyse(masterBranch,pullRequestBranch);


	}


}
