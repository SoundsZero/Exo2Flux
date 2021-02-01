package Exo1;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Exo1Flux {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrez le pathName du repertoire:");
		String pathName = sc.nextLine();
		testFile(pathName);
	



	}

	private static void getInfosFile(File file) {
		System.out.println("=================================");
		if (file.isDirectory()) {
			System.out.println(file.getName() + " REPERTOIRE");
		} else {
			System.out.println(file.getName() + " Fichier");
			System.out.println("Otets:" + file.length());
		}

		long lastModifyMillis = file.lastModified();
		Date lastModifyDate = new Date(lastModifyMillis);
		System.out.println("Last modify date :" + lastModifyDate);
	}

	private static void testFile(String pathName) {
		
		File file = new File(pathName);
		File[] children = file.listFiles();
		System.out.println("Path exist ? " + file.exists());
		if (file.exists()) {
			System.out.println("Absolute Path :" + file.getAbsolutePath());
			getInfosFile(file);
			
			for (File f : children) {
				if (f.isDirectory()) {
					System.out.println(f.getName());
					getInfosFile(f);
					testFile(f.getAbsolutePath());
				} else {
					if(getFileExtension(f).equals("java")){
					System.out.println("*****************"+getFileExtension(f));
					getInfosFile(f);
					}
				}
			}
		} else {
			System.out.println("(inexistant ou non repertoire)");

		}
	}
	private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
