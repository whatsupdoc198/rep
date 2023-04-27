import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class hannagan_lab13 {

    private ArrayList<Integer> rep = new ArrayList<>();
    
    public void readData(String filename){

        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            rep = new ArrayList<>();

            String currentLine;

            while((currentLine = input.readLine()) != null){
                rep.add(Integer.parseInt(currentLine.trim()));
            }

            input.close();
        }
        
        catch (Exception e){
            System.out.println(e.toString() + "oops, didn't work - sorry!");
        }
    }

    public long getTotalCount(){
        return rep.stream().count();
    }

    public long getOddCount(){
        return rep.stream().filter(x -> (x+1) % 2 == 0).count();
    }

    public long getEvenCount(){
        return rep.stream().filter(x -> x % 2 == 0).count();
    }

    public long getDistinctGreaterThanFiveCount(){
        return rep.stream().filter(x -> x > 5).distinct().count();
    }

    public Integer[] getResult1(){
        return rep.stream().filter(x -> x < 50 && x > 5 && x % 2 == 0).sorted().toArray(Integer[]:: new);
    }

    public Integer[] getResult2(){
        return rep.stream().mapToInt( x -> x * x * 3).limit(50).boxed().toArray(Integer[]::new);
    }

    public Integer[] getResult3(){
        return rep.stream().filter( x -> (x+1) % 2 == 0).mapToInt( x -> x * 2).sorted().skip(20).distinct().boxed().toArray(Integer[]::new);
    }

    public static void main (String[] args){
        //nothing here
    }
}

