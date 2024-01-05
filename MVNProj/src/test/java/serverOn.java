import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class serverOn {

	public static void main(String[] args) {
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(serviceBuilder);
		service.start();
		// Rest of your test script
		System.out.println("done");
		service.stop();

	}

}
