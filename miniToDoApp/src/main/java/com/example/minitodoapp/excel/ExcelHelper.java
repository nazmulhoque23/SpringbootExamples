package com.example.minitodoapp.excel;

import com.example.minitodoapp.entity.Todo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] headers = {"Id", "Title","Description","Published"};
    static String SHEET = "Todos";

    public static boolean hasExcelFormat(MultipartFile file){
        if(!TYPE.equals(file.getContentType())){
            return false;
        }
        return true;
    }

    public static List<Todo> excelToTodo(InputStream is){
        try{
            Workbook workBook = new XSSFWorkbook(is);
            Sheet sheet = workBook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<Todo> todos = new ArrayList<Todo>();
            int rowNumber = 0;
            while(rows.hasNext()){
                Row currentRow = rows.next();

                if(rowNumber == 0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Todo todo = new Todo();
                int cellsId = 0;
                while(cellsInRow.hasNext()){
                    Cell currentCell = cellsInRow.next();
                    switch(cellsId){
                        case 0 :
                            todo.setId((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            todo.setTitle(currentCell.getStringCellValue());
                            break;
                        case 2:
                            todo.setDescription(currentCell.getStringCellValue());
                            break;
                        case 3:
                            todo.setPublished(currentCell.getBooleanCellValue());
                            break;
                        default:
                            break;
                    }
                    cellsId++;
                }
                todos.add(todo);
            }
            workBook.close();
            return todos;
        }catch(IOException e){
            throw new RuntimeException("UNHANDLED EXCEPTION");
        }
    }
}
