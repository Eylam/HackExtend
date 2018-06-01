
/**
 * Write a description of class Restaurant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Restaurant
{
    // instance variables
    public static int _availableTables2;
    public static int _availableTables4;
    public static Table [] _tables;
    
    // dishes
    public enum Dishes{}

    public static void pickNextTable(int seats){
        if (seats == 2)
            for (int i = 0; i < _tables.length; i++) {
                if (_tables[i] instanceof Table2 && _tables[i]._isAvailable == true) {
                    _tables[i]._isAvailable = false;
                }
            }

        else if (seats == 4)
            for (int i = 0; i < _tables.length; i++) {
                if (_tables[i] instanceof Table4 && _tables[i]._isAvailable == true) {
                    _tables[i]._isAvailable = false;
                }
            }
    }

    public static boolean pickTable(int numberOfPpl){
        if (numberOfPpl > (_availableTables2*2 + _availableTables4*4))
        {
            print("The restaurant is full. Please wait outside!");
            return false;
        }
        while (numberOfPpl >= 3){
            if (_availableTables4 >= 0) {
                _availableTables4--;
                numberOfPpl -= 4;
                pickNextTable(4);
            }
            else if (_availableTables2 >= 0) {
                _availableTables2--;
                numberOfPpl -= 2;
                pickNextTable(2);
            }
        }
        if (numberOfPpl > 0 && numberOfPpl < 3){
            if (_availableTables2 >= 0) { 
                _availableTables2--;
                pickNextTable(2);
            }
            else if (_availableTables4 >= 0) {
                _availableTables4--;
                pickNextTable(4);
            }
        }
        return true;
    }
    
    private static void print (String s){
        System.out.println(s);
    }

    private static void print (int n){
        System.out.println(n);
    }

}
