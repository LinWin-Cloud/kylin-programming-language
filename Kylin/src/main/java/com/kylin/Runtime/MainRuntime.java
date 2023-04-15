package com.kylin.Runtime;

import com.kylin.Exception.SyntaxError;
import com.kylin.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class MainRuntime {
    private ArrayList<String> code = new ArrayList<>();
    private HashMap<String,Value> value = new HashMap<>();
    private HashMap<String,String> function = new HashMap<>();

    public void setCode(ArrayList<String> arrayList) {
        this.code = arrayList;
    }

    public void run() {
        int codeLine = 0;
        for (String source_code : code) {
            codeLine++;
            String[] words = source_code.split(" ");
            if (words[0].startsWith("//")) {
                continue;
            }
            if (words[0].startsWith("let")) {
                try {
                    String name = words[1];
                    String value = source_code.substring(source_code.indexOf("=")+1).trim();
                    Value NewValue = new Value();
                    NewValue.name = name;
                    NewValue.value = value;

                    this.value.put(name,NewValue);
                }
                catch (Exception exception){
                    this.sendSyntaxError("Defined variable error.");
                }
            }
            if (words[0].startsWith("func")) {
                try {
                    String FunctionName = words[1];
                    String FunctionContent = source_code.substring(source_code.indexOf("(")+1,source_code.lastIndexOf(")")-1);
                    String[] InputValue = FunctionContent.split(",");

                    ArrayList<String> FunctionCode = new ArrayList<>();

                    for (int i = codeLine ; i < code.size() ; i++) {
                        String line = code.get(i).trim();

                        if (line.startsWith("end")) {
                            break;
                        }
                        FunctionCode.add(line);
                    }
                    Function func = new Function();
                    func.FunctionCode = FunctionCode;
                    func.FunctionName = FunctionName;
                    for (String i : InputValue){
                        func.FunctionValue.put(i.trim(),null);
                    }
                }catch (Exception exception){
                    this.sendSyntaxError("Defined function error.");
                }
            }
        }
    }
    public void sendSyntaxError(String message) {
        SyntaxError syntaxError = new SyntaxError();
        syntaxError.setFile(Main.resource.getAbsolutePath());
        syntaxError.setMessage(message);
        syntaxError.setTime();
        System.out.println(syntaxError.getError());
        System.exit(0);
    }
}
