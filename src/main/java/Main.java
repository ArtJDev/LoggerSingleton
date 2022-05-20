import java.util.*;

public class Main {
    public static void main(String[] args) {
        int listSize;
        int maxValue;
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Filter filter;

        logger.log("Запускаем программу");
        logger.log("Введите входные данные для списка");
        while (true) {
            System.out.println("Введите размер списка: ");
            String in = scanner.nextLine();
            try {
                listSize = Integer.parseInt(in);
                break;
            } catch (RuntimeException ex) {
                logger.log("Некорректный ввод. Введите целое число");
            }
        }
        while (true) {
            System.out.println("Введите верхнюю границу списка: ");
            String in = scanner.nextLine();
            try {
                maxValue = Integer.parseInt(in);
                break;
            } catch (RuntimeException ex) {
                logger.log("Некорректный ввод. Введите целое число");
            }
        }
        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(maxValue));
        }
        System.out.print("Вот случайный список: ");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
        logger.log("Введите входные данные для фильтрации");
        while (true) {
            System.out.println("Введите порог для фильтра: ");
            String in = scanner.nextLine();
            try {
                filter = new Filter(Integer.parseInt(in));
                break;
            } catch (RuntimeException ex) {
                logger.log("Некорректный ввод. Введите целое число");
            }
        }
        logger.log("Запускаем фильтрацию");
        List<Integer> filteredList = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        for (Integer item : filteredList) {
            System.out.print(item + " ");
        }
        System.out.println();
        logger.log("Завершаем программу");
    }
}