import java.util.Scanner;

public class Listing {

    private String name;
    private int age;

    public Listing() {
        setName("");
        setAge(0);
    }
    public Listing(String n, int a) {
        setName(n);
        setAge(a);
    }
    public String toString(){
        String tempString = "";
        tempString += "Name:"+getName()+"  Age:"+getAge()+"\n";
        return tempString;
    }
    public void input(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Please enter a name: ");
        setName(myScanner.nextLine());
        System.out.print("Please enter an age: ");
        setAge(myScanner.nextInt());
    }
    public void setName(String sName) {
        name = sName;
    }
    public void setAge(int iAge) {
        age = iAge;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
