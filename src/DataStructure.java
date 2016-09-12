import java.util.Scanner;

public class DataStructure {
    private Listing[] data;
    private int size = 100;
    private int next = 0;

    public DataStructure() {
        new DataStructure(this.size);
    }
    public DataStructure(int numberOfListings){
        this.data = new Listing[numberOfListings];
        for(int i=0; i<numberOfListings; i++) {
            this.data[i] = new Listing();
        }
    }
    public void addListing(Listing newListing){
        if(size == next) {
            System.out.print("Listings are full!\n");
        } else {
            int tempAge = newListing.getAge();
            this.data[this.next].setName(newListing.getName());
            this.data[this.next].setAge(newListing.getAge());
            next++;
        }
    }
    public void showAllListings(){
        if (this.next == 0) {
            System.out.print("The list is empty!\n");
        } else {
            for (int i = 0; i < this.next; i++) {
                if ("" != this.data[i].getName()) {
                    System.out.print(this.data[i].toString());
                }
            }
        }
    }


    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        DataStructure myDataStructure = new DataStructure(100);
        System.out.print("Data Structure has been created.\n");

        int userOption = 5;

        while (userOption != 6) {
            System.out.print("What would you like to do?\n");
            System.out.print("1 - View Listings\n");
            System.out.print("2 - Add Listing\n");
            System.out.print("3 - Modify Listing\n");
            System.out.print("6 - Quit\n");
            userOption = myScanner.nextInt();
            myScanner.reset();

            if (userOption == 1) {
                myDataStructure.showAllListings();
            } else if (userOption == 2) {
                System.out.print("Please enter a name: ");
                String tempName = myScanner.next();
                myScanner.reset();
                System.out.print("Please enter an age: ");
                int tempAge = myScanner.nextInt();
                myScanner.reset();
                Listing tempListing = new Listing(tempName, tempAge);
                myDataStructure.addListing(tempListing);
                System.out.print("Listing has been added:\n");
                System.out.print(myDataStructure.data[myDataStructure.next - 1].toString());
            } else if (userOption == 3) {
                boolean listingFound = false;
                System.out.print("Enter name of listing to change: ");
                String tempName = myScanner.next();
                myScanner.reset();
                System.out.print("Confirm the listing age: ");
                int tempAge = myScanner.nextInt();
                myScanner.reset();
                for (int i=0; i<100 ; i++) {
                    if ((listingFound == false) && (myDataStructure.data[i].getName().equals(tempName)) && (myDataStructure.data[i].getAge() == tempAge)) {
                        System.out.print("Listing found:\n");
                        System.out.print(myDataStructure.data[i].toString());
                        System.out.print("Please enter the new name: ");
                        tempName = myScanner.next();
                        myScanner.reset();
                        System.out.print("Please enter the new age: ");
                        tempAge = myScanner.nextInt();
                        myScanner.reset();
                        myDataStructure.data[i].setName(tempName);
                        myDataStructure.data[i].setAge(tempAge);
                        System.out.print("Listing updated:\n");
                        System.out.print(myDataStructure.data[i].toString());
                        listingFound = true;
                    }
                }
                if (listingFound == false) {
                    System.out.print("Listing not found!\n");
                }
            }

        }
        System.out.print("Thank you for using the Data Structure!");

    }
}
