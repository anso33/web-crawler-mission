package view;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import model.MovieRankInfo;


public class PdfExporterOfMovieRank extends AbstractPdfExporter implements IPdfExporter {

	public PdfExporterOfMovieRank() {
	}

	@Override
	public void exportPdf(String filename, List<MovieRankInfo> contents) {
		try (PdfWriter writer = new PdfWriter(new FileOutputStream(filename + ".pdf"))) {
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf, new PageSize(PageSize.A4));
			document.setFontSize(12);
			document.setFont(createFond("NanumGothic.ttf"));

			document.add(addFileTitle("영화 순위", 24));
			addTable(contents, document);

			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println(filename + ".pdf 파일이 생성되었습니다.");
		}
	}

	//	@Override
	//	public void addTable(List<MovieRankInfo> contents, Document document) {
	private void addTable(List<MovieRankInfo> contents, Document document) {
		Table table = new Table(UnitValue.createPercentArray(new float[]{1, 3, 2, 1, 1, 3}));
		table.setWidth(UnitValue.createPercentValue(100));
		table.setMarginTop(30);

		document.add(makeTableWithRankInfo(contents, table));
	}

	private Table makeTableWithRankInfo(List<MovieRankInfo> rankInfoList, Table table) {
		table.addHeaderCell(createCell("순위", true));
		table.addHeaderCell(createCell("제목", true));
		table.addHeaderCell(createCell("포스터", true));
		table.addHeaderCell(createCell("제한상영가", true));
		table.addHeaderCell(createCell("예매율", true));
		table.addHeaderCell(createCell("개봉일", true));

		for (MovieRankInfo rankInfo : rankInfoList) {
			table.addCell(createCell(rankInfo.getRank(), false));
			table.addCell(createCell(rankInfo.getTitle(), false));
			try {
				ImageData imageData = ImageDataFactory.create(rankInfo.getImg()); // AutoCloseable 구현 X
				Image image = new Image(imageData);
				image.setAutoScale(true);
				table.addCell(new Cell().add(image).setPadding(5));
			} catch (MalformedURLException e) {
				table.addCell(createCell("이미지 없음", false));
				e.printStackTrace();
			}
			table.addCell(createCell(rankInfo.getAge(), false));
			table.addCell(createCell(rankInfo.getReservationRate(), false));
			table.addCell(createCell(rankInfo.getOpenDate(), false));
		}
		return table;
	}
}
