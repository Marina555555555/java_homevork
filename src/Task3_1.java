import java.util.HashMap; 
import java.util.ArrayList; 
import java.util.Arrays;

public class Task3_1 {
    public static void main(String args[]) {
        // Создать карту (Map), будет хранить в себе данные телефонной книги 
        // (Фамилии и телефонные номера), если будут дубликаты фамилий, 
        // то должны выводиться оба номера 
        // (если помним Map не может хранить дубликаты, будет заменять номер 
        // телефона по ключу, нужно подумать как не допустить такого)
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<String, ArrayList<String>>();
        
        addPhoneNumber(phoneBook, "Ivanov", "+790000000001");
        addPhoneNumber(phoneBook, "Petrov", "+790000000002");
        addPhoneNumber(phoneBook, "Ivanov", "+790000000003");
        addPhoneNumber(phoneBook, "Sidorov", "+79000000004");
        
        for (HashMap.Entry<String, ArrayList<String>> phoneEntry : phoneBook.entrySet()) {
            // Выводим фамилию (ключ) и номера телефонов (значение - список строк)
            // Преобразуем список в строку
            System.out.printf("%s: %s", phoneEntry.getKey(), Arrays.toString(phoneEntry.getValue().toArray()));
            System.out.println();
        }
    }

    public static void addPhoneNumber(HashMap<String, ArrayList<String>> phoneBook, String family, String phoneNumber) {
        if (phoneBook.containsKey(family)) {
            // Извлекаем список из phoneBook если уже есть фамилия
            ArrayList<String> phoneNumbers = phoneBook.get(family);
            // Добавляем телефон в этот список для этой фамилии
            phoneNumbers.add(phoneNumber);
        } else {
            // Создаем пустой список и добавляем в него номер телефона
            ArrayList<String> phoneNumbers = new ArrayList<String>();
            phoneNumbers.add(phoneNumber);
            // Вставляем этот список в phoneBook для заданной фамилии
            phoneBook.put(family, phoneNumbers);
        }
    }
}