import java.util.Scanner;

public class DataStructure <T> {
    private T[] data;
    private int next = 0;

    public DataStructure() {
        this(100);
    }
    private DataStructure(int numberOfListings){
        this.data = (T[]) new Object[numberOfListings];
    }
    private void addElement(T newElement){
        if(this.data.length == next) {
            System.out.print("Object list is full!\n");
        } else {
            this.data[this.next] = newElement;
            this.next++;
        }
    }
    private void showAllElements(){
        if (this.next == 0) {
            System.out.print("The list is empty!\n");
        } else {
            for (int i = 0; i < this.next; i++) {
                System.out.print(this.data[i].toString());
            }
        }
    }

    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        DataStructure myDataStructure = new DataStructure(100);
        System.out.print("Data Structure has been created.\n");

        int userOption = 0;

        while (userOption != 6) {
            System.out.print("What would you like to do?\n");
            System.out.print("1 - View Listings\n");
            System.out.print("2 - Add Listing\n");
            System.out.print("6 - Quit\n");
            userOption = myScanner.nextInt();
            myScanner.reset();

            if (userOption == 1) {
                myDataStructure.showAllElements();
            } else if (userOption == 2) {
                System.out.print("Please enter a name: ");
                String tempName = myScanner.next();
                myScanner.reset();
                System.out.print("Please enter an age: ");
                int tempAge = myScanner.nextInt();
                Listing tempListing = new Listing(tempName, tempAge);
                myDataStructure.addElement(tempListing);
                System.out.print("Listing has been added:\n");
                System.out.print(myDataStructure.data[myDataStructure.next - 1].toString());
                myScanner.reset();
            }

        }
        System.out.print("Thank you for using the Data Structure!");

    }
}
