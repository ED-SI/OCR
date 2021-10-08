package com.ufpa.edmilton.model;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Ocr {

	//private String fullText;
	
	/*
	 * public Ocr() { this.fullText = ""; }
	 */

	public static void main(String[] args) throws TesseractException {
		String inputFilePath = "D:/Downloads/ListaProva03Edmilton.pdf";

		Tesseract tesseract = new Tesseract();
		tesseract.setDatapath("C:/Program Files (x86)/Tesseract/tessdata");
		tesseract.setLanguage("POR");

		String fullText = tesseract.doOCR(new File(inputFilePath));
		// this.fullText = fullText;

		System.out.println(fullText);
	}

	/*
	 * public void convert(String path) throws TesseractException {
	 * 
	 * ITesseract tesseract = new Tesseract();
	 * tesseract.setDatapath("C:/Program Files (x86)/Tesseract/tessdata");
	 * tesseract.setLanguage("POR");
	 * 
	 * String fullText = tesseract.doOCR(new File(path)); this.fullText = fullText;
	 * 
	 * //System.out.println(fullText); }
	 * 
	 * public String getFullText() { return this.fullText; }
	 */

}
