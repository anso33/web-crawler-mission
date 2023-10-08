package view;

import static com.itextpdf.kernel.font.PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import model.MovieRankInfo;

public class AbstractPdfExporter implements IPdfExporter {

	protected PdfFont createFond(String fontName) {
		PdfFont font = null;
		try {
			font = PdfFontFactory.createFont(fontName, PdfEncodings.IDENTITY_H, PREFER_EMBEDDED);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return font;
	}

	protected Paragraph addFileTitle(String title, int FontSize) {
		Paragraph titleParagraph = new Paragraph(title);
		titleParagraph.setFontSize(FontSize);
		titleParagraph.setTextAlignment(TextAlignment.CENTER);
		titleParagraph.setBold();
		return titleParagraph;
	}

	protected Cell createCell(String content, boolean isHeader) {
		Paragraph paragraph = new Paragraph(content);
		Cell cell = new Cell().add(paragraph);
		cell.setPadding(5);
		if (isHeader) {
			cell.setBackgroundColor(ColorConstants.LIGHT_GRAY);
			cell.setFontSize(14);
			cell.setBold();
		}
		return cell;
	}

	@Override
	public void exportPdf(String filename, List<MovieRankInfo> contents) throws FileNotFoundException {

	}

	//	@Override
	//	public void addTable(List<MovieRankInfo> contents, Document document) {
	//
	//	} -> private으로 쓸 메서드는 굳이 인터페이스에 넣지 않는 것이 좋은건가? 그렇지만 모든 메서드에서 해당 이름의 메서드를 구현할 것이긴 함.
}
