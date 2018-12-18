package excel02;

import java.io.File;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class TestDbToExcel {

    public static void main(String[] args) {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
               String fileName = "D://book.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<StuEntity> list= StuService.getAllByDb();
               //要插入到的Excel表格的行号，默认从0开始
               Label userid = new Label(0, 0, "编号(userid)");//表示第
               Label username = new Label(1, 0, "姓名(username)");
               Label password = new Label(2, 0, "密码(password)");
               //Label labelNum= new Label(3, 0, "薪水(num)");
               
               ws.addCell(userid);
               ws.addCell(username);
               ws.addCell(password);
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelId_i= new Label(0, i+1, list.get(i).getUserid()+"");
                   Label labelName_i= new Label(1, i+1, list.get(i).getUsername());
                   Label labelSex_i= new Label(2, i+1, list.get(i).getPassword()+"");
                   //Label labelNum_i= new Label(3, i+1, list.get(i).getNum()+"");
                   ws.addCell(labelId_i);
                   ws.addCell(labelName_i);
                   ws.addCell(labelSex_i);
                   //ws.addCell(labelNum_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}