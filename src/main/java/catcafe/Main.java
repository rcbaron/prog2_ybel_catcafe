package catcafe;
import tree.*;

/** Starter for the cat-café task. */
public class Main {
    /**
     * And go.
     *
     * @param args command line parameters, not used
     */
    public static void main(String... args) {
        CatCafe cafe = new CatCafe();

        cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));
        cafe.addCat(new FelineOverLord("Gwenapurr Esmeralda", 3));
        cafe.addCat(new FelineOverLord("Morticia", 3));
        cafe.addCat(new FelineOverLord("Fitzby Darnsworth", 5));

        System.out.println("Es schnurren " + cafe.getCatCount() + " Samtpfoetchen.");

        cafe.getCatByWeightOptional(2,3).ifPresent(
            cat -> System.out.println("Gewicht [3,4]: " + cat)
        );

        cafe.getCatByNameOptional("Morticia").ifPresent(
            cat -> System.out.println("Name: 'Morticia': " + cat)
        );

        cafe.getCatByNameOptional("Miss Chief Sooky").ifPresent(
            cat -> System.out.println("Name: 'Miss Chief Sooky': " + cat)
        );

        InOrderVisitor<FelineOverLord> inorder = new InOrderVisitor<>();
        PostOrderVisitor<FelineOverLord> postorder = new PostOrderVisitor<>();
        System.out.println("-------------------------------------------");
        System.out.println("Inorder: " + cafe.accept(inorder));
        System.out.println("Postorder: " + cafe.accept(postorder));
    }
}
