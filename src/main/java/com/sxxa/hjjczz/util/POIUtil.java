package com.sxxa.hjjczz.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

import java.io.BufferedInputStream;
import java.io.FileInputStream;


@Log4j2
public class POIUtil {

    public JSONObject getRead(String path) throws Exception {
        JSONObject map = new JSONObject();
        //1、获取文件的路径
        //1.1、从桌面获取文件
        //FileSystemView fsv = FileSystemView.getFileSystemView();
        //String desktop = fsv.getHomeDirectory().getPath();
        //String filePath = desktop + "/testexcel.xls";
        //1.2本地tomcat下获取
        String tomcatUrl = System.getProperty("catalina.home");
        String filePath = tomcatUrl + path;
        //2、通过流获取本地文件
        FileInputStream fileInputStream = new FileInputStream(filePath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
        //3、创建工作簿对象，并获取工作表1
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        int sheetNum = workbook.getNumberOfSheets();
        for(int s=0;s<sheetNum;s++){
            HSSFSheet sheet = workbook.getSheetAt(s);
            //4、从工作表中获取行数，并遍历
            int lastRowIndex = sheet.getLastRowNum();
            HSSFRow firstrow = sheet.getRow(0);
            JSONArray arr = new JSONArray();
            for (int i = 1; i <= lastRowIndex; i++) {
                //4.1 获取每行的数据
                HSSFRow row = sheet.getRow(i);
                if (row == null) {
                    break;
                }
                //5、从每一列中获取参数
                JSONObject obj = new JSONObject(true);
                short lastCellNum = row.getLastCellNum();
                for (int j = 0; j < lastCellNum; j++) {
                    //设置返回值的类型
                    row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                    //获取每列的数据
                    String cellValue = row.getCell(j).getStringCellValue();
                    //生成json
                    obj.put(firstrow.getCell(j)+"", cellValue+"");

                }
                //将最后的结果封装到List集合中
                arr.add(obj);
            }
            //6、关闭资源、输出封装数据
            bufferedInputStream.close();
            log.info("arr：" + arr);
            map.put(sheet.getSheetName()+"",arr);
        }
        return map;
    }
}
