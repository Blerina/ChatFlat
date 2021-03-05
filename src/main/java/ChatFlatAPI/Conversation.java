package ChatFlatAPI;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Conversation {
	
    @JsonProperty("_id")
	private String id;
	private String createdAt;
	private List<Message> messages;
	
	public String getId() {
		return id;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void printMessages() {
		for(Message m : messages) {
			System.out.println(m.toString());
		}
	}
	
}
