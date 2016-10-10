package fr.univlille1.m2iagl.bacquetdurey.main;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import fr.univlille1.m2iagl.bacquetdurey.analysis.AnalysisModel;
import fr.univlille1.m2iagl.bacquetdurey.analysis.JavadocAnalyser;
import fr.univlille1.m2iagl.bacquetdurey.controller.ResultWriter;
import fr.univlille1.m2iagl.bacquetdurey.doclet.DocletLauncher;
import fr.univlille1.m2iagl.bacquetdurey.model.Model;
import fr.univlille1.m2iagl.bacquetdurey.webhook.Config;


public class Start {

	private static String masterBranch = Config.TMP_DIR+Config.MASTER_BRANCH_DIR_NAME;

	private static String pullRequestBranch = Config.TMP_DIR+Config.PULL_REQUEST_DIR_NAME;

	public static void main(String [] args) throws Exception{

		List<String> packages = new ArrayList();
		packages.add("com.test");

		DocletLauncher docletLauncher = new DocletLauncher();

		docletLauncher.start(masterBranch, packages, Model.masterBranchModel);

		docletLauncher.start(pullRequestBranch, packages, Model.pullRequestBranchModel);

		JavadocAnalyser.analyse(Model.masterBranchModel, Model.pullRequestBranchModel, AnalysisModel.currentAnalysisModel);
		
		
		File file = new File("javadoc_analysis.txt");

		ResultWriter resultWriter = new ResultWriter(new PrintWriter(file), AnalysisModel.currentAnalysisModel);
		resultWriter.write();
/*
		File fileBis = new File("javadoc_analysis_bis.txt");

		ResultWriter resultWriterBis = new ResultWriter(new PrintWriter(fileBis), Model.pullRequestBranchModel);
		resultWriterBis.write();
		
		*/

		//	GitChecker gitChecker = new GitChecker(Git.open(new File(REMOTE_URL)));

		//	System.out.println(gitChecker.listSrcFilesFromRepository().toString());
	}
}
