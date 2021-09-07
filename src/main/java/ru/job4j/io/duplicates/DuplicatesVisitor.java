package ru.job4j.io.duplicates;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * https://job4j.ru/profile/exercise/45/task-view/315
 * <p>
 * Нужно написать программу, которая принимает на вход
 * папку, просматривает все файлы в ней (и всех подпапках
 * и под-под-...папках) и сообщает, если находит дубликаты.
 * Дубликаты – это два файла с одинаковым именем и размером.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 06.09.2021
 */
public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    int counter = 0;
    int counterDuplicate = 0;
    List<FileProperty> filePropertyList = new ArrayList<>();
    Map<Path, FileProperty> hashMap = new HashMap<>();
    boolean isDuplicate = false;
    Map<Path, FileProperty> hashMapOnlyDuplicates = new HashMap<>();

    //Map<Path, FileProperty> hashMapBuffer = new HashMap<>();
    //Map.Entry<Path, FileProperty> hashMapBufferEntry = (Map.Entry<Path, FileProperty>) new HashMap<Path, FileProperty>();
    //ArrayList<Map.Entry<Path, FileProperty>> bufferArrayList = new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes atts)
            throws IOException {

        // сохраняем все файлы и пути в arrayList
        filePropertyList.add(new FileProperty(Files.size(file), file.getFileName().toString()));
        // проверяем находится ли файл в hashMap
        if (hashMap.containsValue(new FileProperty(Files.size(file), file.getFileName().toString()))) {
            isDuplicate = true;
            counterDuplicate++;
            // добавляем дубликат в hashMapOnlyDuplicates
            hashMapOnlyDuplicates.put(file,
                    (new FileProperty(Files.size(file),
                            file.getFileName().toString())));
            //System.out.println();
            System.out.println("path1 is: " + file);
            // добавляем дубликат в hashMapOnlyDuplicates, хранимый в hashMap
            hashMapOnlyDuplicates.put(
                    (Path) hashMap.get(file.getFileName().toAbsolutePath()),
                    hashMap.get(file.getFileName()));

            System.out.println("path2 is: "
                    //+ ((Path) hashMap.get(file.getFileName().toAbsolutePath()))

                    + System.lineSeparator()
                    + hashMapOnlyDuplicates.get(file).toString()
                    + System.lineSeparator()
                    + "is duplicate? " + isDuplicate
                    + System.lineSeparator()
                    + "Total duplicate counter: " + counterDuplicate
                    + System.lineSeparator());
        }


        // сохраняем все файлы и пути в hashMap
        hashMap.put(file, new FileProperty(Files.size(file), file.getFileName().toString()));


        // тупо выводим один файл, который сейчас взять в обработку на печать
//        System.out.println("path is : " + file + System.lineSeparator()
//                + hashMap.get(file)
//                + System.lineSeparator()
//                // + "counter: " + counter
//                + "is duplicate? " + isDuplicate
//                + System.lineSeparator()
//                + "Total duplicate counter: " + counterDuplicate
//                + System.lineSeparator());
//        counter += 1;
//        if (hashMapOnlyDuplicates.size() != 0 && isDuplicate) {
//            // выводим дубликаты из hashMapOnlyDuplicates
//            System.out.println("absolute path is: " + file.toAbsolutePath()
//                    + hashMapOnlyDuplicates.get(file).toString()
//                    //+ file.getFileName()
//                    + System.lineSeparator()
//                    // + "counter: " + counter
//                    + "is duplicate? " + isDuplicate
//                    + System.lineSeparator()
//                    + "Total duplicate counter: " + counterDuplicate
//                    + System.lineSeparator());
//        }


        //System.out.println(file.toAbsolutePath() + "counter : " + counter);
        //System.out.println(file.toAbsolutePath() + "counter : " + counter);
        //System.out.println("filePropertyList.get(counter): " + filePropertyList.get(counter));
        //System.out.println(file.toAbsolutePath()));
        //counter += 1;
        //System.out.println();

        //filePropertyList.forEach(System.out::println);
        //hashMap.entrySet().forEach(System.out::println);


        //проходитм по мапе и удаляем все не дубликаты
        //hashMap.entrySet().stream().filter(e -> e)
//        for (Map.Entry<Path, FileProperty> entry : hashMap.entrySet()) {
//            if (hashMap.containsValue(entry.getValue())) {
//
//            }
//        }

        // получаем файл из пототка чтения
        // добавляем его в hashMap и bufferArrayList

//        Iterator<Map.Entry<Path, FileProperty>> itr = hashMap.entrySet().iterator();
//        while (itr.hasNext()) {
//            Map.Entry<Path, FileProperty> entry = itr.next();
//            //hashMapBuffer.put(entry.getKey(), entry.getValue());
//            bufferArrayList.add(entry);
//            System.out.println("bufferArrayList: " + bufferArrayList.size());
//            //itr.remove();


//            if (hashMap.containsValue(bufferArrayList.get(0).getValue())) {
//                hashMapOnlyDuplicates.put(entry.getKey(), entry.getValue());
//                bufferArrayList.remove(0);
//                bufferArrayList.trimToSize();
//            }

        // Если записи нет в дубликатах
//            if (!hashMapOnlyDuplicates.containsValue(bufferArrayList.get(0).getValue())) {
//                hashMapOnlyDuplicates.put(entry.getKey(), entry.getValue());
//                bufferArrayList.remove(0);
//                bufferArrayList.trimToSize();
//            }
//            else {
//                hashMapOnlyDuplicates.put(entry.getKey(), entry.getValue());
//            }


//            System.out.println("KEY: " + entry.getKey()
//                    + "VALUE: " + entry.getValue()
//                    + "counter: " + counter);
        //  counter += 1;
//        }
//        System.out.println("hashMap.size(): " + hashMap.size());
//        System.out.println("hashMapOnlyDuplicates.size(): "
//                + hashMapOnlyDuplicates.size());
//        System.out.println("counter: " + counter);

        //System.out.println("filePropertyList.size(): " + filePropertyList.size());


        // получаем мапу содержащую дубликаты
        // выводим на печать дубликаты

        isDuplicate = false;
        return super.visitFile(file, atts);
    }
}
