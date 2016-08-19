import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 09.08.2016.
 */

public class CreationResultFile {

    public List<TestResultFileds> dataModels = new ArrayList<TestResultFileds>();
    CreationResultFile creationResultFile = new CreationResultFile();
    TestResultFileds testRes = new TestResultFileds();
    public List<TestResultFileds> recordTestResult(String nameOfCurrentSite, String  testLocations, int countOfVisits, boolean resultOfChekin) {
               dataModels.add(new TestResultFileds(nameOfCurrentSite,testLocations,countOfVisits,resultOfChekin));
        return dataModels;
    }
    public void createExelFile(String fileName){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(fileName);
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Site Name");
        row.createCell(1).setCellValue("Location");
        row.createCell(2).setCellValue("Count of different vias");
        row.createCell(3).setCellValue("Test result");
        int count = dataModels.size();

        for (int i=0;count==i; i++){
          Row resultRow = sheet.createRow(i+1);
            resultRow.createCell(0).setCellValue(dataModels.get(i).getNameOfCurrentSite());
            resultRow.createCell(1).setCellValue(dataModels.get(i).getTestLocations());
            resultRow.createCell(2).setCellValue(dataModels.get(i).getCountOfVisits());
            resultRow.createCell(3).setCellValue(dataModels.get(i).isResultOfCheking());
        }

               // записываем созданный в памяти Excel документ в файл
        try (FileOutputStream out = new FileOutputStream(new File("E:\results\fileName.xls"))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!");
    }
    }





