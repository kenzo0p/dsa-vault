package multipleInheritance;

public class HybridExample {

    // Interface 1
    interface Cat {
        void catSound();
    }

    // Interface 2
    interface Dog {
        void dogSound();
    }

    // Class implementing both interfaces
    static class HybridAnimal implements Cat, Dog {

        @Override
        public void catSound() {
            System.out.println("Meow");
        }

        @Override
        public void dogSound() {
            System.out.println("Bark");
        }
    }

    // Main method
    public static void main(String[] args) {
        HybridAnimal hybrid = new HybridAnimal();
        
        hybrid.catSound();
        hybrid.dogSound();
    }
}

