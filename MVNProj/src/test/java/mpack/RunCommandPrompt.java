package mpack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class RunCommandPrompt {
	public static String command;

//	public RunCommandPrompt(String command) {
//		super();
//		this.command = command;
//	}

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		try {
			// Execute the command and get the process
			Process process = Runtime.getRuntime().exec(command);
			int exitCode = process.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			if (exitCode == 0) {
				System.out.println("success");
			} else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public ArrayList<String> executeCommand() {
		ArrayList<String> cmd = new ArrayList<>();
		try {
			Process process = Runtime.getRuntime().exec(command);
			int exitCode = process.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				cmd.add(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cmd;
	}

}
