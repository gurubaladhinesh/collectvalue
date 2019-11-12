package com.imaginea.collectvalue.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Util {

	/**
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static String readFile(File file, Charset charset) throws IOException {
		return new String(Files.readAllBytes(file.toPath()), charset);
	}

	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String readFile(File file) throws IOException {
		return readFile(file, StandardCharsets.UTF_8);

	}

}
