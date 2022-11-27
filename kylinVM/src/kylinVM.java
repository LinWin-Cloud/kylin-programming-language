import javax.xml.namespace.QName;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.List;

public class kylinVM {
    public static void main(String[] args) {
        //String filePath = "kylinVM/test/1.ky";
        String filePath = args[0];
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println(errorDealControl.getError_FileNotFind(filePath));
            System.exit(0); //quit
        }
        //file is exists,then run.
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String fileLine;
            //String getOneLine = "";
            
            List<String> listLine = new ArrayList<>();

            while((fileLine = bufferedReader.readLine())!=null) {
                //read all the file content and add to one line to a value.
                listLine.add(fileLine);
            }
            String[] lineFile = listLine.toArray(new String[listLine.size()]);
            
            for (int i = 0;i < lineFile.length;i++) {
                String getLineContent = lineFile[i];
                getLineContent = valueDealControl.replaceSpace(getLineContent);
                kylinVM.dealValueCode(getLineContent,file.getAbsolutePath());
                //the kylin language API.
                API.apiIs(getLineContent);
            }
            bufferedReader.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public static void dealValueCode(String line,String filePath) {
        //deal the code of the kylin language.
        int codeLength = line.length();
        for (int a=0;a<codeLength;a++) {
            //the var keyword.
            //make a new token.
            if (line.substring(0,a).equals("var ")) {
                List<String> list = new ArrayList<>();
                int equals = line.indexOf("=");
                //System.out.println(a+" "+equals);
                String NewVarName = line.substring(a,equals);

                try {
                    NewVarName = NewVarName.replace(" ","");
                    String getValueContent = line.substring(equals+1, line.lastIndexOf(";"));
                    String getValueType = valueDealControl.getValueType(getValueContent);
                    //add the value to the variable.
                    //use hashMap
                    String getExists = valueDealControl.variable.get(NewVarName);
                    if (getExists == null) {
                        valueDealControl.variable.put(NewVarName,getValueContent); //add t the variable.
                        break;
                    }else {
                        System.out.println(errorDealControl.getError_Value_defined(line+" defined="+NewVarName));
                        System.exit(0);
                    }

                }catch (Exception exception) {
                    System.out.println("[Error] Error: Do Not Have ';'");
                    System.out.println("Line: (==> "+line+" <==)");
                    System.out.println("In File="+filePath);
                    System.exit(0);
                }
                break;
            }
        }
    }
}