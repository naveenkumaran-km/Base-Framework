import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetResponseHeader {
	public static void main(String[] args) {

		try {
			String url = "https://petstore.octoperf.com/actions/Catalog.action"; 
			URL obj = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

			// Set up the request method and other properties
			connection.setRequestMethod("GET");

			int responseCode = connection.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) {
				// Get the response headers
				String headerName = "Catalog.action"; 
				String headerValue = connection.getHeaderField(headerName);

				if (headerValue != null) {
					System.out.println(headerName + ": " + headerValue);
				} else {
					System.out.println("Header not found: " + headerName);
				}

				
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				System.out.println("Response Content: " + response.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
