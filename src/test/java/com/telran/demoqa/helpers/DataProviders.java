package com.telran.demoqa.helpers;

import com.telran.demoqa.data.StData;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> newStudent() {
        List<Object[]> list = new ArrayList<>() {{
            add(new Object[]{StData.FIRST_NAME, StData.LAST_NAME, StData.EMAIL, StData.PHONE, StData.GENDER, StData.B_DAY, StData.SUBJECTS, StData.HOBBIES, StData.FILE});
            add(new Object[]{StData.FIRST_NAME_TWO, StData.LAST_NAME_TWO, StData.EMAIL, StData.PHONE, StData.GENDER, StData.B_DAY, StData.SUBJECTS, StData.HOBBIES, StData.FILE});
        }};
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newStudentFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Students6.csv")));
        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            Object[] data = new Object[split.length];
            for (int i = 0; i < split.length; i++) {
                if (!split[i].contains(";")) {
                    data[i] = split[i]; // элементы с одним значением
                } else { // элементы со списком значений (должны содержать хотя бы один символ ";") преобразуем в массив строк link
                    String[] link = split[i].split(";");
                    String[] linkWithoutSpase = new String[link.length]; // убираем пробелы
                    for (int j = 0; j < link.length; j++) {
                        linkWithoutSpase[j] = link[j].trim();
                    }
                    data[i] = linkWithoutSpase;
                }
            }
            list.add(new Object[]{new StData()
                    .setFirstName((String) data[0])
                    .setLastName((String) data[1])
                    .setEmail((String) data[2])
                    .setPhone((String) data[3])
                    .setGender((String) data[4])
                    .setBDay((String) data[5])
                    .setSubjects((String[]) data[6])
                    .setHobbies((String[]) data[7])
                    .setFile((String) data[8])
            });
            line = reader.readLine();
        }
        return list.iterator();
    }


}
