package org.ieti.RobotinSergiu;

import org.ieti.RobotinSergiu.Util.FileUtility;
import org.ieti.RobotinSergiu.Util.WorldCup;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main (String[] args){
        WorldCup WorldCup1 = new WorldCup(2002,"Robotin Sergiu",  "Fotbal", 1991, "Simona Halep", "Tenis de camp",1984,"Lebron James", "Baschet", 1980, "Marian Dragulescu", "Gimnastica");
        ArrayList<WorldCup> WorldCupList1=new ArrayList<>();
        WorldCupList1.add(WorldCup1);
        FileUtility.writeToFile(WorldCupList1);
        FileUtility.readFromFile();
    }
}
