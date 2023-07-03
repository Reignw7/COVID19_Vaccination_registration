import java.util.Scanner;

/*
Walker
Reign
4144021
CSC211 Practical 2
Citizen class
*/
public class CitizenRegister {
    static Node headNode;
    static int totalRegisteredCitizens;


    public CitizenRegister() {
        headNode = null;
        totalRegisteredCitizens = 0;
    }

    public static Citizen head() {
        if (isEmpty() == true) {
            System.out.println("The list is currently empty");
            return null;
        }

        System.out.println("citizenNumber           " + headNode.getCitizen().getCitizenID());
        System.out.println("citizenName             " + headNode.getCitizen().getCitizenName());
        System.out.println();
        return headNode.getCitizen();
    }



    public static Citizen tail() {

        if (isEmpty() == true) {
            System.out.println("The list is currently empty");
            return null;
        }

        if(headNode.nextNode == null){
            head();
            return headNode.getCitizen();
        }

        Node current = headNode;
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        System.out.println("citizenNumber       " + current.getCitizen().getCitizenID());
        System.out.println("citizenName         " + current.getCitizen().getCitizenName());
        return current.getCitizen();
    }

    public int size() {
        return totalRegisteredCitizens;
    }

    public static boolean isEmpty() {
        if (headNode == null) {
            return true;
        } else {
            return false;
        }

    }

    public static void addCitizenAtHead(Node newNode) {
        if (headNode == null) {
            headNode = newNode;
            headNode.nextNode = null;
            totalRegisteredCitizens++;
            return;
        }

        newNode.nextNode = headNode;
        headNode = newNode;

        totalRegisteredCitizens++;

    }

    public static void addCitizenAtTail(Node newNode) {

        if (headNode == null) {
            headNode = newNode;
            totalRegisteredCitizens++;
            return;
        }

        if (headNode.nextNode == null) {
            headNode.nextNode = newNode;
            newNode.nextNode = null;
            totalRegisteredCitizens++;
            return;
        }

        Node current = headNode;
        while (current.nextNode != null) {
            current = current.nextNode;
        }

        current.nextNode = newNode;
        newNode.nextNode = null;

        totalRegisteredCitizens++;
    }

    public static void addCitizenBefore(String citizenID, Node newNode) {
        if(isEmpty()){
            System.out.println("Citizen has not registered for vaccine...Adding new citizen at end of list");
            addCitizenAtTail(newNode);
            return;
        }
        if (headNode.getCitizen().getCitizenID().equals(citizenID)) {
            addCitizenAtHead(newNode);
        }
        if(headNode.nextNode ==null){
            System.out.println("Citizen has not registered for vaccine...Adding new citizen at end of list");
            addCitizenAtTail(newNode);
            return;
        }
        Node current = headNode;
        while (!current.nextNode.getCitizen().getCitizenID().equals(citizenID)) {
            current = current.nextNode;
        }

        if (current.nextNode.getCitizen().getCitizenID().equals(citizenID)) {
            newNode.nextNode = current.nextNode;
            current.nextNode = newNode;
        } else {
            System.out.println("Citizen has not registered for vaccine...Adding new citizen at end of list");
            addCitizenAtTail(newNode);
        }

        totalRegisteredCitizens++;
    }

    public static void addCitizenAfter(String citizenID, Node newNode) {
        if (isEmpty()) {
            System.out.println("Citizen has not registered for vaccine...Adding new citizen at end of list");
            addCitizenAtTail(newNode);
            return;
        }

        if(headNode.getCitizen().getCitizenID().equals(citizenID)){
            newNode.nextNode = headNode.nextNode;
            headNode.nextNode = newNode;
            totalRegisteredCitizens++;
            return;
        }
        Node current = headNode;
        while (!current.getCitizen().getCitizenID().equals(citizenID)) {
            current = current.nextNode;
        }
        if (current.getCitizen().getCitizenID().equals(citizenID)) {
            newNode.nextNode = current.nextNode;
            current.nextNode = newNode;
        } else {
            System.out.println("Citizen has not registered for a vaccine");
            addCitizenAtTail(newNode);
        }



    }

    public static void removeCitizen(String citizenID) {
        if(headNode == null){
            System.out.println("The list is currently empty");
            return;
        }

        if(headNode.getCitizen().getCitizenID().equals(citizenID)){
            removeFirstCitizen();
            return;
        }

        if(!headNode.getCitizen().getCitizenID().equals(citizenID) || headNode.nextNode==null){
            System.out.println("Citizen has not registered for vaccine");
            return;
        }

        Node current = headNode;
        while (!current.getCitizen().getCitizenID().equals(citizenID)){
            current = current.nextNode;
        }
        Node prevNode =headNode;
        while (!prevNode.nextNode.getCitizen().getCitizenID().equals(citizenID)){
            prevNode = prevNode.nextNode;
        }
        if (current.getCitizen().getCitizenID().equals(citizenID)) {
            prevNode.nextNode = current.nextNode;
            totalRegisteredCitizens--;
            return;
        } else {
            System.out.println("Citizen has not registered for vaccine");
        }

    }

    public static void removeLastCitizen() {
        if(headNode ==null){
            return;
        }

        if(headNode.nextNode == null){
            headNode = null;
            totalRegisteredCitizens--;
            return;
        }

        Node current = headNode;
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        Node tail = current;
        current = headNode;
        while (current.nextNode != tail) {
            current = current.nextNode;
        }

        current.nextNode = null;
        tail = null;

        totalRegisteredCitizens--;
    }

    public static void removeFirstCitizen() {
        if (headNode != null) {
            headNode = headNode.nextNode;
            totalRegisteredCitizens--;
            return;
        }


    }

    public static void displayAllCitizens() {

        if(isEmpty() == true){
            System.out.println("The list is currently empty...");
            return;
        }

        Node current = headNode;
        while (current.nextNode != null) {
            System.out.println("citizenNumber       " + current.getCitizen().getCitizenID());
            System.out.println("citizenName         " + current.getCitizen().getCitizenName());

            current = current.nextNode;
        }
        tail();
    }

        /*

        //Allows user to create a Citizen object
        public static Citizen createCitizen() {
            //Allow user to input information
            //returns created Citizen object
            return newCitizen;


         */



    public static void mainMenu(){
        System.out.println("Welcome to the Covid vaccine registration program");
        System.out.println("Enter numbers: ");
        System.out.println("1           Show the first citizen registered");
        System.out.println("2           Show the last citizen registered");
        System.out.println("3           Show the total amount of citizen registered");
        System.out.println("4           Show whether the list is empty");
        System.out.println("5           Add a citizen in front of the list");
        System.out.println("6           Add a citizen at the end of the list");
        System.out.println("7           Add a citizen before a given ID");
        System.out.println("8           Add a citizen after a given ID");
        System.out.println("9           Remove citizen with the given ID");
        System.out.println("10           Remove last citizen");
        System.out.println("11           Remove first citizen");
        System.out.println("12          Show all citizens in the list");
        System.out.println("13           Any other integers to Quit.");
        System.out.println(" ");
    }


    public static void main(String[] args) {
        CitizenRegister list = new CitizenRegister();
        Scanner scan = new Scanner(System.in);
        while (true) {

            System.out.println("");
            //Shows menu of program and gives user options
            mainMenu();
            int option = scan.nextInt();

            if (option > 12 || option <1) {
                System.out.println("Program terminated due to invalid input. Thanks for using our system.");
                break;
            }

            if(option == 1){
                head();
            }

            if(option == 2){
                tail();
            }

            //Shows the total number of citizens in the list
            if(option == 3){
                System.out.println(totalRegisteredCitizens);
            }
            //Shows whether the list is empty
            if(option == 4){
                System.out.println(isEmpty());
            }

            //Adds a node at the front of the list
            if (option == 5) {
                //Creates new citizen object to be added to node
                Citizen newCitizen = new Citizen();
                //Adding citizen information
                System.out.println("Enter citizen ID: ");
                newCitizen.setCitizenID(scan.next());
                System.out.println("Enter citizen name: ");
                newCitizen.setCitizenName(scan.next());
                System.out.println("Enter citizen surname: ");
                newCitizen.setCitizenSurname(scan.next());
                System.out.println("Enter citizen cellphone number: ");
                newCitizen.setCitizenCellNumber(scan.next());
                System.out.println("Enter citizen registration day: ");
                newCitizen.setRegistrationDay(scan.nextInt());
                System.out.println("Enter citizen registration month: ");
                newCitizen.setRegistrationMonth(scan.nextInt());
                System.out.println("Enter citizen registration day: ");
                newCitizen.setRegistrationYear(scan.nextInt());
                Node newNode = new Node(newCitizen); // Creates the new node that will be paired with the created citizen object
                addCitizenAtHead(newNode);
            }

            //Adds a node at the tail of the list
            if(option == 6){
                //Creates new citizen object to be added to node
                Citizen newCitizen = new Citizen();
                //Adding citizen information
                System.out.println("Enter citizen ID: ");
                newCitizen.setCitizenID(scan.next());
                System.out.println("Enter citizen name: ");
                newCitizen.setCitizenName(scan.next());
                System.out.println("Enter citizen surname: ");
                newCitizen.setCitizenSurname(scan.next());
                System.out.println("Enter citizen cellphone number: ");
                newCitizen.setCitizenCellNumber(scan.next());
                System.out.println("Enter citizen registration day: ");
                newCitizen.setRegistrationDay(scan.nextInt());
                System.out.println("Enter citizen registration month: ");
                newCitizen.setRegistrationMonth(scan.nextInt());
                System.out.println("Enter citizen registration day: ");
                newCitizen.setRegistrationYear(scan.nextInt());
                // Creates the new node that will be paired with the created citizen object
                Node newNode = new Node(newCitizen);
                addCitizenAtTail(newNode);
            }

            if(option == 7){
                //Creates new citizen object to be added to node
                Citizen newCitizen = new Citizen();
                //Adding citizen information
                System.out.println("Enter citizen ID: ");
                newCitizen.setCitizenID(scan.next());
                System.out.println("Enter citizen name: ");
                newCitizen.setCitizenName(scan.next());
                System.out.println("Enter citizen surname: ");
                newCitizen.setCitizenSurname(scan.next());
                System.out.println("Enter citizen cellphone number: ");
                newCitizen.setCitizenCellNumber(scan.next());
                System.out.println("Enter citizen registration day: ");
                newCitizen.setRegistrationDay(scan.nextInt());
                System.out.println("Enter citizen registration month: ");
                newCitizen.setRegistrationMonth(scan.nextInt());
                System.out.println("Enter citizen registration day: ");
                newCitizen.setRegistrationYear(scan.nextInt());
                // Creates the new node that will be paired with the created citizen object
                Node newNode = new Node(newCitizen);
                System.out.println("Enter the Citizens ID that you want to be inserted before: ");
                String citizenID = scan.next();
                //Adds the new node before the specified citizen
                addCitizenBefore(citizenID, newNode);
            }

            if(option == 8 ){
                //Creates new citizen object to be added to node
                Citizen newCitizen = new Citizen();
                //Adding citizen information
                System.out.println("Enter citizen ID: ");
                newCitizen.setCitizenID(scan.next());
                System.out.println("Enter citizen name: ");
                newCitizen.setCitizenName(scan.next());
                System.out.println("Enter citizen surname: ");
                newCitizen.setCitizenSurname(scan.next());
                System.out.println("Enter citizen cellphone number: ");
                newCitizen.setCitizenCellNumber(scan.next());
                System.out.println("Enter citizen registration day: ");
                newCitizen.setRegistrationDay(scan.nextInt());
                System.out.println("Enter citizen registration month: ");
                newCitizen.setRegistrationMonth(scan.nextInt());
                System.out.println("Enter citizen registration day: ");
                newCitizen.setRegistrationYear(scan.nextInt());
                // Creates the new node that will be paired with the created citizen object
                Node newNode = new Node(newCitizen);
                System.out.println("Enter the Citizens ID that you want to be inserted after: ");
                String citizenID = scan.next();
                //Adds the new node after the specified citizen
                addCitizenAfter(citizenID, newNode);
            }



            if(option == 9){
                System.out.println("Enter the Citizens ID that you want to be deleted: ");
                String citizenID = scan.next();
                removeCitizen(citizenID);
            }

            if(option == 10){
                removeLastCitizen();
            }

            if(option == 11){
                removeFirstCitizen();
            }

            //Shows all citizens in the list
            if (option == 12) {
                //Function to display all citizens in register
                displayAllCitizens();
                System.out.println("");
            }


        }
    }
}
