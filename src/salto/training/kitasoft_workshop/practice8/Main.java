package salto.training.kitasoft_workshop.practice8;

public class Main {
	public static void main(String[] args) {
		Practice.practice4();
	}
}

class Practice {

	public static void practice4() {
		Animal[] animals = new Animal[4];
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				animals[i] = new Cat();
			} else {
				animals[i] = new Dog();
			}
		}
		for (Animal a : animals) {
			a.Speak();
		}
	}

	public static void practice3() {
		Cat cat = new Cat();
		Dog dog = new Dog();

		cat.Name = "クロ";
		cat.Age = 8;
		dog.Name = "コロ";
		dog.Age = 7;

		cat.ShowProfile();
		dog.ShowProfile();

		cat.Speak();
		dog.Speak();
	}

	public static void practice2() {
		Cat cat = new Cat();
		Dog dog = new Dog();

		cat.Name = "ミィ";
		cat.Age = 2;

		dog.Name = "シロ";
		dog.Age = 5;

		cat.ShowProfile();
		dog.ShowProfile();

		cat.Sleep();
		dog.Run();
	}

	public static void practice1() {
		Cat cat = new Cat();
		cat.Name = "タマ";
		cat.Age = 3;
		cat.ShowProfile();
		cat.Sleep();
	}
}


class Animal {
    public String Name;
    public int Age;

    public void ShowProfile() {
        System.out.println( "名前は、" + Name + "、" + Age + "歳です。" );
    }

    public void Speak() {
      System.out.println("......");
    }
}

class Cat extends Animal {

	public void Sleep() {
		System.out.println("スースー");
	}

	@Override
	public void Speak() {
		System.out.println("ニャー");
	}
}

class Dog extends Animal {

	public void Run() {
		System.out.println("トコトコ");
	}

	@Override
	public void Speak() {
		System.out.println("ワンワン");
	}
}