public class valueDealControl {
    //La valoro de la programlingvo
    public static String[] valueContent = new String[0];
    public static String[] valueName = new String[0];
    public static String[] valueKeyWord = {"var"};
    public static String[] valueType = new String[0];
    //All the function of the kylin langauge.
    public static String[] function = {""};

    public static String getValueType(String value) {
        String type = "string";
        value = value.replace(" ","");
        //TODO:Varia montrilo efektivigo
        try {
            //is Int?
            int num = Integer.valueOf(value);
            return "ent";
        }catch (Exception exception) {
            type = "shnuro";//ŝnuro
        }
        try {
            Double num = Double.valueOf(value);
            return "decimalo";
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
                ,"q","r","s","t","u","v","w","x","y","z","ĝ","ĉ","ŝ","ŭ","ĵ"
                ,"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"
                ,"R","S","T","U","V","W","X","Y","Z","Ĝ","Ĉ","Ŝ","Ŭ","Ĵ"
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
