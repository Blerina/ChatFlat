package ChatFlatAPI;

import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChatFlatProvider implements Provider {

	private static final String baseUrl = "https://chatflat.herokuapp.com";

	@Override
	public Conversation createConversation() {
		Conversation conversation = null;
		
		try {
			HttpResponse<String> response = APIRequester.sendPost(baseUrl, "/conversations", new HashMap<String, String>());
			if (response.statusCode() == 201) {
				// map json response to conversation object
				ObjectMapper mapper = new ObjectMapper();
				conversation = mapper.readValue(response.body(), Conversation.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conversation;
	}

	@Override
	public List<Conversation> getConversations() {
		List<Conversation> conversations = Collections.emptyList();

		try {
			HttpResponse<String> response = APIRequester.sendGet(baseUrl, "/conversations");
			if (response.statusCode() == 200) {
				// map json response to conversation objects
				ObjectMapper mapper = new ObjectMapper();
				conversations = mapper.readValue(response.body(),
						mapper.getTypeFactory().constructCollectionType(List.class, Conversation.class));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conversations;
	}

	@Override
	public Message createMessage(String conversationId) {
		
		String url = "/conversations/" + conversationId + "/messages";
		Map<String, String> payload = new HashMap<String,String>();
		payload.put("name", "Andrew");
		payload.put("text", "Hi There!");
		
		Message message = null;
		
		try {
			HttpResponse<String> response = APIRequester.sendPost(baseUrl, url, payload);
			if (response.statusCode() == 201) {
				// map json response to message object
				ObjectMapper mapper = new ObjectMapper();
				message = mapper.readValue(response.body(), Message.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}

}
