package samplepkg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vasudev.tyagi
 *
 */
public class FileCreation {

	static String basepath = "E:\\AgJunction\\CodeCommit\\agj_artical";
	static String authorName = "vasudev.tyagi";
	static String serviceName = "artical";
	static String serviceNameStartwithCapital = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		if (args != null && args.length > 0) {
			authorName = args[0];
			serviceName = args[1];
		}
		serviceNameStartwithCapital = serviceName.substring(0, 1).toUpperCase() + serviceName.substring(1);
		if (basepath == null) {
			System.out.println("please Enter base path");
		}
		if (authorName == null) {
			System.out.println("please Enter Author Name");
		}

		System.out.println("Path = " + basepath);
		System.out.println("Author = " + authorName);
		System.out.println("Service Name = " + serviceName);

		File[] files = new File(basepath).listFiles();
		renameFolder(files);
		files = new File(basepath).listFiles();
		updateFiles(files);
	}

	public static void renameFolder(File[] files) {
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.println("Directory: " + file.getName());
				if (file.getName().contains("framework")) {
					File newDir = new File((file.getParent() + "/" + file.getName().replace("framework", serviceName)));
					file.renameTo(newDir);
					renameFolder(newDir.listFiles());
				} else {
					renameFolder(file.listFiles()); // Calls same method again.
				}
			}
		}
	}

	public static void updateFiles(File[] files) {
		for (File file : files) {
			if (file.isDirectory()) {
				// System.out.println("Directory: " + file.getName());
				updateFiles(file.listFiles()); // Calls same method again.
			} else {
				copy(file);
				// System.out.println("File: " + file.getName());
			}
		}
	}

	// Copies src file to dst file.
	// If the dst file does not exist, it is created
	static void copy(File src) {
		try {

			System.out.println("src file name ::" + src.getName());
			if (src.getName().contains("Framework")) {
				File newFile = new File(
						(src.getParent() + "/" + src.getName().replace("Framework", serviceNameStartwithCapital)));
				createFile(src, newFile);
				src.delete();
				System.out.println(newFile.getName() + " created successfuly");
			} else {
				updateFile(src);
				System.out.println(src.getName() + " updated successfuly");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createFile(File src, File newFile) throws FileNotFoundException, IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(newFile));
		BufferedReader reader = new BufferedReader(new FileReader(src));
		String line = null;
		String ls = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			if (line.indexOf("<AUTHOR>") != -1) {
				line = line.replaceAll("<AUTHOR>", authorName);
			} else if (line.indexOf("<framework>") != -1) {
				line = line.replaceAll("<framework>", serviceName);
			}
			if (line.indexOf("<Framework>") != -1) {
				line = line.replaceAll("<Framework>", serviceNameStartwithCapital);
			}
			out.write(line);
			out.write(ls);
		}
		out.close();
		reader.close();
	}

	public static void updateFile(File file) {
		List<String> lines = new ArrayList<>();
		String line = null;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				if (line.indexOf("<AUTHOR>") != -1) {
					line = line.replaceAll("<AUTHOR>", authorName);
				} else if (line.indexOf("<framework>") != -1) {
					line = line.replaceAll("<framework>", serviceName);
				}
				if (line.indexOf("<Framework>") != -1) {
					line = line.replaceAll("<Framework>", serviceNameStartwithCapital);
				}
				lines.add(line);
				lines.add(System.getProperty("line.separator"));
			}
			fr.close();
			br.close();

			FileWriter fw = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fw);
			for (String s : lines)
				out.write(s);
			out.flush();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}