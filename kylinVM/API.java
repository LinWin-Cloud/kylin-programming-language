import java.util.TooManyListenersException;

public class API {
    public static Boolean apiIs(String code) {
        int length = code.length();
        Boolean bool = false;
        for (int i =0;i<length;i++) {
            if (code.substring(0,i).equals("api."))
            {
                try {
                    String getRunAPI = code.substring(code.indexOf("api.")+"api.".length(),code.indexOf("("));
                    getRunAPI = getRunAPI.replace(" ",""); //replace space.
                    API.API_run(code,getRunAPI);
                    bool = true;
                    break;
                }catch (Exception exception) {
                    System.out.println(errorDealControl.getError_CodeError(code));
                    System.exit(0);
                }
            }
            else {
                bool = false;
            }
        }
        return bool;
    }
    public static void API_run(String code,String apiKey) {
        try{
            String tmpFunctionContent = code.substring(code.indexOf("(")+1,code.indexOf(")"));
            Boolean isVar = API.isVariable(tmpFunctionContent.replace(" ",""));

            String getTypeValue = "";

            for (int a=0;a<valueDealControl.valueName.length;a++) {
                if (isVar) {
                    getTypeValue = valueDealControl.valueType[a];
                }
            }

            if (apiKey.equals("println")) {
                //System.out.println(tmpFunctionContent+";");

                if (getTypeValue.equals("string")) {
                    //is string type .
                    if (isVar) {
                        for (int i=0;i<valueDealControl.valueName.length;i++) {
                            if (tmpFunctionContent.replace(" ","").equals(valueDealControl.valueName[i])) {

                                String tmp = valueDealControl.valueContent[i];
                                osMod.outLineLn(tmp.substring(tmp.indexOf("\"")+1,tmp.lastIndexOf("\"")));
                                break;
                            }
                        }
                    }else {
                        String printContent = tmpFunctionContent.substring(tmpFunctionContent.indexOf("\"")+1,tmpFunctionContent.lastIndexOf("\""));
                        osMod.outLineLn(printContent);
                    }
                }
                else {
                    if (isVar) {
                        for (int i=0;i<valueDealControl.valueName.length;i++) {
                            if (tmpFunctionContent.replace(" ","").equals(valueDealControl.valueName[i])) {
                                String tmp = valueDealControl.valueContent[i];
                                if (valueDealControl.getValueType(tmp).equals("string")) {
                                    osMod.outLineLn(tmp.substring(tmp.indexOf("\"")+1,tmp.lastIndexOf("\"")));
                                }else {
                                    osMod.outLineLn(tmp.substring(1,tmp.length()));
                                }
                                break;
                            }
                        }
                    }else {
                        String tmp = tmpFunctionContent;
                        if (tmp.indexOf("+")!=-1||tmp.indexOf("-")!=-1||tmp.indexOf("*")!=-1||tmp.indexOf("/")!=-1)
                        {
                            maths.dealMathContent(tmpFunctionContent);
                        }else {
                            osMod.outLineLn(tmp.substring(tmp.indexOf("\"")+1,tmp.lastIndexOf("\"")));
                        }
                    }
                }
            }
            if (apiKey.equals("print")) {

            }
        }catch (Exception exception){
            System.out.println(errorDealControl.getError_CodeError(code));
            exception.printStackTrace();
            System.exit(0);
        }
    }
    public static Boolean isVariable(String value) {
        Boolean bool = false;
        for (int i=0;i<valueDealControl.valueName.length;i++) {
            //if is the variavle then return true
            if (valueDealControl.valueName[i].equals(value)){
                bool = true;
                break;
            }
            else {
                bool = false;
            }
        }
        return bool;
    }
}
