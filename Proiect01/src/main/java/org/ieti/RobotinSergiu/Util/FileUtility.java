package org.ieti.RobotinSergiu.Util;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtility {
    public static final String PATH_TO_FILE = "src/main/java/org/ieti/RobotinSergiu/WorldCupList.json";

    public static void writeToFile(List<WorldCup> WorldCupList){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        File file = new File(PATH_TO_FILE);
        try{
            writer.writeValue(file,WorldCupList);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void readFromFile(){
        Path path = Paths.get(PATH_TO_FILE);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e){
            e.printStackTrace();
        }
        String data = new String(bytes);
        System.out.println("read from this file; " + data);
    }
}
