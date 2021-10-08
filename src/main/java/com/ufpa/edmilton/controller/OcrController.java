package com.ufpa.edmilton.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ufpa.edmilton.model.Ocr;

import net.sourceforge.tess4j.TesseractException;

/**
 * Servlet implementation class OcrController
 */
@MultipartConfig
@WebServlet("/OcrController")
public class OcrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
//	@RequestMapping("/")
//	public String index() {
//		return "upload";
//	}
//	
//	@RequestMapping(value = "/upload", method = RequestMethod.POST)
//	public RedirectView singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) throws IOException, TesseractException{
//		byte[] bytes = file.getBytes();
//		Path path = Paths.get("C://Users//eq-note//eclipse-workspace//OCR//src//main//java//com//ufpa//edmilton//file//" + file.getOriginalFilename());
//		Files.write(path, bytes);
//		
//		File convFile = convert(file);
//		Tesseract tesseract = new Tesseract();
//		tesseract.setDatapath("C:/Program Files (x86)/Tesseract/tessdata");
//		String text = tesseract.doOCR((File) file);
//		redirectAttributes.addFlashAttribute("file", file);
//		redirectAttributes.addFlashAttribute("text", text);		
//		return new RedirectView("result");
//	}
//	
//	@RequestMapping("/result")
//	public String result() {
//		return "result";
//	}
//	
//	public static File convert(MultipartFile file) throws IOException {
//		
//		File convFile = new File(file.getOriginalFilename());
//		convFile.createNewFile();
//		FileOutputStream fos = new FileOutputStream(convFile);
//		fos.write(file.getBytes());
//		fos.close();		
//		return convFile;
//		
//	}
//	
    public OcrController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    			doPost(request, response);
    		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		Part part = request.getPart("fileUpload");
		//String fileName = part.getSubmittedFileName();
		//String path = getServletContext().getRealPath(fileName);
		//response.sendRedirect("result.jsp");
		//out.println(path);
		String name = /* UUID.randomUUID().toString() + */ /*"OCR.pdf"*/ part.getSubmittedFileName();
		String dirName = "C:/Users/eq-note/Documents/";
		part.write(dirName + name);
		String path = dirName + name;
		Ocr ocr = new Ocr();
		try {
			ocr.convert(path);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String extractedText = ocr.getFullText();
		//out.println(text);
		request.setAttribute("extractedText", extractedText);
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		}
	
	}