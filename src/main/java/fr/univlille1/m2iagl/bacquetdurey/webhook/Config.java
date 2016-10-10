package fr.univlille1.m2iagl.bacquetdurey.webhook;

/**
 * Created by Apolloch on 09/10/2016.
 */
public class Config {
    /**
     * the working dir.must absolutly finish with '/' if unix , '\' if windows
     */
    public static String TMP_DIR = "/home/m2iagl/bacquet/Documents/tmp/" ;
    public static String MASTER_BRANCH_DIR_NAME = "masterBranch/";
    public static String PULL_REQUEST_DIR_NAME = "pullRequestBranch/" ;
    public static String SRC_DIR = "src/";
    /**
     * the directory where the result file will belong.must absolutly finish with '/' if unix , '\' if windows
     */
    public static String RESULT_DIRECTORY= "/home/m2iagl/bacquet/Documents/tmp/" ;
    public static String RESULT_FILE_NAME = "javadoc_analysis.txt" ;

}
