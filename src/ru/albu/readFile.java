package ru.albu;

import java.io.*;
import java.util.*;

public class readFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String path = scanner.nextLine().trim();
        List<String> list = new ArrayList<String>() {};
        Map<String , Integer> map = new TreeMap<>();
        try {
            File file = new File(path);//C:/Users/Алексей Б/Desktop/ || "C:/Users/Алексей Б/Desktop/example.txt"
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                line = line.replaceAll("[^а-яА-Я a-zA-Z]", " ");

                String [] str = line.split(" ");

                for(String s:str)
                    if (s.isEmpty())
                        continue;
                    else
                        list.add(s.toLowerCase());

                line = reader.readLine();
            }

            Collections.sort(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s:list)
            System.out.print(s+" ");

        System.out.println();
        System.out.println();

        int max = 0;
        for(int i=0; i<list.size(); i++){
           int counter=0;
            for(int j=i; j<list.size(); j++){
                if(list.get(i).equals(list.get(j))){
                    counter++;
                    continue;
                }else {
                   map.put(list.get(i),counter );
                   if (max<counter)
                       max=counter;
                    System.out.println("слово - "+list.get(i)+" встречается "+counter+" раз");
                    i = j--;
                    break;
                }
            }

        }
        System.out.println();
        for(Map.Entry<String, Integer> item : map.entrySet()){
            if (item.getValue()==max)
            System.out.println("слово "+item.getKey()+" встречается "+max+" раз");
        }
    }
}
