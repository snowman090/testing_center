package core.test;

import core.event.DataCollection;

import java.util.List;

/**
 * Created by Acer on 10/9/2015.
 */


public class FileLoader {
    public FileLoader(){


    }

    public static void main(String[] args) {
        List<String[]> test = null;
        String pathStudent = "./doc/user.csv";
        DataCollection data = new DataCollection();
        data.readFile(pathStudent,test);
    }
}
