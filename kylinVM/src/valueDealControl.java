import java.util.HashMap;

public class valueDealControl {
    //the value of the programing langauge
    public static HashMap<String,String> variable = new HashMap<String,String>();


    public static String getValueType(String value) {
        String type = "string";
        value = value.replace(" ","");
        try {
            //is Int?
            int num = Integer.valueOf(value);
            return "int";
        }catch (Exception exception) {
            type = "string";
        }
        try {
            Double num = Double.valueOf(value);
            return "double";
        }catch (Exception exception) {
            type = "string";
        }
        return type;
    }
    public static String replaceSpace(String code) {
        if (code.equals("")) {
            return " ";
        }
        //replace all the space before the real code.
        String[] strings = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"
                ,"q","r","s","t","u","v","w","x","y","z"
                ,"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"
                ,"R","S","T","U","V","W","X","Y","Z"
        };
        String codes = "";
        for (int i =0;i<code.length();i++) {
            String num = code.substring(i,i+1);
            //System.out.println(num+";");
            for (int a =0;a<strings.length;a++) {
                if (num.equals(strings[a])) {
                    codes = code.substring(i,code.length());
                    //System.out.println(codes);
                    return codes;
                }
            }
        }
        return codes;
    }
}
