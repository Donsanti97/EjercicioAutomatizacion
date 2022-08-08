import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

public class ReadExcelFiles {
    public ReadExcelFiles(){

    }
    //Leer archivos Excel
    public void readExcel(String filePath, String sheetName) throws IOException {
        //Ruta del archivo
        File file = new File(filePath);
        //Donde se ubican los datos del archivo cargado
        FileInputStream inputStream = new FileInputStream(file);
        //Fichero donde se guardará el excel
        XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
        //Objeto donde se guarda la hoja donde se está trabajando
        XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
        //Variable para guardar cuantas filas de datos tiene el excel
        int filas = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

        //Lectura de filas
        for (int i = 0; i <= filas; i++) {
            //Lee fila por fila de la hoja de excel
            XSSFRow fila = newSheet.getRow(i);

            //Leer cada celda de cada fila
            for (int j = 0; j < fila.getLastCellNum(); j++) {
                //Valor de la celda
                System.out.println(fila.getCell(j).getStringCellValue() + "| |");
            }
            
        }

    }

    public String getCelValue(String filePath, String sheetName, int numFila, int numCelda) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
        int filas = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

        //Fila
        XSSFRow fila = newSheet.getRow(numFila);
        //Numero de celda
        XSSFCell celda = fila.getCell(numCelda);

        return celda.getStringCellValue();
    }
}
