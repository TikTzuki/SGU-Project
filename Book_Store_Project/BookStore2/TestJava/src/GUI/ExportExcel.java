package GUI;

import BUS.Book_BUS;
import DTO.Book_DTO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExportExcel {
/*
	public static void main(String[] args) {
		
		ExportExcel excelWriter = new ExportExcel();
		 
		List<Book_DTO> listBook = (List<Book_DTO>) excelWriter.getListBook();
		String excelFilePath = "E:/export/sanpham.xls";
		 
		try {
			excelWriter.writeExcel(listBook, excelFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	private Workbook getWorkbook(String excelFilePath)
	        throws IOException {
	    Workbook workbook = null;
	 
	    if (excelFilePath.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook();
	    } else if (excelFilePath.endsWith("xls")) {
	        workbook = new HSSFWorkbook();
	    } else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
	 
	    return workbook;
	}
	
	public void writeExcel(List<Book_DTO> listBook, String excelFilePath) throws IOException {
	    Workbook workbook = getWorkbook(excelFilePath);
	    Sheet sheet = workbook.createSheet();
	    createHeaderRow(sheet);
	    int rowCount = 0;
	 
	    for (Book_DTO aBook : listBook) {
	        Row row = sheet.createRow(++rowCount);
	        writeBook(aBook, row);
	    }
	 
	    try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
	        workbook.write(outputStream);
	    }
	}
	
	private void writeBook(Book_DTO aBook, Row row) {
	    Cell cell = row.createCell(1);
	    cell.setCellValue(aBook.book_id);
	 
	    cell = row.createCell(2);
	    cell.setCellValue(aBook.title);
	 
	    cell = row.createCell(3);
	    cell.setCellValue(aBook.availabel_quantity);
            
            cell = row.createCell(4);
	    cell.setCellValue(aBook.price);
            
            cell = row.createCell(5);
	    cell.setCellValue(aBook.genre_name);
            
            cell = row.createCell(6);
	    cell.setCellValue(aBook.publication_date);
            
            cell = row.createCell(7);
	    cell.setCellValue(aBook.author_firstname+" "+aBook.author_lastname);
            
            cell = row.createCell(8);
	    cell.setCellValue(aBook.file_anh);
	}
	
    //Có thể format được như in đậm, set font
	private void createHeaderRow(Sheet sheet) {
	 
	    CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
	    Font font = sheet.getWorkbook().createFont();
	    font.setBold(true);
	    font.setFontHeightInPoints((short) 16);
	    cellStyle.setFont(font);
	 
	    Row row = sheet.createRow(0);
            
	    Cell cellMa = row.createCell(1);
	    cellMa.setCellStyle(cellStyle);
	    cellMa.setCellValue("Mã sản phẩm");
	 
	    Cell cellTen = row.createCell(2);
	    cellTen.setCellStyle(cellStyle);
	    cellTen.setCellValue("Tên sản phẩm");
	 
	    Cell cellSL = row.createCell(3);
	    cellSL.setCellStyle(cellStyle);
	    cellSL.setCellValue("Số lượng");
            
            Cell cellGia = row.createCell(4);
	    cellGia.setCellStyle(cellStyle);
	    cellGia.setCellValue("Đơn giá(VNĐ)");
            
            Cell cellTL = row.createCell(5);
	    cellTL.setCellStyle(cellStyle);
	    cellTL.setCellValue("Ten thể loại");
            
            Cell cellDate = row.createCell(6);
	    cellDate.setCellStyle(cellStyle);
	    cellDate.setCellValue("Ngày xuất bản");
            
            Cell cellTG = row.createCell(7);
	    cellTG.setCellStyle(cellStyle);
	    cellTG.setCellValue("Tên tác giả");
            
            Cell cellAnh = row.createCell(8);
	    cellAnh.setCellStyle(cellStyle);
	    cellAnh.setCellValue("Tên ảnh");
	}
	
	private List<Book_DTO> getListBook() {
	    /*Book_DTO book1 = new Book_DTO("Head First Java", "Kathy Serria", 79);
	    Book book2 = new Book("Effective Java", "Joshua Bloch", 36);
	    Book book3 = new Book("Clean Code", "Robert Martin", 42);
	    Book book4 = new Book("Thinking in Java", "Bruce Eckel", 35);
	 
	    List<Book_DTO> listBook = Arrays.asList(book1, book2, book3, book4);
            */
            Book_BUS bus = new Book_BUS();
            List<Book_DTO> listBook = bus.showAll();
	    return listBook;
	}

}
//Nguồn: https://viblo.asia/p/thao-tac-voi-file-excel-trong-java-su-dung-api-apache-poi-lPXzgajxRAg