import javax.xml.namespace.QName;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kylinVM {
    public void AgoVar(String VarNomo,String ValoroTajpu,String VarValoro){
        if (ValoroTajpu=="ent"){
            Map<String, Integer> EntVar=new HashMap<String, Integer>();
            EntVar.put(VarNomo,Integer.valueOf(VarValoro));
        }
        else if (ValoroTajpu=="shnuro"){

        }
        else if (ValoroTajpu=="decimalo"){

        }
    }

    public static void main(String[] args) {
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
                //System.out.println(getLineContent);
                kylinVM.dealValueCode(getLineContent,file.getAbsolutePath());
            }
            bufferedReader.close();
            for (int i=0;i<valueDealControl.valueName.length;i++) {
                String VarNomo = valueDealControl.valueName[i];
                //aplika variablo
                System.out.print("Valoro Nomo: "+VarNomo+" ; Tajpu: "+valueDealControl.valueType[i]+" ; Enhavo: "+valueDealControl.valueContent[i]+";\n");
            }
            //System.out.println(getOneLine);
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
                //System.out.println(NewVarName);
                NewVarName = NewVarName.replace(" ","");
                for (int i = 0;i<valueDealControl.valueName.length;i++) {
                    if (valueDealControl.valueName[i].equals(NewVarName)) {
                        //System.out.println(errorDealControl.getError_Value_defined(NewVarName));
                        System.exit(0);
                    }else {
                        list.add(valueDealControl.valueName[i]);
                    }
                }
                try {
                    String getValueContent = line.substring(equals+1, line.lastIndexOf(";"));
                    String getValueType = valueDealControl.getValueType(getValueContent);
                    //add the type of value.
                    List<String> list1 = new ArrayList<>();
                    for (int i=0;i<valueDealControl.valueType.length;i++) {
                        list1.add(valueDealControl.valueType[i]);
                    }
                    list1.add(getValueType);
                    valueDealControl.valueType = list1.toArray(new String[list1.size()]);

                    //add the value content to the value name.
                    List<String> list2 = new ArrayList<>();
                    for (int i =0;i<valueDealControl.valueContent.length;i++) {
                        list2.add(valueDealControl.valueContent[i]);
                    }
                    list2.add(getValueContent);
                    valueDealControl.valueContent = list2.toArray(new String[list2.size()]);

                }catch (Exception exception) {
                    System.out.println("[Eraro] Kylin Eraro: Ne havas';'");
                    System.out.println("Linio: (==> "+line+" <==)");
                    System.out.println("En Dosiero="+filePath);
                    System.exit(0);
                }
                list.add(NewVarName);
                valueDealControl.valueName = list.toArray(new String[list.size()]);
                break;
            }
        }
    }
}