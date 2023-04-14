package com.kylin.Runtime;

import com.kylin.Exception.SyntaxError;
import com.kylin.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class MainRuntime {
    private ArrayList<String> code = new ArrayList<>();
    private HashMap<String,String> value = new HashMap<>();
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
                    String tmp = words[2];

                    if (tmp.equals("=")) {
                        this.value.put(name,words[3]);
                        continue;
                    }
                    if (tmp.equals(";")) {
                        this.value.put(name,null);
                        continue;
                    }
                    else {
                        this.sendSyntaxError("Defined variable error.");
                    }
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
