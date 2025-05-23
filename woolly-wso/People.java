package woollywso;

import java.util.*; 
import java.io.*; 

public class People {

		public ArrayList<Person> peopleList = new ArrayList<>();


		public People(String filePath) {
			injestData(filePath);
		}

		public void injestData(String fp) {
			try {
				String filePath = fp;
				File file = new File(filePath);
				Scanner scanner = new Scanner(file);
				scanner.nextLine();

				while (scanner.hasNextLine()) {

					String fullLine = scanner.nextLine();
					System.out.println(fullLine);

					String[] fullLineSplit = fullLine.split("\\*");

					for (int i = 0; i < fullLineSplit.length; i++) {
						System.out.println(fullLineSplit[i]);
					}

					String name = fullLineSplit[0];

					String unix = fullLineSplit[1];

					String type = fullLineSplit[2];

					int classYear = -1;

					if (!fullLineSplit[3].equals("null")) {
						classYear = Integer.parseInt(fullLineSplit[3]);
					}

					String homeTown = "";

					if (!fullLineSplit[4].equals("null")) {
						homeTown = fullLineSplit[4];
					}

					String homeState = "";

					if (!fullLineSplit[5].equals("null")) {
						homeState = fullLineSplit[5];
					}

					String homeCountry = "";

					if (!fullLineSplit[6].equals("null")) {
						homeCountry = fullLineSplit[6];
					}



					Person newPerson = new Person(name, unix, type, classYear, homeTown, homeState, homeCountry);

					peopleList.add(newPerson);

				}
			} catch (FileNotFoundException e) {
				System.err.println("File not found: " + e.getMessage());
			}
		}


		public static void main (String[] args) {

			People allPeople = new People("woolly-wso/data.csv");

			// for (int i = 0; i < allPeople.peopleList.size(); i++) {
			// 	System.out.println(allPeople.peopleList.get(i).toString());
			// }

			
		}






}