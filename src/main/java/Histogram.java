import java.util.Arrays;
import java.util.HashMap;

public class Histogram
{
    static void arrayElementCount(int inputArray[])
    {
        //Creating a HashMap object with elements of inputArray as keys and their count as values
        HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();

        //checking every element of the inputArray
        for (int i : inputArray)
        {
            //System.out.println("I value : "+ i);
            if(elementCountMap.containsKey(i))
            {
                //If element is present in elementCountMap, incrementing it's count by 1
                elementCountMap.put(i, elementCountMap.get(i)+1);
            }
            else
            {
                //If element is not present in elementCountMap,
                //adding this element to elementCountMap with 1 as it's value
                elementCountMap.put(i, 1);
            }
        }

        System.out.println("Input Array : "+Arrays.toString(inputArray));
        System.out.println("Element Count : "+elementCountMap);

        for (int j : elementCountMap.keySet()) {
            //System.out.println(j + " = " + elementCountMap.get(j));
            //System.out.println("each element count " + elementCountMap.get(j)/2);
            System.out.print("RandNum " + j + ":");
            for(int i = 0; i < elementCountMap.get(j)/20; i++)
            {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args)
    {
        //Generates 10 Random Numbers in the range 1 -20
        int[] numbers = new int[2000];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random()*255 + 1);
        }
        arrayElementCount(numbers);
    }
}