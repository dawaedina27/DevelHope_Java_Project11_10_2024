//Create an Animal Interaction System using an interface, an abstract class, and inheritance.
//
//Steps:
//
//a. Create an Interface AnimalInteraction with the following methods:
//
//void feed(String food);
//void play();
//void showInteractionHistory();
//
//b.Create an Abstract Class SimpleAnimal that implements AnimalInteraction:
//
//Implement the feed method. It should ask for the food provided and store the feeding interaction in a list.
//Implement the play method. When called, it should store "play interaction" in the interaction history.
//Implement the showInteractionHistory method to display all interactions with the animal (both feedings and play sessions).
//Store interaction history using an appropriate data structure, like an ArrayList<String>.
//
//c.Create Concrete Classes:
//
//Extend SimpleAnimal into two classes, such as Dog1 and Cat1, with additional unique behaviors:
//In the Dog1 class, add a method bark() that prints "The dog is barking!".
//In the Cat1 class, add a method meow() that prints "The cat is meowing!".
//
//d.Testing the System:
//
//Create instances of both Dog1 and Cat1, interact with them by feeding and playing with them.
//Display their interaction histories using showInteractionHistory.
//
//Bonus: Add a method void sleep(int hours) to SimpleAnimal where it stores the sleep interaction as "Slept for X hours".

// Create an Animal Interaction System using an interface, an abstract class, and inheritance.
//
//Steps:
//
//a. Create an Interface AnimalInteraction with the following methods:
//
//void feed(String food);
//void play();
//void showInteractionHistory();
//
//b.Create an Abstract Class SimpleAnimal that implements AnimalInteraction:
//
//Implement the feed method. It should ask for the food provided and store the feeding interaction in a list.
//Implement the play method. When called, it should store "play interaction" in the interaction history.
//Implement the showInteractionHistory method to display all interactions with the animal (both feedings and play sessions).
//Store interaction history using an appropriate data structure, like an ArrayList<String>.
//
//c.Create Concrete Classes:
//
//Extend SimpleAnimal into two classes, such as Dog and Cat, with additional unique behaviors:
//In the Dog class, add a method bark() that prints "The dog is barking!".
//In the Cat class, add a method meow() that prints "The cat is meowing!".
//
//d.Testing the System:
//
//Create instances of both Dog and Cat, interact with them by feeding and playing with them.
//Display their interaction histories using showInteractionHistory.
//
//Bonus: Add a method void sleep(int hours) to SimpleAnimal where it stores the sleep interaction as "Slept for X hours".

package Friday_11_10_2024;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a Dog2 object
        Dog2 myDog = new Dog2("my dog Panta");
        myDog.feed("Bones");
        myDog.play();
        myDog.bark();
        myDog.sleep(3);
        myDog.showInteractionHistory();

        System.out.println();

        // Create a Cat object
        Cat myCat = new Cat("my Cat Lavi");
        myCat.feed("fish and milk");
        myCat.play();
        myCat.meow();
        myCat.sleep(1);
        myCat.showInteractionHistory();
    }
}

interface AnimalInteraction1 {
    void feed(String food);
    void play();
    void showInteractionHistory();
}

abstract class SimpleAnimal1 implements AnimalInteraction1 {
    private String name;  // Animal's name
    private List<String> interactionHistory = new ArrayList<>();  // Store interaction history

    // Constructor for SimpleAnimal to set the name
    public SimpleAnimal1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;  // Return the animal's name
    }

    // Helper method to capitalize the first letter of a name
    String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    @Override
    public void feed(String food) {
        if (food == null || food.isEmpty()) {
            System.out.println("No food provided. Please provide some food to feed the animal.");
            return;
        }
        interactionHistory.add("You Fed " + name + " with: " + food);
        System.out.println("You have successfully fed " + name + " with: " + food);
    }

    @Override
    public void play() {
        String timestamp = java.time.LocalDateTime.now().toString();
        String capitalizedAnimalName = capitalizeFirstLetter(getName());
        interactionHistory.add("Played with " + capitalizedAnimalName + " at " + timestamp);
        System.out.println("You played with " + name + " at " + timestamp + ".");
    }

    @Override
    public void showInteractionHistory() {
        String capitalizedAnimalName = capitalizeFirstLetter(getName());
        System.out.println("****** Interaction History of " + capitalizedAnimalName + " *****");

        if (interactionHistory.isEmpty()) {
            System.out.println("No interactions recorded.");
        } else {
            for (int i = 0; i < interactionHistory.size(); i++) {
                System.out.println((i + 1) + ". " + interactionHistory.get(i));
            }
            System.out.println("Total interactions: " + interactionHistory.size());
        }
        System.out.println("***************************");
    }

    public void sleep(int hours) {
        if (hours <= 0) {
            System.out.println("Invalid. Please enter a valid number of hours.");
        } else {
            String capitalizedAnimalName = capitalizeFirstLetter(getName());
            interactionHistory.add(capitalizedAnimalName + " slept for " + hours + " hours");
            System.out.println(capitalizedAnimalName + " slept for " + hours + " hour" + (hours > 1 ? "s." : "."));
        }
    }
}

class Dog2 extends SimpleAnimal1 {
    // Constructor to initialize Dog2 with a name
    public Dog2(String name) {
        super(name);
    }

    // Method specific to Dog2
    public void bark() {
        System.out.println(capitalizeFirstLetter(getName()) + " is barking!");
    }
}

class Cat extends SimpleAnimal1 {
    // Constructor to initialize Cat with a name
    public Cat(String name) {
        super(name);
    }

    // Method specific to Cat
    public void meow() {
        System.out.println(capitalizeFirstLetter(getName()) + " is meowing!");
    }
}
