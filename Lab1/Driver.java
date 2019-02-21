package Lab1;

public class Driver {
    public static void main(String[] args) {
        Model model1 = new Model("Susan","Smith",70,55,true,false);

        Model model2 = new Model("Tiger","Woods",71,80,false,true);

        Model model3 = new Model("Alex","Han",70,170);

        Model model4 = new Model("asd","asd",3,12);

        System.out.println("\n6 parameters, imperial");
        model2.displayModelDetails();
        System.out.println("\n6 parameters, metric");
        model2.displayModelDetails(true);
        System.out.println("\n4 parameters, imperial");
        model3.displayModelDetails();
        System.out.println("\n4 parameters, metric");
        model3.displayModelDetails(true);



    }
}
