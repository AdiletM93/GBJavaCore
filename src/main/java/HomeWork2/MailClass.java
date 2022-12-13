package HomeWork2;

public class MailClass {
    public static int arraySum(String[][] array) throws MyArraySizeException {

        int sum = 0;

        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] arr : array) {
            if (arr.length !=4) {
                throw new MyArraySizeException();
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        String[][] correct_array =
                {{"1","2","3","4"},
                 {"1","2","3","4"},
                 {"1","2","3","4"},
                 {"1","2","3","4"}};

        String[][] error_size_array =
                {{"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4","5"}};

        String[][] error_data_array =
                {{"1","2","3","4"},
                {"1a","2","3","4"},
                {"1a","2","3","4"},
                {"1","2","3","4"}};

        try {
            System.out.println(arraySum(correct_array));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(arraySum(error_size_array));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(arraySum(error_data_array));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
