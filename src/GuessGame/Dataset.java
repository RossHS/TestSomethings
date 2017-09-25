package GuessGame;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Created by Ross on 25.09.2017.
 */
public class Dataset {
    public static CategoryDataset createDataset(){
        DefaultCategoryDataset dataset;
        // row keys...
        final String series1 = "";
        // column keys...

        dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 100; i++) {
            dataset.addValue(0,series1,String.valueOf(i));
        }
        GuessGame testData = new GuessGame();
        testData.main();
        for (int i = 0; i < 100; i++) {
            dataset.addValue(testData.range[i].value, series1, String.valueOf(testData.range[i].rangeValue));
        }

        return dataset;
    }
}
