package cz.java.uloha1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

    public static void main(String[] args) throws IOException{


        File file = new File(".\\datafiles\\vzorek_dat.xlsx");


        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = wb.getSheetAt(0);

        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext())
        {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch (cell.getCellType())
                {
                    case STRING:
                        try{
                            Integer num = Integer.valueOf(cell.getStringCellValue());
                            boolean flag = false;
                            for (int i = 2; i <= num / 2; ++i) {
                                if (num % i == 0) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (!flag){
                                System.out.println(num);
                            }

                        }
                        catch (NumberFormatException ex){

                        }

                        break;

                    default:
                }
            }

        }



    }
}




