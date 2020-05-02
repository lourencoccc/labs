package com.cloudec.hbcs;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-03-01
 */
public class HbcsFileUtils {

  public static boolean verifyIfExist(final String filePath) {
    return verifyIfExist(new File(filePath));
  }

  public static boolean verifyIfExist(final File file) {
    boolean exist = false;
    String fileName = "";
    try {
      if (file != null) {
        exist = file.exists();
        fileName = file.getName();
      }
    } catch (Exception e) {
      throw new HbcsException("erro_when_acess_file", e);
    }
    if (!exist) {
      throw new HbcsException("file_not_exist: " + fileName);
    }
    return exist;
  }

  public static File tempFile(String fileName) {
    return new File(System.getProperty("java.io.tmpdir") + File.separator + fileName);
  }

  public static String getFileName(String filePath) {
    return new File(filePath).getName();
  }

  public static List<File> listSubDirs(String datasetPathRoot) {
    File[] subDirs = new File(datasetPathRoot).listFiles((File dir, String name) -> {
      return dir.isDirectory();
    });
//    Arrays.stream(subDirs).map(File::getAbsolutePath).collect(Collectors.toList());
    return Arrays.asList(subDirs);
  }
}
