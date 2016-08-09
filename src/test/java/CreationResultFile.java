import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by Alexandr on 09.08.2016.
 */

public class CreationResultFile {
    public void createExelFile(String fileName){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(fileName);
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Site Name");
        row.createCell(1).setCellValue("Location");
        row.createCell(2).setCellValue("Count of different vias");
        row.createCell(3).setCellValue("Test result");


    }

    public void addResultTotable(){

    }
}
