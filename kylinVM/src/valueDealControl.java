public class valueDealControl {
    //the value of the programing langauge
    public static String[] valueContent = new String[0];
    public static String[] valueName = new String[0];
    public static String[] valueKeyWord = {"var"};
    public static String[] valueType = new String[0];
    //All the function of the kylin langauge.
    public static String[] function = {""};

    public static String getValueType(String value) {
        String type = "shnuro";
        value = value.replace(" ","");
        try {
            //is Int?
            int num = Integer.valueOf(value);
            return "ent";
        }catch (Exception exception) {
            type = "shnuro";
        }
        try {
            Double num = Double.valueOf(value);
            return "duoble";
        }catch (Exception exception) {
            type = "shnuro";
        }
        return type;
    }
    public static String replaceSpace(String code) {
        if (code.equals("")) {
            return " ";
        }
        //replace all the space before the real code.
        String[] strings = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"
                ,"q","r","s","t","u","v","w","x","y","z","ĥ","ĉ","ŝ","ĵ","ŭ"
                ,"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"
                ,"R","S","T","U","V","W","X","Y","Z",""
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
    public static String getValueContent(String value) {
        String content = "";
        for (int i =0;i < valueDealControl.valueName.length;i++) {
            if (valueDealControl.valueName[i].equals(value)){
                content = valueDealControl.valueContent[i];
            }else {
                content = "";
            }
        }
        return content;
    }
    public static String findValueType(String value) {
        String content = "";
        for (int i =0;i < valueDealControl.valueName.length;i++) {
            if (valueDealControl.valueName[i].equals(value)){
                content = valueDealControl.valueType[i];
            }else {
                content = "";
            }
        }
        return content;
    }
}
