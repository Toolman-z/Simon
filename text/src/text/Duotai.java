package text;

public class Duotai {
	
		
		public void speak(Human person)
		{
			if(person instanceof Chinese)
			{
				System.out.println("½²ÖÐÎÄ");
			}
			if(person instanceof Ua)
			{
				System.out.println("speak English");
			}
			person.speak();
		}


	}

