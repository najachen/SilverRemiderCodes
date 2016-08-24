package silver.reminder;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class BoDaoGenCode {

    @Test
    public void addition_isCorrect() throws Exception {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);

        cfg.setClassForTemplateLoading(BoDaoGenCode.class, "樣板檔案資料夾路徑 免於之後樣板檔檔名很長");
//        cfg.setDirectoryForTemplateLoading(new File("E:/Work/Freemarker/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setLocale(Locale.TAIWAN);





        Template temp = cfg.getTemplate("person.ftl");  // load E:/Work/Freemarker/templates/person.ftl

        // Create the root hash
        Map<String, Object> root = new HashMap<String, Object>();

        root.put("packageName", "com.ricky.java");
        root.put("className", "Person");
        root.put("author", "Ricky Fung");

//        List<ValueExampleObject> attr_list = new ArrayList<ValueExampleObject>();
//        attr_list.add(new ValueExampleObject("id", "Long"));
//        attr_list.add(new ValueExampleObject("name", "String"));
//        attr_list.add(new ValueExampleObject("age", "Integer"));
//        attr_list.add(new ValueExampleObject("hobby", "List<String>"));

//        root.put("attrs", attr_list);

//      Writer out = new OutputStreamWriter(System.out);
//      Writer out = new OutputStreamWriter(System.out);
        File dir = new File("E:/Work/Freemarker/src/");
        if(!dir.exists()){
            dir.mkdirs();
        }
        OutputStream fos = new FileOutputStream( new File(dir, "Person.java")); //java文件的生成目录
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);

        fos.flush();
        fos.close();

        System.out.println("gen code success!");
    }
}

class TableAndFieldNames{

    private String tableName;
    private Map<String, String> fieldNameAndType;

    public TableAndFieldNames(String createTableSql) {

    }

    private static String getTableName(String createTableSql){
        return null;
    }

//    private static Map get
}