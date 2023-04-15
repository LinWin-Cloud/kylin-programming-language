package com.kylin.Runtime;

import java.util.ArrayList;
import java.util.HashMap;

public class Function {
    public HashMap<String,String> FunctionValue = new HashMap<>();
    public ArrayList<String> FunctionCode = new ArrayList<>();
    public String FunctionName;
    public HashMap<String,Value> LocalValue = new HashMap<>();
}
