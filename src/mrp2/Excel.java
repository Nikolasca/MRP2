/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrp2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author nikol
 */
public class Excel {

    public void CrearExcel(Linea entrada, Linea entrada2, Linea entrada3, String ruta) {

        WorkbookSettings conf = new WorkbookSettings();
        conf.setEncoding("ISO-8859-1");
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(ruta), conf);
            WritableSheet sheet = workbook.createSheet("cronograma", 0);
            WritableFont h = new WritableFont(WritableFont.ARIAL, 16, WritableFont.BOLD);
            WritableFont h1 = new WritableFont(WritableFont.ARIAL, 16);
            WritableCellFormat hformat = new WritableCellFormat(h);
            WritableCellFormat hformat1 = new WritableCellFormat(h1);
            for (int i = 0; i < entrada.hola.length; i++) {

                if (entrada.hola[i] != null) {
                    sheet.addCell(new jxl.write.Label(0, 1, "C1", hformat));
                    sheet.addCell(new jxl.write.Label(i + 1, 1, String.valueOf(entrada.hola[i].id), hformat));
                   if(entrada.hola[i].getTipo()==1){
                    WritableCell c = sheet.getWritableCell((i + 1), 1);
                    WritableCellFormat newFormat = new WritableCellFormat(c.getCellFormat());
                    newFormat.setBackground(Colour.AQUA);
                    c.setCellFormat(newFormat);
                   
                   }
                    if(entrada.hola[i].getTipo()==2){
                    WritableCell c = sheet.getWritableCell((i + 1), 1);
                    WritableCellFormat newFormat = new WritableCellFormat(c.getCellFormat());
                    newFormat.setBackground(Colour.LIME);
                    c.setCellFormat(newFormat);
                   
                   }
                         if(entrada.hola[i].getTipo()==3){
                    WritableCell c = sheet.getWritableCell((i + 1), 1);
                    WritableCellFormat newFormat = new WritableCellFormat(c.getCellFormat());
                    newFormat.setBackground(Colour.YELLOW);
                    c.setCellFormat(newFormat);
                   
                   }    

                }

            }
            for (int i = 0; i < entrada2.hola.length; i++) {

                if (entrada2.hola[i] != null) {
                    sheet.addCell(new jxl.write.Label(0, 2, "C2", hformat));
                    sheet.addCell(new jxl.write.Label(i + 1, 2, String.valueOf(entrada2.hola[i].id), hformat));
                    
                    if(entrada2.hola[i].getTipo()==1){
                    WritableCell c = sheet.getWritableCell((i + 1), 2);
                    WritableCellFormat newFormat = new WritableCellFormat(c.getCellFormat());
                    newFormat.setBackground(Colour.AQUA);
                    c.setCellFormat(newFormat);
                   
                   } 
                      
                    if(entrada2.hola[i].getTipo()==2){
                    WritableCell c = sheet.getWritableCell((i + 1), 2);
                    WritableCellFormat newFormat = new WritableCellFormat(c.getCellFormat());
                    newFormat.setBackground(Colour.LIME);
                    c.setCellFormat(newFormat);
                   
                   }
                     if(entrada2.hola[i].getTipo()==3){
                    WritableCell c = sheet.getWritableCell((i + 1), 2);
                    WritableCellFormat newFormat = new WritableCellFormat(c.getCellFormat());
                   newFormat.setBackground(Colour.YELLOW);
                    c.setCellFormat(newFormat);
                   
                   }    
                }
              

            }
            for (int i = 0; i < entrada3.hola.length; i++) {

                if (entrada3.hola[i] != null) {
                    sheet.addCell(new jxl.write.Label(0, 3, "C3", hformat));
                    sheet.addCell(new jxl.write.Label(i + 1, 3, String.valueOf(entrada3.hola[i].id), hformat));
                     
                    if(entrada3.hola[i].getTipo()==1){
                    WritableCell c = sheet.getWritableCell((i + 1), 3);
                    WritableCellFormat newFormat = new WritableCellFormat(c.getCellFormat());
                    newFormat.setBackground(Colour.AQUA);
                    c.setCellFormat(newFormat);
                   
                   } 
                     if(entrada3.hola[i].getTipo()==2){
                    WritableCell c = sheet.getWritableCell((i + 1), 3);
                    WritableCellFormat newFormat = new WritableCellFormat(c.getCellFormat());
                    newFormat.setBackground(Colour.LIME);
                    c.setCellFormat(newFormat);
                   
                   } 
                        if(entrada3.hola[i].getTipo()==3){
                    WritableCell c = sheet.getWritableCell((i + 1), 3);
                    WritableCellFormat newFormat = new WritableCellFormat(c.getCellFormat());
                    newFormat.setBackground(Colour.YELLOW);
                    c.setCellFormat(newFormat);
                   
                   }    
                }

            }
            for (int i = 0; i < entrada3.hola.length; i++) {
                sheet.addCell(new jxl.write.Label(i, 0, String.valueOf(i), hformat1));

            }
            workbook.write();

            workbook.close();

        } catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);

        } catch (WriteException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
