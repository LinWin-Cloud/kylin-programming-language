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
            if (apiKey.equals("println")) {
                String tmpFunctionContent = code.substring(code.indexOf("(")+1,code.indexOf(")"));
                tmpFunctionContent = tmpFunctionContent.replace(" ","");
                Boolean isVar = API.isVariable(tmpFunctionContent);
                if (isVar) {
                    //is a variable.
                    String getVarContent = valueDealControl.variable.get(tmpFunctionContent);
                    if (valueDealControl.getValueType(getVarContent).equals("string")) {
                        System.out.println(getVarContent.substring(getVarContent.indexOf("\"")+1,getVarContent.lastIndexOf("\"")));
                    }
                    else {
                        System.out.println(getVarContent.substring(1,getVarContent.length()));
                    }
                }
                else {
                    String getVarContent = tmpFunctionContent;
                    if (maths.isMath(code)){
                        System.out.println(maths.dealMathContent(getVarContent));
                        return;
                    }
                    if (valueDealControl.getValueType(getVarContent).equals("string")) {
                        System.out.println(getVarContent.substring(getVarContent.indexOf("\"")+1,getVarContent.lastIndexOf("\"")));
                    }else {
                        System.out.println(getVarContent.substring(1,getVarContent.length()));
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
        String getValues = valueDealControl.variable.get(value);
        if (getValues == null) {
            bool = false;
        }
        else {
            bool = true;
        }
        return bool;
    }
}
