import java.util.*;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public int getTreshold() {
        return treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        Filter f = new Filter(getTreshold());
        for (Integer item : source) {
            if (item > f.getTreshold()) {
                result.add(item);
                logger.log("Элемент '" + item + "' проходит");
            } else {
                logger.log("Элемент '" + item + "' не проходит");
            }
        }
        logger.log("Прошло фильтр " + result.size() + " элементов из " + source.size());
        return result;
    }
}