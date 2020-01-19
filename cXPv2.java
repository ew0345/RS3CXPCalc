import java.util.Scanner;

public class cXPv2 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			info();
			System.out.println("1 - Start, 2 - Exit");
			System.out.print(":");
			int ans = in.nextInt();

			switch (ans) {
				case 1: appli();
					break;
				case 2: break;
				default: 
					System.out.print("Invalid Input.");
					main(args);
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void appli() {
		try (Scanner in = new Scanner(System.in)) {

			System.out.print("Using Wisdom Aura? (y/n): ");
			String wisaura = in.nextLine();

			System.out.print("Portable Range? (y/n): ");
			String port = in.nextLine();

			System.out.print("Using Pulse Cores? (y/n): ");
			String pc = in.nextLine();

			System.out.print("Pulse Core Percent Boost (0 - 10): ");
			double pcper = in.nextDouble();

			System.out.print("Sou Chef's Outfit Pieces (0-5): ");
			double scout = in.nextDouble();

			System.out.print("XP From Item: ");
			double ixp = in.nextDouble();

			double xp = ixp;
			
			if (wisaura.equalsIgnoreCase("y") || wisaura.equalsIgnoreCase("yes")) {
					xp = xp + (xp * 0.025);
			}

			if (port.equalsIgnoreCase("y") || port.equalsIgnoreCase("yes")) {
				xp = xp + (xp * 0.21);
			}
			
			if (pcper >= 1 && pcper <= 10) {
				xp = xp + (xp * (pcper / 100));
			}
			
			if (scout > 0 && scout < 5) {
				xp = xp + (xp * (scout / 100));
			} else if (scout == 5) {
				xp = xp + (xp * 0.06);
			}
			
			if (pc.equalsIgnoreCase("y") || pc.equalsIgnoreCase("yes")) {
				xp = xp + (xp * 0.50);
			}

			System.out.println("Item XP: "+(int) xp+" xp");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void info() throws Exception {
		cmd();
		System.out.println("Made by: Ew0345");
		System.out.println("Version: 2.0");
		System.out.println("Calculates the xp a item will give when cooked based off of:\n"
			+"Base Item XP, Wisdom Aura (+2.5%), Portable Range (+21%), Pulse Core (+50%), Pulse Core Boost (+0-10%)"
			+",\nand Sou Chef Outfit Pieces (+0-6%).\n\n");
	}

	public static void cmd() throws Exception {
		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		new ProcessBuilder("cmd","/c","title RS3 Cooking XP Calculator by Ew0345").inheritIO().start().waitFor();
	}
}