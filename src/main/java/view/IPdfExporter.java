package view;

import java.io.FileNotFoundException;
import java.util.List;
import model.MovieRankInfo;

//public interface IPdfExporter {
//
//	//	void exportPdf(String filename, List<MovieRankInfo> contents) throws FileNotFoundException {
//	//		PdfWriter writer = null;
//	//		try {
//	//			writer = new PdfWriter(new FileOutputStream(filename + ".pdf"));
//	//		} catch (FileNotFoundException e) {
//	//			e.printStackTrace();
//	//		}
//	//		PdfDocument pdf = new PdfDocument(writer);
//	//		Document document = new Document(pdf, new PageSize(PageSize.A4));
//	//		document.setFontSize(12);
//	//		document.setFont(createFond("NanumGothic.ttf"));
//	//
//	//		document.add(addFileTitle("영화 순위", 24));
//	//		addTable(contents, document);
//	//
//	//		document.close();
//	//		System.out.println(filename + ".pdf 파일이 생성되었습니다.");
//	//	}
//	void exportPdf(String filename, List<MovieRankInfo> contents) throws FileNotFoundException;
//
//	default PdfFont createFond(String fontName) {
//		PdfFont font = null;
//		try {
//			font = PdfFontFactory.createFont(fontName, PdfEncodings.IDENTITY_H, PREFER_EMBEDDED);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		return font;
//	}
//
//	default Paragraph addFileTitle(String title, int FontSize) {
//		Paragraph titleParagraph = new Paragraph(title);
//		titleParagraph.setFontSize(FontSize);
//		titleParagraph.setTextAlignment(TextAlignment.CENTER);
//		titleParagraph.setBold();
//		return titleParagraph;
//	}
//
//	void addTable(List<MovieRankInfo> contents, Document document);
//
//	default Cell createCell(String content, boolean isHeader) {
//		Paragraph paragraph = new Paragraph(content);
//		Cell cell = new Cell().add(paragraph);
//		cell.setPadding(5);
//		if (isHeader) {
//			cell.setBackgroundColor(ColorConstants.LIGHT_GRAY);
//			cell.setFontSize(14);
//			cell.setBold();
//		}
//		return cell;
//	}
//}

// TODO: 골격구현 클래스로 만드는 기준
public interface IPdfExporter {

	//	void exportPdf(String filename, List<MovieRankInfo> contents) throws FileNotFoundException {
	//		PdfWriter writer = null;
	//		try {
	//			writer = new PdfWriter(new FileOutputStream(filename + ".pdf"));
	//		} catch (FileNotFoundException e) {
	//			e.printStackTrace();
	//		}
	//		PdfDocument pdf = new PdfDocument(writer);
	//		Document document = new Document(pdf, new PageSize(PageSize.A4));
	//		document.setFontSize(12);
	//		document.setFont(createFond("NanumGothic.ttf"));
	//
	//		document.add(addFileTitle("영화 순위", 24));
	//		addTable(contents, document);
	//
	//		document.close();
	//		System.out.println(filename + ".pdf 파일이 생성되었습니다.");
	//	}
	void exportPdf(String filename, List<MovieRankInfo> contents) throws FileNotFoundException;

	//	void addTable(List<MovieRankInfo> contents, Document document);


}
