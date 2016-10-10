package fr.univlille1.m2iagl.bacquetdurey.git;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.TreeWalk;

public class GitChecker {

	Git git;
	
	public GitChecker(Git git){
		this.git = git;
	}

	public List<String> listSrcFilesFromRepository() throws IOException{

		List<String> filepaths = new ArrayList<String>();

		Repository repository = git.getRepository();
		
		Ref head = repository.findRef("master");
		RevWalk walk = new RevWalk(repository);

		RevCommit commit = walk.parseCommit(head.getObjectId());
		RevTree tree = commit.getTree();


		TreeWalk treeWalk = new TreeWalk(repository);
		treeWalk.addTree(tree);
		treeWalk.setRecursive(false);
		while (treeWalk.next()) {
			String pathName = treeWalk.getPathString();
			if(treeWalk.isSubtree()){
				treeWalk.enterSubtree();
			} else if (pathName.startsWith("src")) {
				filepaths.add(pathName);
			}

		}
		
		walk.close();
		treeWalk.close();
		
		
		return filepaths;

	}

}
